require recipes-core/images/core-image-minimal.bb
inherit extrausers

DESCRIPTION = "A small image just capable of allowing the device to boot"

EXTRA_USERS_PARAMS = "\
    usermod -P 'root' root; \
    groupadd -r systemd-journal; \
    "

IMAGE_INSTALL += "\
        watchdog \
        busybox \
        sudo \
        "
         
SYSTEMD_DEFAULT_TARGET = "multi-user.target"