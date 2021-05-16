SUMMARY = "FastAPI framework, high performance, easy to learn, fast to code, ready for production"
HOMEPAGE = "https://fastapi.tiangolo.com"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=95792ff3fe8e11aa49ceb247e66e4810"

SRC_URI[md5sum] = "eae2970c05d4805d6af8f6bedf7dbd49"
SRC_URI[sha256sum] = "ede7d6b010c77ec27a0e5f7faad315d2abc80c4eebbce2b28f2e2c06866ad199"

PYPI_PACKAGE = "fastapi"

CLEANBROKEN = "1"

inherit pypi setuptools3

RDEPENDS_${PN} = "python3-starlette \
	          python3-pydantic \
                 "