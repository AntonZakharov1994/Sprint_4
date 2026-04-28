package page;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPage {

//"Для кого самокат"

    private  WebDriver driver;
    private static WebDriverWait wait;
    public OrderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public static void isOrderPageOpened() {
        wait.until(driver -> driver.getCurrentUrl().contains("/order"));
    }


    //Поле "*Имя"
    private By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    //Поле "*Фамилия"
    private By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "*Адрес: куда привезти заказ"
    private By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Список "*Станция метро"
    private By fieldMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле "*Телефон: на него позвонит курьер"
    private By fieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    private By nextOrderButton = By.xpath(".//button[text()='Далее']");

    //Метод для заполнения первой формы
    public void setFirstFormOrder(String name, String surname, String address, String station, String phoneNumber){
        //заполнения поля "*Имя"
        driver.findElement(fieldName).sendKeys(name);
        //заполнения поля "*Фамилия"
        driver.findElement(fieldSurname).sendKeys(surname);
        //заполнения поля "*Адресс: куда привезти"
        driver.findElement(fieldAddress).sendKeys(address);
        //заполнения поля "*Станция метро"
        driver.findElement(fieldMetro).click();
        driver.findElement(By.xpath(".//div[text()='" + station + "']")).click();
        //заполнения поля "*Телефон: на него позвонит курьер"
        driver.findElement(fieldPhone).sendKeys(phoneNumber);
    }



    //Метод для нажатия кнопки "Далее"
    public void clickNextOrderButton (){
        driver.findElement(nextOrderButton).click();
    }

//"Про аренду"

    //Поле "*Когда привезти самокат"
    private By fieldDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле "*Срок аренды"
    private By fieldRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Поле "Комментарий для курьера"
    private By fieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private By createOrderButton = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    //Кнопка подтверждения оформления заказа
    private By сonfirmOrder = By.xpath("//button[text()='Да']");

    //Метод заполнения полей второй формы
    public void setSecondFormOrder(String date, String rentalPeriod, String color, String comment ) {
        //поля "*Когда привезти самокат"
        driver.findElement(fieldDate).sendKeys(date, Keys.ENTER);

        driver.findElement(fieldRentalPeriod).click();
        driver.findElement(By.xpath(".//div[text()='"+rentalPeriod+"']")).click();
        //выбора цвет в чек-боксе "Цвет самоката"
        driver.findElement(By.xpath(".//label[text()='"+color+"']")).click();
        //заполнения поля "Комментарий для курьера"
        driver.findElement(fieldComment).sendKeys(comment);
    }






    //Метод для нажатия на кнопку "Заказать"
    public void clickCreateOrderButton(){
    driver.findElement(createOrderButton).click();
    }
    //Метод для нажатия "Да"
    public void clickConfirmOrder(){
    driver.findElement(сonfirmOrder).click();
    }

    //Окно заказ оформлен
    private By orderPass = By.xpath("//div[text()='Заказ оформлен']");

    public boolean findElementOrderPass() {
        try {
            WebElement element = driver.findElement(orderPass);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

