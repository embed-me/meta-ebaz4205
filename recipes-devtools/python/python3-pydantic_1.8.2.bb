SUMMARY = "Data validation and settings management using python 3.6 type hinting"
HOMEPAGE = "https://pydantic-docs.helpmanual.io/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c02ea30650b91528657db64baea1757"

SRC_URI[md5sum] = "7845d2f3c8fe8602f73f53ec5b6dfa29"
SRC_URI[sha256sum] = "26464e57ccaafe72b7ad156fdaa4e9b9ef051f69e175dbbb463283000c05ab7b"

PYPI_PACKAGE = "pydantic"

CLEANBROKEN = "1"

inherit pypi setuptools3

RDEPENDS_${PN} = "python3-typing-extensions \
	          python3-dataclasses \
                 "