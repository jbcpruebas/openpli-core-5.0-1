KV = "4.1.21"
SRCDATE = "20160601"
GCC = "4.9.1"

require et-dvb-modules.inc

SRC_URI = "http://gi-et-7000-mini.eu/${MACHINE}-drivers-${KV}-${GCC}-${SRCDATE}.zip"

SRC_URI[md5sum] = "46fc02557ccc5e57647ce8ece770319c"
SRC_URI[sha256sum] = "3e8799b65a6096a08c561ec582510ad1e8df3a718d4e72d979a7449947b105b1"

COMPATIBLE_MACHINE = "et7000mini"
