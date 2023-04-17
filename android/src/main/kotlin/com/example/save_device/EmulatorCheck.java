package com.example.save_device;

import android.os.Build;

public class EmulatorCheck {
    public static boolean isEmulator() {

        if (Build.PRODUCT.contains("sdk") ||
                Build.PRODUCT.contains("Andy") ||
                Build.PRODUCT.contains("ttVM_Hdragon") ||
                Build.PRODUCT.contains("google_sdk") ||
                Build.PRODUCT.contains("Droid4X") ||
                Build.PRODUCT.contains("nox") ||
                Build.PRODUCT.equals("Android SDK built for x86_64") ||
                Build.PRODUCT.equals("Android SDK built for x86")
        Build.PRODUCT.contains("sdk_x86") ||
        Build.PRODUCT.contains("sdk_x64") ||
        Build.PRODUCT.contains("sdk_x86_64") ||
                Build.PRODUCT.contains("sdk_google") ||
                Build.PRODUCT.contains("vbox86p")){
            return true;
        }

        if (Build.MANUFACTURER.equals("unknown") ||
                Build.MANUFACTURER.equals("Genymotion") ||
                Build.MANUFACTURER.contains("Andy") ||
                Build.MANUFACTURER.contains("MIT") ||
                Build.MANUFACTURER.contains("nox") ||
                Build.MANUFACTURER.contains("TiantianVM")) {
            return true;
        }

        if (Build.BRAND.equals("generic") ||
                Build.BRAND.equals("generic_x86") ||
                Build.BRAND.equals("TTVM") ||
                Build.BRAND.contains("Andy")) {
            return true;
        }

        if (Build.DEVICE.contains("generic") ||
                Build.DEVICE.contains("generic_x86") ||
                Build.DEVICE.contains("Andy") ||
                Build.DEVICE.contains("ttVM_Hdragon") ||
                Build.DEVICE.contains("Droid4X") ||
                Build.DEVICE.contains("nox") ||
                Build.DEVICE.contains("generic_x86_64") ||
                Build.DEVICE.contains("vbox86p")) {
            return true;
        }

        if (Build.MODEL.equals("sdk") ||
                Build.MODEL.equals("google_sdk") ||
                Build.MODEL.contains("Droid4X") ||
                Build.MODEL.contains("TiantianVM") ||
                Build.MODEL.contains("Andy") ||
                Build.MODEL.equals("Android SDK built for x86_64") ||
                Build.MODEL.equals("Android SDK built for x86")) {
            return true;
        }

        if (Build.HARDWARE.equals("goldfish") ||
                Build.HARDWARE.equals("vbox86") ||
                Build.HARDWARE.contains("nox") ||
                Build.HARDWARE.contains("ttVM_x86")) {
            return true;
        }

        if (Build.FINGERPRINT.contains("generic/sdk/generic") ||
                Build.FINGERPRINT.contains("generic_x86/sdk_x86/generic_x86") ||
                Build.FINGERPRINT.contains("Andy") ||
                Build.FINGERPRINT.contains("ttVM_Hdragon") ||
                Build.FINGERPRINT.contains("generic_x86_64") ||
                Build.FINGERPRINT.contains("generic/google_sdk/generic") ||
                Build.FINGERPRINT.contains("vbox86p") ||
                Build.FINGERPRINT.contains("generic/vbox86p/vbox86p")) {
            return true;
        }

        return false;
    }


}
