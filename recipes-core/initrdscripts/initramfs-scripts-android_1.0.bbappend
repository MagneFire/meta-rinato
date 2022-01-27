FILESEXTRAPATHS:prepend:rinato := "${THISDIR}/${PN}:"
COMPATIBLE_MACHINE:rinato = "rinato"

SRC_URI:append:rinato += " file://init.machine.sh"

do_install:append:rinato() {
    install -m 0755 ${WORKDIR}/init.machine.sh ${D}/init.machine
}

FILES:${PN} += "/init.machine"
