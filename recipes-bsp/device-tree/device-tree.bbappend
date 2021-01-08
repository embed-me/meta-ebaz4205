FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE_ebaz4205-zynq7 = ".*"
SRC_URI_append_ebaz4205-zynq7 = " \
                file://ebaz4205-zynq7.dts \
		file://ebaz4205-board.dtsi \
                file://ebaz4205-pl.dtsi \
                "