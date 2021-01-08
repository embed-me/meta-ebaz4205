# meta-ebaz4205

The EBAZ4205 was originally developed as cryptomining control board.
Due to it's low price on the marked it is also perfect to learn
the Zynq platform. This meta-layer provides everything to build
a linux system with basic BSP (Board Support Package).

## Maintainer

	Lukas Lichtl (admin@embed-me.com)

## Dependencies

This layer depends on:

	URI: git://git.yoctoproject.org/poky
	branch: zeus

	URI: https://github.com/Xilinx/meta-xilinx.git
	branch: zeus

	URI: https://github.com/Xilinx/meta-xilinx-tools.git
	branch: rel-v2020.1

	URI: https://github.com/openembedded/meta-openembedded.git
	branch: zeus

## Integration

1. Add the meta-ebaz4205 layer to your build
2. Copy meta-ebaz4205/conf/.templateconf to the poky root dir
3. Source the environment and build

## Images

The following images are predefined:
- ebaz4205-image-minimal
- ebaz4205-image-standard
- ebaz4205-image-standard-wic

## Installation

The simpest way to install and test the output products of your
build is the WIC image. Copy it on an SD-Card and you should be
good to go:

    dd if=ebaz4205-image-standard-ebaz4205-zynq7.wic of=/dev/<dev> bs=4096

## BSP Details

### FSBL(First Stage Bootloader)

Configures the Bitstream

### U-Boot(Second Stage Bootloader)

Tailored for SD-Boot, since this is how the board is mainly used.
Wait time during boot is set to zero. In order to interrupt the
boot process, press and hold Button S2 during boot and you will
end up in the u-boot console.

In order to identify boot issues, the following LED codes are.

| LED red | LED green | Boot State | Description           |\
|---------+-----------+------------+-----------------------|\
| on      | on        |          0 | init/pwr up           |\
| on      | off       |          1 | Bitstream config done |\
| off     | on        |          2 | DDR load done         |\
| off     | off       |          3 | -                     |

### Linux

#### Credentials

The systems default credentials are `root` / `root`.

#### Ethernet

The phy on the board supports 10/100Mbit and the image
provides an ssh-server. This allows you to connect to
the board without the use of the serial console.

#### LEDs

In order to identify that linux was booted as intended and
the system is running, the green LED provides a heartbeat.

| LED red | LED green | Boot State | Description |\
|---------+-----------+------------+-------------|\
| off     | heartbeat |          0 | init done   |

#### Mount Points

The boot partition is mounted on `/media/mmcplk0p1`.
This allows access to the boot files while the system
is running (eg. to modify uEnv.txt or provide updates).

#### Buttons

Button presses can be detected in user-space
using `/dev/input/event0`.

#### LEDs

Both LEDs on the front (green, red) are accessable
from within user space `/sys/class/leds`.