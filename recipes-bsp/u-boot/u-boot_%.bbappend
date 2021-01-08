# our u-boot 2019.07 is forked, branched and patched for the support
SRCREV = "62c904685730ba8b2418129bee405e3a2dc172e6"

SRC_URI_remove = "git://git.denx.de/u-boot.git "
SRC_URI_prepend = "git://github.com/embed-me/u-boot.git;branch=v2019.07-ebaz4205 "
SRC_URI[md5sum] = "8e306fc668e78544a040cc0f7c5bdbba"

HAS_PLATFORM_INIT += " zynq_ebaz4205_config"