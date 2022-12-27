package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        String browserName = "chrome";
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E://Automation Repo//Driver//chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Chrome browser started");
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
