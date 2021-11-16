package com.example.lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.lib.setting.ExtendWatcher;
import com.example.lib.setting.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static com.example.lib.config.Config.MAIN_ACTIVITY;

public class AutoTest {
    private AndroidDriver driver; // 测试手机的控制者
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
        driver = new Util().initDriver();

    }
    
    @After
    public void tearDown() {
        // testcase测试结束后关闭连接
       driver.quit();
    }
    
    @org.junit.Test
    public void test() {
        Util.waitActivity(MAIN_ACTIVITY, 6, driver);

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/f02' and @text = '工作台' ]").click();

        //顶部
        scrollToxy(302,121,302,1152);

        //日程
        scrollToxy(302,1146,302,200);
        scrollToxy(302,1139,302,590);

        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/fpv' and @text = '日程' ]").click();

        Util.sleep(5000);
        driver.findElementById("com.tencent.wework:id/iwf").click();


        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/bfd' and @text = '参与人' ]").click();
        driver.findElementByXPath("//*[@text = '从群聊中选择' ]").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout").click();
        driver.findElementById("com.tencent.wework:id/hkb").click();


        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/bfd' and @text = '提醒我' ]").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"确定\")").click();

        driver.findElementById("com.tencent.wework:id/bqv").click();

        String text = "text";
        driver.findElementById("com.tencent.wework:id/bqv").sendKeys(text);

        driver.findElementById("com.tencent.wework:id/iv0").click();

        Util.sleep(5000);
        //结果断言
        assert (driver.findElementById("com.tencent.wework:id/it3").getAttribute("text").equals(text)):"添加代办事件失败";

        driver.findElementById("com.tencent.wework:id/ivv").click();
    }

    /**
     * 判断某个元素是否存在
     */
    public boolean isJudgingElement(AndroidDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void scroll() {
        Dimension dimensions = driver.manage().window().getSize();

        int Startpoint = (int) (dimensions.getHeight() * 0.5);

        int scrollEnd = (int) (dimensions.getHeight() * 0.2);

        new TouchAction(driver).press(PointOption.point(0, Startpoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(0, scrollEnd)).release().perform();

    }

    public void scrollToxy(int fromX,int fromY,int toX,int toY){
        new TouchAction(driver).press(PointOption.point(fromX, fromY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(toX, toY)).release().perform();
    }
}