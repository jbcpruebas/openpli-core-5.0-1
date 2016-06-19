KV = "4.1.21"
SRCDATE = "20160613"
GCC = "4.9.1"

require et-dvb-modules.inc

SRC_URI = "http://gi-et-7000-mini.eu/${MACHINE}-drivers-${KV}-${GCC}-${SRCDATE}.zip"

SRC_URI[md5sum] = "6d01c6fd22276e08c4eecbb133b11a5e"
SRC_URI[sha256sum] = "32960aa29b4cb3e938823befc4c5b59220857d4d8cc0477e123caa91f8ccae56"

COMPATIBLE_MACHINE = "et7000mini"
