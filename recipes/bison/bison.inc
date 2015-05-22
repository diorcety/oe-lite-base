# -*- mode:python; -*-
RECIPE_TYPES = "machine native"

inherit autotools-autoreconf gettext wrapper

DEPENDS += "native:help2man"

require conf/fetch/gnu.conf
SRC_URI += "${GNU_MIRROR}/${PN}/${PN}-${PV}.tar.xz"
SRC_URI += "file://bin/bison;subdir=bin/"

DEPENDS_${PN} += "libintl"
RDEPENDS_${PN} += "libintl"

