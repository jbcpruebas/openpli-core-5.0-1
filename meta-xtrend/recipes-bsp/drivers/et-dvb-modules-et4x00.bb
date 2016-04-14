KV = "4.0.1"
SRCDATE = "20160218"

require et-dvb-modules.inc

SRC_URI = "http://www.xtrendet.net/${MACHINE}-drivers-${KV}-${SRCDATE}.zip"

SRC_URI[md5sum] = "dcd6fec0ad57e6307271916d54599050"
SRC_URI[sha256sum] = "41545b783f37288d860c80040935bb3027ae9e41d67e8026333e50ae4b0d78a6"

COMPATIBLE_MACHINE = "et4.00"
