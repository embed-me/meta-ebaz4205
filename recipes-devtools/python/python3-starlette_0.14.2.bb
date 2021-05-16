SUMMARY = "The little ASGI library that shines."
HOMEPAGE = "https://www.starlette.io"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=11e8c8dbfd5fa373c703de492140ff7a"

SRC_URI[md5sum] = "e05db67f7dd5d63158299ff0d0fc3334"
SRC_URI[sha256sum] = "7d49f4a27f8742262ef1470608c59ddbc66baf37c148e938c7038e6bc7a998aa"

PYPI_PACKAGE = "starlette"

CLEANBROKEN = "1"

inherit pypi setuptools3
