SUMMARY = "Xilinx Virtual Cable (XVC)"
DESCRIPTION = "Xilinx Virtual Cable (XVC) is a TCP/IP-based protocol that acts like a JTAG cable and provides a means to access and debug your FPGA or SoC design without using a physical cable."
SECTION = "debug"
LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7bae63a234e80ee7c6427dce9fdba6cc"

inherit systemd

SRC_URI = "git://github.com/Xilinx/XilinxVirtualCable.git;branch=master;subpath=zynq7000/XAPP1251/src;protocol=https \
	  file://xvc-syn-fix.patch \
          file://xvc-server.service \
	  "
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/src"

FILES_${PN} += "${bindir}"
FILES_${PN}-dbg += "${bindir}/.debug"

SYSTEMD_SERVICE_${PN} += "xvc-server.service"

do_compile() {
	     ${CC} ${LDFLAGS} xvcServer.c -Os -o xvc_server
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 ${S}/xvc_server ${D}${bindir}
	     
	     install -d ${D}${systemd_unitdir}/system
	     install -m 0644 ${WORKDIR}/xvc-server.service ${D}${systemd_unitdir}/system
}
