SUMMARY = "Firmware files for bcm40181a2/ap6210"
LICENSE = "CLOSED"

PACKAGE_ARCH = "all"

PR = "r00"

SRC_URI = "file://firmware-ap6210.zip"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware/brcm"

do_install() {
    install -d ${D}${base_libdir}/firmware/brcm
    install -m 0644 ap6210-nvram.txt ${D}${base_libdir}/firmware/brcm/ap6210-nvram.txt
    install -m 0644 fw_bcm40181a2.bin ${D}${base_libdir}/firmware/brcm/fw_bcm40181a2.bin
}
