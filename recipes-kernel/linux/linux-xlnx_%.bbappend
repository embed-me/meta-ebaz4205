FILESEXTRAPATHS_prepend := "${THISDIR}/config:${THISDIR}/files:"

SRC_URI_append = " \
                 file://bsp/net/eth.scc \
                 file://bsp/fs/mtd.scc \
                 "

KERNEL_FEATURES_append = " \  
                         bsp/net/eth.scc \
                         bsp/fs/mtd.scc \
                         "