DESCRIPTION = "twinbox-octagon-hbbtv"
LICENSE = "CLOSED"

SRCREV = "${AUTOREV}"
PR = "r1"

SRC_URI = "git://github.com/schleichdi2/plugins.git"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
"

ALLOW_EMPTY_${PN} = "1"

S = "${WORKDIR}/git"
DEPLOY_DIR = "${TMPDIR}/deploy"

TWINBOX_OCTAGON_HBBTV = " \
	enigma2-plugin-extensions-redeagle-hbbtv_2.0+git1644+aaaf944-r23_7100s.ipk \
"

do_install() {
}
python populate_packages_prepend () {
    p = ""
    plugins = bb.data.getVar('TWINBOX_OCTAGON_HBBTV', d, 1)

    if plugins is not None:
        for package in plugins.split():
            p += package.split('_')[0] + " "

    bb.data.setVar('PACKAGES', p, d)
}

do_deploy() {
    install -d 0755 ${WORKDIR}/deploy-ipk/7100s

    for i in ${TWINBOX_OCTAGON_HBBTV}; do
        if [ -f $i ]; then
            install -m 0644 $i ${WORKDIR}/deploy-ipk/7100s;
            install -m 0644 $i ${DEPLOY_DIR}/ipk/7100s;
        fi
    done;

    pkgdir=${DEPLOY_DIR_IPK}/7100s
    if [ -e $pkgdir ]; then
        chmod 0755 $pkgdir
    fi
}

addtask do_deploy before do_package_write after do_package_write_ipk

