DESCRIPTION = "sf108-octagon-hbbtv"
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

SF108_OCTAGON_HBBTV = " \
	enigma2-plugin-extensions-sf108-hbbtv_2.0+git1644+aaaf944-r23_vg5000.ipk \
"

do_install() {
}
python populate_packages_prepend () {
    p = ""
    plugins = bb.data.getVar('SF108_OCTAGON_HBBTV', d, 1)

    if plugins is not None:
        for package in plugins.split():
            p += package.split('_')[0] + " "

    bb.data.setVar('PACKAGES', p, d)
}

do_deploy() {
    install -d 0755 ${WORKDIR}/deploy-ipk/vg5000

    for i in ${SF108_OCTAGON_HBBTV}; do
        if [ -f $i ]; then
            install -m 0644 $i ${WORKDIR}/deploy-ipk/vg5000;
            install -m 0644 $i ${DEPLOY_DIR}/ipk/vg5000;
        fi
    done;

    pkgdir=${DEPLOY_DIR_IPK}/vg5000
    if [ -e $pkgdir ]; then
        chmod 0755 $pkgdir
    fi
}

addtask do_deploy before do_package_write after do_package_write_ipk

