DESCRIPTION = "pli plugins"
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

PLI_PLUGINS = " \
	enigma2-plugin-extensions-mediaportal_7.4.7_all.ipk \
	enigma2-plugin-extensions-seyirturk_sr456_all.ipk \
	enigma2-plugin-extensions-turkvod_6.0_all.ipk \
	enigma2-plugin-picons-openatv-black13e_1.0+git4+85cfede-r1_all.ipk \
	enigma2-plugin-picons-openatv-black13e-dbg_1.0+git4+85cfede-r1_all.ipk \
	enigma2-plugin-picons-openatv-black13e-dev_1.0+git4+85cfede-r1_all.ipk \
	enigma2-plugin-picons-openatv-black19e_1.0+git35+581ba63-r1_all.ipk \
	enigma2-plugin-picons-openatv-black19e-dbg_1.0+git35+581ba63-r1_all.ipk \
	enigma2-plugin-picons-openatv-black19e-dev_1.0+git35+581ba63-r1_all.ipk \
	enigma2-plugin-picons-openatv-black23e_1.0+git4+6621412-r1_all.ipk \
	enigma2-plugin-picons-openatv-black23e-dbg_1.0+git4+6621412-r1_all.ipk \
	enigma2-plugin-picons-openatv-black23e-dev_1.0+git4+6621412-r1_all.ipk \
	enigma2-plugin-picons-openatv-black28e_1.0+git6+169b22c-r1_all.ipk \
	enigma2-plugin-picons-openatv-black28e-dbg_1.0+git6+169b22c-r1_all.ipk \
	enigma2-plugin-picons-openatv-black28e-dev_1.0+git6+169b22c-r1_all.ipk \
	enigma2-plugin-picons-openatv-white13e_1.0+git11+6e467d4-r1_all.ipk \
	enigma2-plugin-picons-openatv-white13e-dbg_1.0+git11+6e467d4-r1_all.ipk \
	enigma2-plugin-picons-openatv-white13e-dev_1.0+git11+6e467d4-r1_all.ipk \
	enigma2-plugin-picons-openatv-white19e_1.0+git16+d7c196d-r1_all.ipk \
	enigma2-plugin-picons-openatv-white19e-dbg_1.0+git16+d7c196d-r1_all.ipk \
	enigma2-plugin-picons-openatv-white19e-dev_1.0+git16+d7c196d-r1_all.ipk \
	enigma2-plugin-picons-openatv-white23e_1.0+git7+9e862b8-r1_all.ipk \
	enigma2-plugin-picons-openatv-white23e-dbg_1.0+git7+9e862b8-r1_all.ipk \
	enigma2-plugin-picons-openatv-white23e-dev_1.0+git7+9e862b8-r1_all.ipk \
	enigma2-plugin-picons-openatv-white28e_1.0+git6+4b1cb1c-r1_all.ipk \
	enigma2-plugin-picons-openatv-white28e-dbg_1.0+git6+4b1cb1c-r1_all.ipk \
	enigma2-plugin-picons-openatv-white28e-dev_1.0+git6+4b1cb1c-r1_all.ipk \
"

do_install() {
}
python populate_packages_prepend () {
    p = ""
    plugins = bb.data.getVar('PLI_PLUGINS', d, 1)

    if plugins is not None:
        for package in plugins.split():
            p += package.split('_')[0] + " "

    bb.data.setVar('PACKAGES', p, d)
}

do_deploy() {
    install -d 0755 ${WORKDIR}/deploy-ipk/all

    for i in ${PLI_PLUGINS}; do
        if [ -f $i ]; then
            install -m 0644 $i ${WORKDIR}/deploy-ipk/all;
            install -m 0644 $i ${DEPLOY_DIR}/ipk/all;
        fi
    done;

    pkgdir=${DEPLOY_DIR_IPK}/all
    if [ -e $pkgdir ]; then
        chmod 0755 $pkgdir
    fi
}

addtask do_deploy before do_package_write after do_package_write_ipk

