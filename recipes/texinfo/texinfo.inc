# -*- mode:python; -*-
RECIPE_TYPES = "machine native"

inherit autotools-autoreconf gettext

DEPENDS += "native:help2man ${DEPENDS_NOT_NATIVE}"

DEPENDS_NOT_NATIVE = "native:texinfo"
DEPENDS_NOT_NATIVE:native = ""

require conf/fetch/gnu.conf
SRC_URI += "${GNU_MIRROR}/${PN}/${PN}-${PV}.tar.xz"

PROVIDES_${PN} += "makeinfo install-info texi2dvi texi2pdf pod2texi infokey texindex texi2any info pdftexi2dvi"

