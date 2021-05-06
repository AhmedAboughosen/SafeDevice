package com.example.save_device;

import android.content.Context;
import android.os.Build;

import com.scottyab.rootbeer.RootBeer;

public class DeviceUtils {
    private static final String ONEPLUS = "oneplus";
    private static final String MOTO = "moto";
    private static final String XIAOMI = "Xiaomi";


    private static DeviceUtils getInstance;


    public static DeviceUtils getGetInstance() {
        return getInstance == null ? new DeviceUtils() : getInstance;
    }

    public boolean rootBeerCheck(Context context) {
        RootBeer rootBeer = new RootBeer(context);
        Boolean rv;
        if (Build.BRAND.contains(ONEPLUS) || Build.BRAND.contains(MOTO) || Build.BRAND.contains(XIAOMI)) {
            rv = rootBeer.isRootedWithoutBusyBoxCheck();
            System.out.println("isRootedWithoutBusyBoxCheck " + rv);
        } else {
            rv = rootBeer.isRooted();
            System.out.println("isRooted " + rv);
        }
        return rv;
    }

//
//    public Boolean isDeviceRooted() {
//        System.out.println(checkRootMethodOne());
//        System.out.println(checkRootMethodTwo());
//        System.out.println(checkRootMethodThree());
//        return checkRootMethodOne() || checkRootMethodTwo() || checkRootMethodThree();
//    }
//
//    private boolean checkRootMethodOne() {
//        String buildTags = android.os.Build.TAGS;
//        return buildTags != null && buildTags.contains("test-keys");
//    }
//
//    private boolean checkRootMethodTwo() {
//        String[] paths = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
//        for (String path : paths) {
//            if (new File(path).exists()) return true;
//        }
//        return false;
//    }
//
//    private boolean checkRootMethodThree() {
//        Process process = null;
//        try {
//            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
//            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            return in.readLine() != null;
//        } catch (Throwable t) {
//            return false;
//        } finally {
//            if (process != null) process.destroy();
//        }
//    }

}