package page;

import org.openqa.selenium.*;


public class OrderPage {

//"Для кого самокат"

    private  WebDriver driver;
    public OrderPage(WebDriver driver){
        this.driver = driver;
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

    //Метод для заполнения поля "*Имя"
    public void setName(String name){
        driver.findElement(fieldName).sendKeys(name);
    }
    //Метод для заполнения поля "*Фамилия"
    public void setSurname(String surname){
        driver.findElement(fieldSurname).sendKeys(surname);
    }
    //Метод для заполнения поля "*Адресс: куда привезти"
    public void setAddress (String address){
        driver.findElement(fieldAddress).sendKeys(address);
    }
    //Метод для заполнения поля "*Станция метро"
    public void setStation(String station) {
        driver.findElement(fieldMetro).click();
        driver.findElement(By.xpath(".//div[text()='" + station + "']")).click();
    }
    //Метод для заполнения поля "*Телефон: на него позвонит курьер"
    public void setPhone(String phoneNumber){
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
    //Метод заполнения поля "*Когда привезти самокат"
public void setDate(String date){
    driver.findElement(fieldDate).sendKeys(date, Keys.ENTER);
}
    //Метод заполнения поля "*Срок аренды"
public void setRentalPeriod (String rentalPeriod){
    driver.findElement(fieldRentalPeriod).click();
    driver.findElement(By.xpath(".//div[text()='"+rentalPeriod+"']")).click();
}
    //Метод для выбора цвет в чек-боксе "Цвет самоката"
public void setColor (String color){
    driver.findElement(By.xpath(".//label[text()='"+color+"']")).click();
}
    //Метод для заполнения поля "Комментарий для курьера"
public void setComment(String comment){
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
        WebElement element = driver.findElement(orderPass);
        if (element != null) {
            return true;
        } else {
            return false;
        }
    }
}

