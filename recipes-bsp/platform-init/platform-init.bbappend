FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
               file://ps7_init_gpl.c \
               file://ps7_init_gpl.h \
               "

COMPATIBLE_MACHINE_ebaz4205-zynq7 = "ebaz4205-zynq7"