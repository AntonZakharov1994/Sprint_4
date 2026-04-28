package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.OrderPage;


@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTest (String name, String surname, String address, String station, String phoneNumber, String date, String rentalPeriod, String color, String comment ){
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.station=station;
        this.phoneNumber=phoneNumber;
        this.date=date;
        this.rentalPeriod=rentalPeriod;
        this.color=color;
        this.comment=comment;
    }
    @Parameterized.Parameters
    public static Object[][] getOrder(){
        return new Object[][]{
                {"Антон", "Захаров", "г.Купавна", "Бульвар Рокоссовского", "+79876543211", "11.11.2026", "сутки", "чёрный жемчуг", "Позвонить за 15 минут"},
                {"Александр", "Васильев", "г.Москва", "Черкизовская", "89876544569", "11.11.2026", "двое суток", "серая безысходность", "Позвонить за 15 минут"}
        };
    }
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //Открыть страницу "Яндекс Самокат"
        driver.get("https://qa-scooter.praktikum-services.ru/order");
    }
    @Test
    public void MakingAnOrderTest(){

        OrderPage objOrder = new OrderPage(driver);
        //Заполняем поля первой страницы заказа
        objOrder.setFirstFormOrder(name, surname, address, station, phoneNumber);
        //Клик по кнопке "Далее"
        objOrder.clickNextOrderButton();
        //Заполняем поля второй страницы заказа
        objOrder.setSecondFormOrder( date,  rentalPeriod,  color,  comment );
        //Клик по кнопке "Заказать"
        objOrder.clickCreateOrderButton();
        //Клик по кнопке "Да"
        objOrder.clickConfirmOrder();
        //Проверка, что открылся элемент "Заказ оформлен"
        boolean isOrderPassShown = objOrder.findElementOrderPass();
        org.junit.Assert.assertTrue("Заказ не оформлен", isOrderPassShown);

    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}
