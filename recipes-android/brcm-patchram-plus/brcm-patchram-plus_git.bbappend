FILESEXTRAPATHS:prepend:rinato := "${THISDIR}/brcm-patchram-plus:"
SRC_URI:append:rinato = " file://patchram.service "
CFLAGS:append:rinato = " -DLPM_STURGEON"
