package com.example.save_device;

import android.util.Base64;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class DeviceUtils {

    private static DeviceUtils getInstance;


    public static DeviceUtils getGetInstance() {
        return getInstance == null ? new DeviceUtils() : getInstance;
    }


    public Boolean isDeviceRooted() {
        return checkRootMethodOne() || checkRootMethodTwo() || checkRootMethodThree();
    }

    private boolean checkRootMethodOne() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    private boolean checkRootMethodTwo() {
        String[] paths = {"L3N5c3RlbS9hcHAvU3VwZXJ1c2VyLmFwaw==",
                "L3NiaW4vc3U=",
                "L3N5c3RlbS9iaW4vc3U=",
                "L3N5c3RlbS94YmluL3N1",
                "L2RhdGEvbG9jYWwveGJpbi9zdQ==",
                "L2RhdGEvbG9jYWwvYmluL3N1",
                "L3N5c3RlbS9zZC94YmluL3N1",
                "L3N5c3RlbS9iaW4vZmFpbHNhZmUvc3U=",
                "L2RhdGEvbG9jYWwvc3U=", "L3N1L2Jpbi9zdQ=="};
        for (String path : paths) {
            if (new File(decodeString(path)).exists()) return true;
        }
        return false;
    }

    private boolean checkRootMethodThree() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{decodeString("L3N5c3RlbS94YmluL3doaWNo"), decodeString("c3U=")});
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return in.readLine() != null;
        } catch (Throwable t) {
            return false;
        } finally {
            if (process != null) process.destroy();
        }
    }


    public static String decodeString(String encodedString) {
        byte[] bytes = Base64.decode(encodedString, Base64.DEFAULT);
        return new String(bytes);
    }
}