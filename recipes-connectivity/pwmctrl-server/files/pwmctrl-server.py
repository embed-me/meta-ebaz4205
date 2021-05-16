import asyncio
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel

NUM_PWM = 2
PWMCHIP = "pwmchip0"

app = FastAPI(title="PWM Control Server",
              description=f"Allows control over {NUM_PWM} linux PWM devices on {PWMCHIP} using sysfs",
              version="0.1.0")

class PwmState(BaseModel):
    enabled: bool
    duty_cycle: int
    polarity: str


def prepare_pwms():
    for i in range(0, NUM_PWM):
        write_sysfs_pwm(f"{PWMCHIP}/export", str(i))
        write_sysfs_pwm(f"pwm{i}/period", str(1000000))
        write_sysfs_pwm(f"pwm{i}/duty_cycle", str(1000000))
        write_sysfs_pwm(f"pwm{i}/polarity", "inversed")
        write_sysfs_pwm(f"pwm{i}/enable", str(0))

def unprepare_pwms():
    for i in range(0, NUM_PWM):
        write_sysfs_pwm(f"{PWMCHIP}/unexport", str(i))
    
@app.on_event("startup")
async def startup_event():
    prepare_pwms()

@app.on_event("shutdown")
async def shutdown_event():
    unprepare_pwms()


def read_pwm_state(nr: int):
    dc = int(read_sysfs_pwm(f"pwm{nr}/duty_cycle"))
    state = PwmState(
        duty_cycle = int(dc/10000),
        enabled    = read_sysfs_pwm(f"pwm{nr}/enable")[0] == '1',
        polarity   = read_sysfs_pwm(f"pwm{nr}/polarity"))
    return state

def write_sysfs_pwm(dev, param):
    try:
        with open("/sys/class/pwm/" + dev, 'w') as f:
            f.write(param)
    except IOError:
        raise HTTPException(status_code=400,
                            detail=f"Failed to write {param} to pwm device {dev}")

def read_sysfs_pwm(dev):
    try:
        with open("/sys/class/pwm/" + dev, 'r') as f:
            tmp = f.read()
    except IOError:
        raise HTTPException(status_code=400,
                            detail=f"Failed to read from pwm device {dev}")
    return tmp

@app.get("/pwm/{nr}/status", response_model=PwmState)
async def pwm_status(nr: int):
    return read_pwm_state(nr)

@app.put("/pwm/{nr}/enable", response_model=PwmState)
async def pwm_enable(nr: int):
    write_sysfs_pwm(f"pwm{nr}/enable", "1")
    return read_pwm_state(nr)
    
@app.put("/pwm/{nr}/disable", response_model=PwmState)
async def pwm_disable(nr: int):
    write_sysfs_pwm(f"pwm{nr}/enable", "0")
    return read_pwm_state(nr)
    
@app.put("/pwm/{nr}/duty_cycle/{val}", response_model=PwmState)
async def pwm_duty_cycle(nr: int, val: int):
    if val in range (0, 101):
        dc = int(val/100 * 1000000)
        write_sysfs_pwm(f"pwm{nr}/duty_cycle", str(dc))
    else:
        raise HTTPException(status_code=400, detail=f"Duty-Cycle {val} out of range!")
    return read_pwm_state(nr)
