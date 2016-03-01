require conf/license/openpli-gplv2.inc

inherit image

IMAGE_INSTALL = " \
	${ROOTFS_PKGMANAGE} \
	openpli-feed \
	avahi-daemon \
	dropbear \
	e2fsprogs-e2fsck \
	e2fsprogs-mke2fs \
	e2fsprogs-tune2fs \
	fakelocale \
	kernel-params \
	modutils-loadscript \
	nfs-utils-client \
	openpli-bootlogo \
	opkg \
	packagegroup-base \
	packagegroup-core-boot \
	parted \
	samba-base \
	sdparm \
	tuxbox-common \
	tuxbox-links \
	tzdata \
	volatile-media \
	vsftpd \
	python-argparse \
	"

export IMAGE_BASENAME = "openpli"
IMAGE_LINGUAS = ""

IMAGE_FEATURES += "package-management"


# Remove the mysterious var/lib/opkg/lists that appears to be the result
# of the installer that populates the rootfs. I wanted to call this
# rootfs_remove_opkg_leftovers but that fails to parse.
rootfsremoveopkgleftovers() {
	if [ "${MACHINE}" = "g300" ]; then
		cd ${IMAGE_ROOTFS}/lib/modules/4.1.15/extra/
		rm -rf linuxtv_g300.ko
		cp /media/UBUNTU/OPENPLI-SF3038/harry/linuxtv_g300.ko ${IMAGE_ROOTFS}/lib/modules/4.1.15/extra/
		cd ${IMAGE_ROOTFS}/usr/share/enigma/
		rm -rf display
	fi
	cd
	if [ "${MACHINE}" = "vg5000" ]; then
		cd ${IMAGE_ROOTFS}/lib/modules/3.14.2/extra/
		rm -rf dvb.ko
		cp /media/UBUNTU/OPENPLI-SF108/harry/dvb.ko ${IMAGE_ROOTFS}/lib/modules/3.14.2/extra/
		cd ${IMAGE_ROOTFS}/usr/share/enigma/
		rm -rf display
	fi
	cd		
	if [ "${MACHINE}" = "7100s" ]; then
		cd ${IMAGE_ROOTFS}/etc/opkg/	
		rm -rf ${IMAGE_ROOTFS}/etc/opkg/3rd-party-7100s-feed.conf
		rm -rf ${IMAGE_ROOTFS}/etc/opkg/vg5000-feed.conf	
		rm -rf ${IMAGE_ROOTFS}/etc/opkg/g300-feed.conf
	fi
	if [ "${MACHINE}" = "vg5000" ]; then
		cd ${IMAGE_ROOTFS}/etc/opkg/	
		rm -rf ${IMAGE_ROOTFS}/etc/opkg/7100s-feed.conf
		rm -rf ${IMAGE_ROOTFS}/etc/opkg/3rd-party-vg5000-feed.conf	
		rm -rf ${IMAGE_ROOTFS}/etc/opkg/g300-feed.conf
	fi
	if [ "${MACHINE}" = "g300" ]; then
		cd ${IMAGE_ROOTFS}/etc/opkg/	
		rm -rf ${IMAGE_ROOTFS}/etc/opkg/7100s-feed.conf
		rm -rf ${IMAGE_ROOTFS}/etc/opkg/3rd-party-g300-feed.conf
		rm -rf ${IMAGE_ROOTFS}/etc/opkg/vg5000-feed.conf	
	fi	
	cd
	cd ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/BackupSuite/
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/BackupSuite/lookuptable.txt
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/BackupSuite/lookuptable-neu.txt ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/BackupSuite/lookuptable.txt
	cd

	cd ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/
		rm -rf ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/rc_models.cfg
		mv ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/rc_models-neu.cfg ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/rc_models.cfg
		mv ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/red1-neu.png ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/red1.png
		mv ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/red1-neu.xml ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/red1.xml
		mv ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/sf108-neu.png ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/sf108.png
		mv ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/sf108-neu.xml ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/sf108.xml
		mv ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/sf3038-neu.png ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/sf3038.png
		mv ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/sf3038-neu.xml ${IMAGE_ROOTFS}/usr/share/enigma2/rc_models/sf3038.xml
	cd

	cd ${IMAGE_ROOTFS}/etc/

	if [ "${MACHINE}" = "7100s" ]; then
		mv ${IMAGE_ROOTFS}/etc/model-7100s ${IMAGE_ROOTFS}/etc/model
		rm -rf ${IMAGE_ROOTFS}/etc/model-sf3038
		rm -rf ${IMAGE_ROOTFS}/etc/model-sf108
	fi
	if [ "${MACHINE}" = "vg5000" ]; then
		mv ${IMAGE_ROOTFS}/etc/model-sf108 ${IMAGE_ROOTFS}/etc/model
		rm -rf ${IMAGE_ROOTFS}/etc/model-sf3038
		rm -rf ${IMAGE_ROOTFS}/etc/model-7100s
	fi
	if [ "${MACHINE}" = "g300" ]; then
		mv ${IMAGE_ROOTFS}/etc/model-sf3038 ${IMAGE_ROOTFS}/etc/model
		rm -rf ${IMAGE_ROOTFS}/etc/model-sf108
		rm -rf ${IMAGE_ROOTFS}/etc/model-7100s
	fi
	cd

	cd ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/
	if [ "${MACHINE}" = "7100s" ]; then
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/7100s-neu.jpg ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/7100s.jpg
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/vg5000-neu.jpg ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/vg5000.jpg
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/g300-neu.jpg ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/g300.jpg
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/vg5000.jpg
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/g300.jpg
	fi
	if [ "${MACHINE}" = "vg5000" ]; then
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/vg5000-neu.jpg ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/vg5000.jpg
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/g300-neu.jpg ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/g300.jpg
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/7100s-neu.jpg ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/7100s.jpg
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/7100s.jpg
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/g300.jpg
	fi
	if [ "${MACHINE}" = "g300" ]; then
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/vg5000-neu.jpg ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/vg5000.jpg
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/g300-neu.jpg ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/g300.jpg
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/7100s-neu.jpg ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/7100s.jpg
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/7100s.jpg
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/vg5000.jpg
	fi
	cd
	cd ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/
	if [ "${MACHINE}" = "7100s" ]; then
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/7100s-neu.png ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/7100s.png
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf108-neu.png ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf108.png
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf3038-neu.png ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf3038.png
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf108.png
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf3038.png
	fi
	if [ "${MACHINE}" = "vg5000" ]; then
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/7100s-neu.png ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/7100s.png
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf108-neu.png ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf108.png
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf3038-neu.png ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf3038.png
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/7100s.png
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf3038.png
	fi
	if [ "${MACHINE}" = "g300" ]; then
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/7100s-neu.png ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/7100s.png
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf108-neu.png ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf108.png
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf3038-neu.png ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf3038.png
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/7100s.png
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/images/remotes/sf108.png
	fi
	cd
	cd ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/
	if [ "${MACHINE}" = "7100s" ]; then
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/7100s-neu.html ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/7100s.html
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf108-neu.html ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf108.html
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf3038-neu.html ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf3038.html
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf108.html
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf3038.html
	fi
	if [ "${MACHINE}" = "vg5000" ]; then
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/7100s-neu.html ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/7100s.html
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf108-neu.html ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf108.html
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf3038-neu.html ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf3038.html
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/7100s.html
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf3038.html
	fi
	if [ "${MACHINE}" = "g300" ]; then
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/7100s-neu.html ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/7100s.html
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf108-neu.html ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf108.html
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf3038-neu.html ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf3038.html
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/7100s.html
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/sf108.html
	fi
	cd
	cd ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/
	if [ "${MACHINE}" = "7100s" ]; then
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding.py
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding-7100s.py ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding.py
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding-sf108.py
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding-sf3038.py
	fi
	if [ "${MACHINE}" = "g300" ]; then
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding.py
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding-sf3038.py ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding.py
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding-sf108.py
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding-7100s.py
	fi
	if [ "${MACHINE}" = "vg5000" ]; then
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding.py
		mv ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding-sf108.py ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding.py
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding-7100s.py
		rm -rf ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/controllers/models/owibranding-7100s.py
	fi
	cd

	rm -r ${IMAGE_ROOTFS}/var/lib/opkg/lists
}

# Some features in image.bbclass we do NOT want, so override them
# to be empty. We want to log in as root, but NOT via SSH. So we want
# to live without debug-tweaks...
zap_root_password () {
	true
}
ssh_allow_empty_password () {
	true
}
license_create_manifest() {
}

ROOTFS_POSTPROCESS_COMMAND += "rootfsremoveopkgleftovers;"
