package com.example.lib.setting;

import com.example.lib.config.Config;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.android.AndroidDriver;

public class Util {
    /**
     * 获取Appium配置
     */
    private AndroidDriver driver;

    public AndroidDriver initDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", Config.PLATFORM_NAME);
        desiredCapabilities.setCapability("deviceName", Config.DEVICE_NAME);
        desiredCapabilities.setCapability("noSign", true);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("appPackage", Config.APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", Config.APP_ACTIVITY);
        desiredCapabilities.setCapability("platformVersion", Config.PLATFORM_VERSION);
        desiredCapabilities.setCapability("noReset", true);


        desiredCapabilities.setCapability("resetKeyboard", true);
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("skipDeviceInitialization",true);
        desiredCapabilities.setCapability("dontStopAppOnRese",true);
// 这里Url为服务端url driver即为服务端链接的移动设备驱动者
        try {
            driver = new AndroidDriver(new URL(Config.REMOTE_URL), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }


    public static String getMarkTime() {
        System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        String dateStr = sdf.format(date);
        return dateStr.replace(" ", "_");
    }

    public static String getMarkDate() {
        System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * 线程等待time ms
     */
    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 等待activity， 超时时间timeout 秒
     */
    public static boolean waitActivity(String activity, long timeout, AndroidDriver driver) {
        boolean isActivity = false;
        long lastTime = System.currentTimeMillis();
        do {
            sleep(3);
        } while (System.currentTimeMillis() - lastTime < timeout * 1000 && !(isActivity = checkActivity(activity, driver)));
        return isActivity;
    }

    public static boolean checkActivity(String activity, AndroidDriver driver) {
        return driver.currentActivity() != null && driver.currentActivity().contains(activity);
    }
}
