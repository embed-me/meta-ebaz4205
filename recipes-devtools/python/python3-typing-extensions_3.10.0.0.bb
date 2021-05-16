SUMMARY = "Backported and Experimental Type Hints for Python 3.5+"
HOMEPAGE = "https://github.com/python/typing/tree/master/typing_extensions"
SECTION = "devel/python"
LICENSE = "Python-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=64fc2b30b67d0a8423c250e0386ed72f"

SRC_URI[md5sum] = "9b5b33ae64c94479fa0862cf8ae89d58"
SRC_URI[sha256sum] = "50b6f157849174217d0656f99dc82fe932884fb250826c18350e159ec6cdf342"

PYPI_PACKAGE = "typing_extensions"

CLEANBROKEN = "1"

inherit pypi setuptools3