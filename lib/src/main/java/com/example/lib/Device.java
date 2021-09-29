package com.example.lib;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

class Device {

    private AndroidDriver driver;

    public AndroidDriver initDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("noSign", true);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
        desiredCapabilities.setCapability("appActivity", "com.tencent.wework.launch.WwMainActivity");
        desiredCapabilities.setCapability("platformVersion", "7.1.2");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

       desiredCapabilities.setCapability("resetKeyboard", true);


        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
// 这里Url为服务端url driver即为服务端链接的移动设备驱动者
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
