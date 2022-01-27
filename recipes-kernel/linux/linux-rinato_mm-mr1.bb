#require recipes-kernel/linux/linux.inc
#inherit gettext
require recipes-kernel/linux/linux-yocto.inc

SECTION = "kernel"
SUMMARY = "Mainline kernel for Samsung Gear 2"
HOMEPAGE = "https://android.googlesource.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
COMPATIBLE_MACHINE = "rinato"

SRC_URI = "git://github.com/torvalds/linux.git;protocol=https \
    file://0001-ARM-dts-Fix-booting-on-Rinato-market-device.patch \
    file://defconfig \
    file://img_info \
"

SRCREV = "df0cc57e057f18e44dac8e6c18aba47ab53202f9"
LINUX_VERSION ?= "5.16"
PV = "${LINUX_VERSION}+marshmallow"
S = "${WORKDIR}/git"
B = "${S}"

do_install:append() {
    rm -rf ${D}/usr/src/usr/
    ln -s ${D}/boot/zImage-5.16.0-yocto-standard ${D}/boot/zImage
#    ls arch/arm/boot/
#    scripts/dtc/dtc -O dtb -o arch/arm/boot/dts/exynos3250-rinato.dtb arch/arm/boot/dts/exynos3250-rinato.dts
#    cat arch/arm/boot/zImage arch/arm/boot/dts/exynos3250-rinato.dtb > arch/arm/boot/zImage-dtb

}

BOOT_PARTITION = "/dev/mmcblk0p15"

#inherit mkboot old-kernel-gcc-hdrs
KERNEL_DEVICETREE = "exynos3250-rinato.dtb"
KERNEL_DEVICETREE_BUNDLE = "1"
#KERNEL_IMAGEDEST = "git/arch/arm/boot/"
#KERNEL_DTB_BIN_EXT = "-dtb"
