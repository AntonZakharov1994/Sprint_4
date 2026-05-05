package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import page.MainPage;


public abstract class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //Открыть страницу "Яндекс Самокат"
        driver.get(MainPage.BASE_URL);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
