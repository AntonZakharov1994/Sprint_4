package page;


import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка "Заказать" вверху страницы
    private By topOrder = By.className("Button_Button__ra12g");

    //Кнопка "Статус заказа"
    private By orderStatus = By.className("Header_Link__1TAG7");

    // Кнопка "Заказать" внизу страницы
    private By downOrder = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");

    //локатор для вопросов
    private By questionAccardion = By.className("accordion");

//Метод: Клик по кнопке "Заказать" вверху страницы
    public void clickButtonTopOrder() {
        driver.findElement(topOrder).click();
    }

    //Метод: Клик по кнопке "Статус заказа"
    public void clickOrderStatus(){
        driver.findElement(orderStatus).click();
    }

    //
    public void scrollButtonOrderDown(){
    WebElement tableFAQ = driver.findElement(By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);}

    //Метод: Клик по кнопке "Заказать" внизу страницы
    public void clickButtonDownOrder(){
        driver.findElement(downOrder).click();
    }
    //Метод для скрола к вопросам
    public void scrollToFAQ() {
        WebElement accordionElement = driver.findElement(By.className("accordion"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", accordionElement);
    }

    //Выпадающий список "Вопросы о важном"
    private By questionOne = By.xpath(".//div[@class='accordion__item'][1]"); //Сколько это стоит? И как оплатить?
    private By questionTwo = By.xpath(".//div[@class='accordion__item'][2]"); //Хочу сразу несколько самокатов! Так можно?
    private By questionThree = By.xpath(".//div[@class='accordion__item'][3]"); //Как рассчитывается время аренды?
    private By questionFour = By.xpath(".//div[@class='accordion__item'][4]");//Можно ли заказать самокат прямо на сегодня?
    private By questionFive = By.xpath(".//div[@class='accordion__item'][5]"); //Можно ли продлить заказ или вернуть самокат раньше?
    private By questionSix = By.xpath(".//div[@class='accordion__item'][6]"); //Вы привозите зарядку вместе с самокатом?
    private By questionSeven = By.xpath(".//div[@class='accordion__item'][7]"); //Можно ли отменить заказ?
    private By questionEight = By.xpath(".//div[@class='accordion__item'][8]"); //Я жизу за МКАДом, привезёте?

    //Метод раскрывающий "Вопросы о важном"
    public void clickQuestion1(){
        driver.findElement(questionOne).click();
    }
    public void clickQuestion2(){
        driver.findElement(questionTwo).click();
    }
    public void clickQuestion3(){
        driver.findElement(questionThree).click();
    }
    public void clickQuestion4(){
        driver.findElement(questionFour).click();
    }
    public void clickQuestion5(){
        driver.findElement(questionFive).click();
    }
    public void clickQuestion6(){
        driver.findElement(questionSix).click();
    }
    public void clickQuestion7(){
        driver.findElement(questionSeven).click();
    }
    public void clickQuestion8(){
        driver.findElement(questionEight).click();
    }
//Ответы на вопросы
    private By answerOne = By.id("accordion__panel-0"); //Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private By answerTwo = By.id("accordion__panel-1"); //Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private By answerThree = By.id("accordion__panel-2"); //Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private By answerFour = By.id("accordion__panel-3"); //Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private By answerFive = By.id("accordion__panel-4"); //Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private By answerSix = By.id("accordion__panel-5"); //Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private By answerSeven = By.id("accordion__panel-6"); //Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private By answerEight = By.id("accordion__panel-7"); //Да, обязательно. Всем самокатов! И Москве, и Московской области.
//Методы для получения текста вопросов
    public String getAnswerOne(){
        return driver.findElement(answerOne).getText();
    }
    public String getAnswerTwo(){
        return driver.findElement(answerTwo).getText();
    }
    public String getAnswerThree(){
        return driver.findElement(answerThree).getText();
    }
    public String getAnswerFour(){
        return driver.findElement(answerFour).getText();
    }
    public String getAnswerFive(){
        return driver.findElement(answerFive).getText();
    }
    public String getAnswerSix(){
        return driver.findElement(answerSix).getText();
    }
    public String getAnswerSeven(){
        return driver.findElement(answerSeven).getText();
    }
    public String getAnswerEight(){
        return driver.findElement(answerEight).getText();
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




