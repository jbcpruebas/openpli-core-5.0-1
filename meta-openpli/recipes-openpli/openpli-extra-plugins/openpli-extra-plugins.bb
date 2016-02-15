SUMMARY = "3rd Party plugins for Enigma2"
MAINTAINER = "OpenNFR Team"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=45de10587e108efb50c321c1affd5e00"

inherit gitpkgv autotools deploy

SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r1"
SRC_URI="git://github.com/schleichdi2/openpli-extra-plugins.git"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-boxtype=${MACHINEBUILD} \
"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

DEPENDS = "enigma2"

do_install() {
}

do_deploy() {
}

do_deploy_append() {    
    install -d 0755 ${DEPLOY_DIR_IPK}/3rdparty
    install -d 0755 ${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty
    if [ "${TARGET_ARCH}" = "mipsel" ]; then
    	 install -m 0644 ${S}/*all.ipk ${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty #|| true
    fi

    pkgdir=${DEPLOY_DIR_IPK}/3rdparty
    if [ -e $pkgdir ]; then
        chmod 0755 $pkgdir
    fi
    pkgdir=${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty
    if [ -e $pkgdir ]; then
        chmod 0755 $pkgdir
    fi
}

addtask do_deploy before do_package_write after do_package_write_ipk 
