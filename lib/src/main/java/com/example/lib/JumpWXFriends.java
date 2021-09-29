package com.example.lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class JumpWXFriends{
    private AndroidDriver mDriver; // 测试手机的控制者
    private static ExtentReports mExtent;
    public static final String MAIN_ACTIVITY = "com.tencent.wework.launch.WwMainActivity";
    
    @BeforeClass
    public static void beforeClass(){ // 在类初始化前初始化报告生成器
         String reportPath = "reports/" + Util.getMarkDate() + "/" + Util.getMarkTime() + ".html";
         mExtent = new ExtentReports();
         ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
         spark.config().setOfflineMode(true);
        mExtent .attachReporter(spark);
    }
    
    // 监听每个@Test方法执行前后的额外操作->记录报告
    @Rule
    public TestWatcher eu = new ExtendWatcher(mExtent);
    
    // case开始前初始化与Service链连接
    @Before
    public void setUp() throws MalformedURLException {
        // 上面的与服务器链接的初始化操作 
        mDriver = new Device().initDriver();

    }
    
    @After
    public void tearDown() {
        // testcase测试结束后关闭连接
       mDriver.quit();
    }
    
    @Test
    public void testJumpWXFriends(){ 
        Util.waitActivity(MAIN_ACTIVITY, 30, mDriver);
        Util.sleep(1);
//// 这个是Appium-desktop生成的脚本代码
//// 从微信主页 - 发现 - 朋友圈 - 向下滑动一段
//        MobileElement el1 = (MobileElement) mDriver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"当前所在页面,与的聊天\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[1]");
//        el1.click();
//        MobileElement el2 = (MobileElement) mDriver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"当前所在页面,与的聊天\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/com.tencent.mm.ui.mogic.WxViewPager/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout");
//        el2.click();
//        new TouchAction(mDriver).press(PointOption.point(1200, 787)).moveTo(PointOption.point(734, 271)).release().perform();
    }
}