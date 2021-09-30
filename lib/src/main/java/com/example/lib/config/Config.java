package com.example.lib.config;

/**
 * 配置参数
 */
public class Config {
    // Appium client运行时指定的服务端url
    public static final String REMOTE_URL = "http://localhost:4723/wd/hub";

    // 测试时链接的手机相关参数
    public static final String PLATFORM_NAME = "Android";
    public static final String PLATFORM_VERSION = "7.1.2";
    public static final String DEVICE_NAME = "emulator-5554";


    // 测试的app
    public static final String APP_PACKAGE = "com.tencent.wework";
    public static final String APP_ACTIVITY = "com.tencent.wework.launch.WwMainActivity";

    public static final String MAIN_ACTIVITY = "com.tencent.wework.launch.WwMainActivity";
}