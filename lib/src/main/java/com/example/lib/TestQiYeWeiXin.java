package com.example.lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.lib.setting.ExtendWatcher;
import com.example.lib.setting.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static com.example.lib.config.Config.MAIN_ACTIVITY;

public class TestQiYeWeiXin {
    private AndroidDriver mDriver; // 测试手机的控制者
    private static ExtentReports mExtent;

    
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
        mDriver = new Util().initDriver();

    }
    
    @After
    public void tearDown() {
        // testcase测试结束后关闭连接
       mDriver.quit();
    }
    
    @Test
    public void testQiYeWeiXin(){
        Util.waitActivity(MAIN_ACTIVITY, 6, mDriver);
        Util.sleep(3000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView").click();


        Util.sleep(500);
        scroll();

        Util.sleep(2000);
        mDriver.findElementByAndroidUIAutomator("new UiSelector().text(\"添加成员\")").click();


        Util.sleep(2000);
        mDriver.findElementById("com.tencent.wework:id/d7z").click();


        Util.sleep(2000);
        if(isJudgingElement(mDriver,By.id("com.tencent.wework:id/ana"))){
            Util.sleep(2000);
            mDriver.findElementById("com.tencent.wework:id/izu").click();
        }

        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.EditText").click();
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("林一一");

        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.EditText").click();
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("1234567");

        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.EditText").click();
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("一一");

        //性别
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.RelativeLayout").click();
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout").click();

        //手机号
        Util.sleep(2000);
        mDriver.findElementById("com.tencent.wework:id/ge4").click();
        Util.sleep(2000);
        mDriver.findElementById("com.tencent.wework:id/ge4").sendKeys("135468907534");

        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[6]/android.widget.RelativeLayout/android.widget.EditText").click();
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[6]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("3345467");
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[7]/android.widget.RelativeLayout/android.widget.EditText").click();
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[7]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("99999999@qq.com");

        //地址
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[8]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout").click();
        //输入地址
        Util.sleep(3000);
        mDriver.findElementById("com.tencent.wework:id/kq").sendKeys("腾讯大厦");
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]").click();
        Util.sleep(2000);
        mDriver.findElementById("com.tencent.wework:id/j05").click();


        //职务
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[9]/android.widget.RelativeLayout/android.widget.EditText").click();
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[9]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("清洁工");


        Util.sleep(2000);
        new TouchAction(mDriver).press(PointOption.point(100, 944))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(100, 177)).release().perform();


        //设置部门
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.RelativeLayout").click();
        Util.sleep(2000);
        mDriver.findElementById("com.tencent.wework:id/hmy").click();

        //设置身份
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout").click();
        Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout").click();

        Util.sleep(2000);
        new TouchAction(mDriver).press(PointOption.point(100, 944))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(100, 177)).release().perform();

       Util.sleep(2000);
        mDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[5]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout").click();
        Util.sleep(2000);
        mDriver.findElementById("com.tencent.wework:id/c0x").click();

        Util.sleep(2000);
        mDriver.findElementById("com.tencent.wework:id/d6p").click();
        //对外职务
        Util.sleep(2000);
        mDriver.findElementById("com.tencent.wework:id/e6i").sendKeys("CEO");
        Util.sleep(2000);
        mDriver.findElementById("com.tencent.wework:id/j05").click();



        Util.sleep(3000);
        mDriver.findElementById("com.tencent.wework:id/ana").click();
        Util.sleep(2000);

    }

    /**
     * 判断某个元素是否存在
     */
    public boolean isJudgingElement(AndroidDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void scroll() {
        Dimension dimensions = mDriver.manage().window().getSize();

        int Startpoint = (int) (dimensions.getHeight() * 0.5);

        int scrollEnd = (int) (dimensions.getHeight() * 0.2);

        new TouchAction(mDriver).press(PointOption.point(0, Startpoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(0, scrollEnd)).release().perform();

    }
}