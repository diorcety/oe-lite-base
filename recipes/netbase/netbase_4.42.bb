DESCRIPTION = "This package provides the necessary \
infrastructure for basic TCP/IP based networking."
SECTION = "base"
LICENSE = "GPL"

PR = "r5"

DEFAULT_PREFERENCE = "-1"

RECIPE_OPTIONS = "netbase_sysvinit_start netbase sysvinit_stop"

DEFAULT_CONFIG_netbase_sysvinit_start	= "20"
DEFAULT_CONFIG_netbase_sysvinit_stop	= "0"
SYSVINIT_SCRIPT_netbase			= "networking"

inherit sysvinit

SRC_URI = "${DEBIAN_MIRROR}/main/n/netbase/netbase_${PV}.tar.gz \
           file://init \
           file://hosts \
           file://interfaces"

do_install () {
	install -d ${D}${sysconfdir}/init.d \
		   ${D}${sbindir} \
		   ${D}${sysconfdir}/network/if-pre-up.d \
		   ${D}${sysconfdir}/network/if-up.d \
		   ${D}${sysconfdir}/network/if-down.d \
		   ${D}${sysconfdir}/network/if-post-down.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/networking
	install -m 0644 ${WORKDIR}/hosts ${D}${sysconfdir}/hosts
	install -m 0644 etc-rpc ${D}${sysconfdir}/rpc
	install -m 0644 etc-protocols ${D}${sysconfdir}/protocols
	install -m 0644 etc-services ${D}${sysconfdir}/services
	install -m 0644 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
}

CONFFILES_${PN} = "${sysconfdir}/hosts ${sysconfdir}/network/interfaces"
