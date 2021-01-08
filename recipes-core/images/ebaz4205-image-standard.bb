require recipes-core/images/ebaz4205-image-minimal.bb

DESCRIPTION = "This image adds additional packages to form a standard image."

IMAGE_INSTALL += "\
        net-tools \
        nfs-utils \
        mtd-utils \
        devmem2 \
        strace \
        ldd \
        "

IMAGE_FEATURES += "ssh-server-dropbear \
         package-management \
         tools-debug \
         "