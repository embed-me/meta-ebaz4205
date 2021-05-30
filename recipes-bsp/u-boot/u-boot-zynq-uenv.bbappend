def uenv_populate(d):
    # populate the environment values
    env = {}

    env["machine_name"] = d.getVar("MACHINE")

    env["kernel_image"] = d.getVar("KERNEL_IMAGETYPE")
    env["loadkernel"] = "load mmc 0 ${kernel_load_address} ${kernel_image}"

    # TODO: The previous xilinx-method did not work well, hardcode it for now...
    env["devicetree_image"] = "ebaz4205-zynq7.dtb"
    env["loaddtb"] = "load mmc 0 ${devicetree_load_address} ${devicetree_image}"

    # TODO: Hardcoding, not nice. Is there any way to know the image that is currently build
    #       in another recipe?
    env["ramdisk_image"] = "ebaz4205-image-standard-ebaz4205-zynq7.cpio.gz.u-boot"
    env["loadramdisk"] = "load mmc 0 ${ramdisk_load_address} ${ramdisk_image}"
    
    env["bootargs"] = d.getVar("KERNEL_BOOTARGS")

    bitstream, bitstreamtype = boot_files_bitstream(d)
    if bitstream:
        env["bitstream_image"] = bitstream.strip()

        # if bitstream is "bit" format use loadb, otherwise use load
        env["bitstream_type"] = "loadb" if bitstreamtype else "load"

        # load bitstream first with loadfpa
        env["fpga_config"] = "fpga ${bitstream_type} 0 ${bitstream_load_address} ${filesize}"

    return env

# bootargs, default to booting with the rootfs device being partition 2 of the first mmc device
KERNEL_BOOTARGS_zynq = "earlyprintk console=ttyPS0,115200 root=/dev/mmcblk0p2 rw rootwait uio_pdrv_genirq.of_id=generic-uio"
KERNEL_BOOTARGS_zynqmp = "earlycon clk_ignore_unused root=/dev/mmcblk0p2 rw rootwait uio_pdrv_genirq.of_id=generic-uio"
