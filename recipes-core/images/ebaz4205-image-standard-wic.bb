require recipes-core/images/ebaz4205-image-standard.bb

DESCRIPTION = "Generates a wic image that can be placed on an SD-Card"

IMAGE_FSTYPES = "wic"
WKS_FILES = "sdimage-bootpart.wks"

# Add the rootfs to the image
IMAGE_BOOT_FILES += " \
                 ebaz4205-image-standard-${MACHINE}.cpio.gz.u-boot \
                 "

WKS_FILE_DEPENDS += "ebaz4205-image-standard"
do_image_wic[depends] += "ebaz4205-image-standard:do_image_complete"

IMAGE_ROOTFS_EXTRA_SPACE = "2000"