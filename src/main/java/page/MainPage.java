package page;


import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //Кнопка "Заказать" вверху страницы
    private By topOrder = By.className("Button_Button__ra12g");

    //Кнопка "Статус заказа"
    private By orderStatus = By.className("Header_Link__1TAG7");

    // Кнопка "Заказать" внизу страницы
    private By downOrder = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");

//Метод: Клик по кнопке "Заказать" вверху страницы
    public void clickButtonTopOrder() {
        driver.findElement(topOrder).click();
    }

    //Метод: Клик по кнопке "Статус заказа"
    public void clickOrderStatus(){
        driver.findElement(orderStatus).click();
    }

    //Метод: Клик по кнопке "Заказать" внизу страницы
    public void clickButtonDownOrder(){
        driver.findElement(downOrder).click();
    }
    //Выпадающий список "Вопросы о важном"
    private By question1 = By.xpath(".//div[@class='accordion__item'][1]"); //Сколько это стоит? И как оплатить?
    private By question2 = By.xpath(".//div[@class='accordion__item'][2]"); //Хочу сразу несколько самокатов! Так можно?
    private By question3 = By.xpath(".//div[@class='accordion__item'][3]"); //Как рассчитывается время аренды?
    private By question4 = By.xpath(".//div[@class='accordion__item'][4]");//Можно ли заказать самокат прямо на сегодня?
    private By question5 = By.xpath(".//div[@class='accordion__item'][5]"); //Можно ли продлить заказ или вернуть самокат раньше?
    private By question6 = By.xpath(".//div[@class='accordion__item'][6]"); //Вы привозите зарядку вместе с самокатом?
    private By question7 = By.xpath(".//div[@class='accordion__item'][7]"); //Можно ли отменить заказ?
    private By question8 = By.xpath(".//div[@class='accordion__item'][8]"); //Я жизу за МКАДом, привезёте?

    //Метод раскрывающий "Вопросы о важном"
    public void clickQuestion1(){
        driver.findElement(question1).click();
    }
    public void clickQuestion2(){
        driver.findElement(question2).click();
    }
    public void clickQuestion3(){
        driver.findElement(question3).click();
    }
    public void clickQuestion4(){
        driver.findElement(question4).click();
    }
    public void clickQuestion5(){
        driver.findElement(question5).click();
    }
    public void clickQuestion6(){
        driver.findElement(question6).click();
    }
    public void clickQuestion7(){
        driver.findElement(question7).click();
    }
    public void clickQuestion8(){
        driver.findElement(question8).click();
    }
//Ответы на вопросы
    private By answer1 = By.id("accordion__panel-0"); //Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private By answer2 = By.id("accordion__panel-1"); //Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private By answer3 = By.id("accordion__panel-2"); //Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private By answer4 = By.id("accordion__panel-3"); //Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private By answer5 = By.id("accordion__panel-4"); //Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private By answer6 = By.id("accordion__panel-5"); //Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private By answer7 = By.id("accordion__panel-6"); //Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private By answer8 = By.id("accordion__panel-7"); //Да, обязательно. Всем самокатов! И Москве, и Московской области.
//Методы для получения текста вопросов
    public String getAnswer1(){
        return driver.findElement(answer1).getText();
    }
    public String getAnswer2(){
        return driver.findElement(answer2).getText();
    }
    public String getAnswer3(){
        return driver.findElement(answer3).getText();
    }
    public String getAnswer4(){
        return driver.findElement(answer4).getText();
    }
    public String getAnswer5(){
        return driver.findElement(answer5).getText();
    }
    public String getAnswer6(){
        return driver.findElement(answer6).getText();
    }
    public String getAnswer7(){
        return driver.findElement(answer7).getText();
    }
    public String getAnswer8(){
        return driver.findElement(answer8).getText();
    }
    //Кнопка "Да все привыкли"
    private By cookieButton = By.xpath("//button[text()='да все привыкли']");
    //Метод для закрытия cookie
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    //Метод для сравнения ответов
    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, is(text));
    }

}




