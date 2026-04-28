package test;

import org.junit.Test;
import page.MainPage;

import static page.Answer.*;


public class FAQTest extends BaseTest {


    @Test
    public void correctAnswerTest() {

        MainPage objMain = new MainPage(driver);

        //Скрол до вопросов
        objMain.scrollToFAQ();

        objMain.clickCookieButton();

        //Проверка текста в "Вопросах о важном"
        objMain.clickQuestion1();
        objMain.isCorrectText(objMain.getAnswer1(), ANSWER_TEST_ONE);

        objMain.clickQuestion2();
        objMain.isCorrectText(objMain.getAnswer2(), ANSWER_TEST_TWO);

        objMain.clickQuestion3();
        objMain.isCorrectText(objMain.getAnswer3(), ANSWER_TEST_THREE);

        objMain.clickQuestion4();
        objMain.isCorrectText(objMain.getAnswer4(), ANSWER_TEST_FOUR);

        objMain.clickQuestion5();
        objMain.isCorrectText(objMain.getAnswer5(), ANSWER_TEST_FIVE);

        objMain.clickQuestion6();
        objMain.isCorrectText(objMain.getAnswer6(), ANSWER_TEST_SIX);

        objMain.clickQuestion7();
        objMain.isCorrectText(objMain.getAnswer7(), ANSWER_TEST_SEVEN);

        objMain.clickQuestion8();
        objMain.isCorrectText(objMain.getAnswer8(), ANSWER_TEST_EIGHT);
    }





}
