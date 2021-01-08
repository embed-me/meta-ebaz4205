require recipes-core/images/ebaz4205-image-standard.bb

DESCRIPTION = "Generates a wic image that can be placed on an SD-Card"

IMAGE_FSTYPES = "wic"
WKS_FILES = "sdimage-bootpart.wks"

# Add the rootfs to the image
IMAGE_BOOT_FILES += " \
                 ebaz4205-image-standard-${MACHINE}.cpio.gz.u-boot \
                 "

do_rootfs[depends] += "ebaz4205-image-standard:do_rootfs"