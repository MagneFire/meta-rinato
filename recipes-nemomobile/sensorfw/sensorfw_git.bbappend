FILESEXTRAPATHS:prepend:rinato := "${THISDIR}/sensorfw:"
SRC_URI:append:rinato = " file://sensorfwd.service \
                            file://0001-HybrisStepCounterAdapter-Set-delay-to-normal-speed.patch \
"

DEPENDS:append:rinato = " libhybris "
