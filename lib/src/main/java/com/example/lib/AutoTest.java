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
import java.util.concurrent.TimeUnit;
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

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/f1r' and @text = '通讯录' ]").click();

        Util.sleep(5000);
        scroll();

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"添加成员\")").click();
        driver.findElementById("com.tencent.wework:id/d7z").click();
        if(isJudgingElement(driver,By.id("com.tencent.wework:id/ana"))){
            driver.findElementById("com.tencent.wework:id/izu").click();
        }

        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/bf_' and @text = '必填' ]").sendKeys("张三");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("1234455");

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("三三");
        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/bg1' and @text = '男' ]").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout").click();
        driver.findElementById("com.tencent.wework:id/ge4").sendKeys("13560959999");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[6]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("3356569");


        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[7]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("985684449@qq.com");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[8]/android.widget.RelativeLayout/android.widget.LinearLayout").click();

        driver.findElementById("com.tencent.wework:id/kq").sendKeys("腾讯大厦");

        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/j8j' and @text = '腾讯大厦' ]").click();
        driver.findElementById("com.tencent.wework:id/j05").click();


        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[9]/android.widget.RelativeLayout/android.widget.EditText").sendKeys("清洁工");
        driver.findElementById("com.tencent.wework:id/e5u").click();

        new TouchAction(driver).press(PointOption.point(308, 1270))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(308, 180)).release().perform();



        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/bg1' and @text = '设置部门' ]").click();
        driver.findElementById("com.tencent.wework:id/hmy").click();

        driver.findElementByXPath("//*[@resource-id = 'com.tencent.wework:id/bg1' and @text = '普通成员' ]").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout").click();

        driver.findElementById("com.tencent.wework:id/k63").click();
        driver.findElementById("com.tencent.wework:id/c0x").click();
        driver.findElementById("com.tencent.wework:id/d6p").click();

        driver.findElementById("com.tencent.wework:id/e6i").sendKeys("清洁大叔");
        driver.findElementById("com.tencent.wework:id/j05").click();

        new TouchAction(driver).press(PointOption.point(308, 1270))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(308, 180)).release().perform();

        driver.findElementById("com.tencent.wework:id/ana").click();

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
}