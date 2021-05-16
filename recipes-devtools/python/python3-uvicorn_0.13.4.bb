SUMMARY = "Uvicorn is a lightning-fast ASGI server implementation"
HOMEPAGE = "https://www.uvicorn.org/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=206119e27d6b034e7ce70d73063c82a8"

#SRC_URI = "https://github.com/encode/uvicorn.git"
#SRCREV ?= "bf1c64e2c141971c546671c7dc91b8ccf0afeb7d"

SRC_URI[md5sum] = "5bc1beb6398cfa078b9b3858de5225cc"
SRC_URI[sha256sum] = "3292251b3c7978e8e4a7868f4baf7f7f7bb7e40c759ecc125c37e99cdea34202"

PYPI_PACKAGE = "uvicorn"

CLEANBROKEN = "1"

inherit pypi setuptools3

RDEPENDS_${PN} = "python3-h11 \
	          python3-click \
		  python3-setuptools \
                 "