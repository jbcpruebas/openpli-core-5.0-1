KV = "4.4.8"
SRCDATE = "20160610"
GCC = "4.9.1"

require et-dvb-modules.inc

SRC_URI = "http://xtrendet.net/${MACHINE}-drivers-${KV}-${GCC}-${SRCDATE}.zip"

SRC_URI[md5sum] = "3226b94577ef77b82513daf25ac5441a"
SRC_URI[sha256sum] = "610e2b2d4347ba85079717fbd70b274b9df584ab5d48fef84582a6c79b06ab99"

COMPATIBLE_MACHINE = "et7x00"
