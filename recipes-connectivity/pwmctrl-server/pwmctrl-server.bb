SUMMARY = "Provide access to PWM modules through ASCI Server on port 8000"
HOMEPAGE = "https://embed-me.com"

LICENSE = "GPL-3.0"
#LICENSE_PATH = "${LAYERDIR}/files/common-licenses"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

FILESEXTRAPATHS_append := "${THISDIR}/files:"

inherit systemd

SRC_URI_append = "file://pwmctrl-server.py \
	       	  file://pwmctrl-server.service"

S = "${WORKDIR}"

FILES_${PN} += "${bindir} ${systemd_unitdir}/system"

RDEPENDS_${PN} += "python3 \
	           python3-uvicorn \
	           python3-fastapi"

do_install_append () {
        install -d ${D}${bindir}
	install -m 0755 ${S}/*.py ${D}${bindir}

        install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${S}/*.service ${D}${systemd_unitdir}/system
}