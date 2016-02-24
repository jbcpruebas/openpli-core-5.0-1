DESCRIPTION = "OpenNFR Settings files"
LICENSE = "GPL2"

require conf/license/license-gplv2.inc

PACKAGE_ARCH := "${MACHINE_ARCH}"

SRCREV = "${AUTOREV}"

SRC_URI = "file://*"

FILES_${PN} = "/etc/enigma2/*"
S = "${WORKDIR}"

do_install() {
    install -d ${D}/etc/enigma2
    for f in blacklist bouquets* lamedb satellites.xml userbouquet* whitelist
    do
        install -m 644 ${f} ${D}/etc/enigma2/${f}
    done
}


