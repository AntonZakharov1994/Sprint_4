package page.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.scooter.praktikum.page.MainPage;
import ru.scooter.praktikum.page.OrderPage;


public class OrderTestButton {

    private WebDriver driver;
    @Test
    public void OrderTestButtonTop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //Открыть страницу "Яндекс Самокат"
        driver.get("https://qa-scooter.praktikum-services.ru");
        //Создаем объект класса домашней страницы
        MainPage objMain = new MainPage(driver);
        //Нажатие на кнопку "Заказать" вверху страницы
        objMain.clickButtonTopOrder();
        //Создаем обеъект класса страницы заказа
        OrderPage objOrder = new OrderPage(driver);
        //Проверка, что страница заказа открылась
        wait.until(driver -> driver.getCurrentUrl().contains("/order"));

    }

    @Test
    public void OrderTestButtonDown(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("https://qa-scooter.praktikum-services.ru");
        MainPage objMain = new MainPage(driver);
        //Скрол
        WebElement tableFAQ = driver.findElement(By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
        objMain.clickButtonDownOrder();
        wait.until(driver -> driver.getCurrentUrl().contains("/order"));
    }
    @After
    public void teardown() {
        // Закрой браузер
         driver.quit();
    }
}
