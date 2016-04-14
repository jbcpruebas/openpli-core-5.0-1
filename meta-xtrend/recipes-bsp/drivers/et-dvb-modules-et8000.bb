KV = "4.0.1"
SRCDATE = "20160218"

require et-dvb-modules.inc

SRC_URI = "http://www.xtrendet.net/${MACHINE}-drivers-${KV}-${SRCDATE}.zip"

SRC_URI[md5sum] = "2831425250dc6fe08e519538e9d00c2f"
SRC_URI[sha256sum] = "59b072293be6f56538029e5a552f888225f2af5bc93c88ac77a5457c744140fb"

COMPATIBLE_MACHINE = "et8000"
