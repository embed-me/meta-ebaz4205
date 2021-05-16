require recipes-core/images/ebaz4205-image-standard.bb

DESCRIPTION = "Control PWM devices using a webserver to demonstrate ASGI."

IMAGE_INSTALL += "\
	pwmctrl-server \
        "
