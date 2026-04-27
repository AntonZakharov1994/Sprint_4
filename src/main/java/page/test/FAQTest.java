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
import ru.scooter.praktikum.page.MainPage;

import static page.Answer.*;


public class FAQTest {
    private WebDriver driver;


    @Test
    public void CorrectAnswerTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //Открыть страницу "Яндекс Самокат"
        driver.get("https://qa-scooter.praktikum-services.ru/");





        //Скрол до вопросов
        WebElement tableFAQ = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);


        MainPage objMain = new MainPage(driver);

objMain.clickCookieButton();

        //Проверка текста в "Вопросах о важном"
        objMain.clickQuestion1();
        objMain.isCorrectText(objMain.getAnswer1(), answerTest1);

        objMain.clickQuestion2();
        objMain.isCorrectText(objMain.getAnswer2(), answerTest2);

        objMain.clickQuestion3();
        objMain.isCorrectText(objMain.getAnswer3(), answerTest3);

        objMain.clickQuestion4();
        objMain.isCorrectText(objMain.getAnswer4(), answerTest4);

        objMain.clickQuestion5();
        objMain.isCorrectText(objMain.getAnswer5(), answerTest5);

        objMain.clickQuestion6();
        objMain.isCorrectText(objMain.getAnswer6(), answerTest6);

        objMain.clickQuestion7();
        objMain.isCorrectText(objMain.getAnswer7(), answerTest7);

        objMain.clickQuestion8();
        objMain.isCorrectText(objMain.getAnswer8(), answerTest8);
    }



    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}
