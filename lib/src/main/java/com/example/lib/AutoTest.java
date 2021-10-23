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
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
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
    public void test() throws InterruptedException {
        Util.waitActivity(MAIN_ACTIVITY, 6, driver);

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/f1r' and @text = '工作台' ]").click();

        //顶部
        scrollToxy(302,151,302,1152);

        //内部管理
        scrollToxy(302,1146,302,200);


        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/fru' and @text = '审批' ]").click();

        Util.sleep(10000);

        scrollToxy(302,151,302,1152);

        scrollToxy(36,700,36,200);

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"请假\")").click();


        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"请假类型\")").click();
        scrollToxy(223,808,223,1028);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"确定\")").click();



        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"开始时间\")").click();
        scrollToxy(229,752,229,985);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"确定\")").click();

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"结束时间\")").click();
        scrollToxy(229,992,229,670);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"确定\")").click();


        Util.sleep(5000);
        //查看时长明细
        driver.findElementByXPath("//*[@text = '当前请假时长为自动计算，查看时长明细']").click();
        //返回
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[3]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View").click();

        Util.sleep(1000);
        //请假事由
        driver.findElementByXPath("//*[@text = '请假事由']").click();
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//*[@text = '请输入请假事由']");
        el1.click();
        Util.sleep(1000);
        el1.sendKeys("身体不适");
        scroll();


        driver.findElementByXPath("//*[@class = 'android.widget.Button']").click();

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