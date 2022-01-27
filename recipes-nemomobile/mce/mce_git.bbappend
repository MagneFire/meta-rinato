FILESEXTRAPATHS:prepend:rinato := "${THISDIR}/mce:"
SRC_URI:append:rinato = " file://20als-defaults.ini"

do_install:append:rinato() {
    cp ../20als-defaults.ini ${D}/etc/mce/20als-defaults.ini
}
