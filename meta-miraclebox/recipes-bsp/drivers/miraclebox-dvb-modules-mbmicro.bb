SSUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.0.1"
SRCDATE = "20160503"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI[md5sum] = "db372e26964a35991a9714a7820aa4c3"
SRC_URI[sha256sum] = "ff0038d40ea312647308a36d299ef547113df8ab8cdb0a81f8f61e40db203232"

SRC_URI = "http://source.mynonpublic.com/ceryon/ceryon-7000s-dvbdrive-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    echo "dvbdrive" >> ${D}/${sysconfdir}/modules-load.d/dvbdrive.conf
    install -m 0755 ${WORKDIR}/dvbdrive.ko ${D}/lib/modules/${KV}/extra
    install -d ${D}/etc/rcS.d
}

FILES_${PN} += "${sysconfdir}/modules-load.d/dvbdrive.conf"
