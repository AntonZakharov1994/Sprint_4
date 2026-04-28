package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;

import java.util.Arrays;
import java.util.Collection;

import static page.Answer.*;

@RunWith(Parameterized.class)
public class FAQTest extends BaseTest {

    private final int questionNumber;
    private final String expectedAnswer;

    // Конструктор для получения параметров
    public FAQTest(int questionNumber, String expectedAnswer) {
        this.questionNumber = questionNumber;
        this.expectedAnswer = expectedAnswer;
    }

    // Метод, предоставляющий данные для тестов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, ANSWER_TEST_ONE},
                {2, ANSWER_TEST_TWO},
                {3, ANSWER_TEST_THREE},
                {4, ANSWER_TEST_FOUR},
                {5, ANSWER_TEST_FIVE},
                {6, ANSWER_TEST_SIX},
                {7, ANSWER_TEST_SEVEN},
                {8, ANSWER_TEST_EIGHT}
        });
    }

    @Test
    public void correctAnswerTest() {
        MainPage objMain = new MainPage(driver);

        // Скролл до вопросов — выполняется для каждого теста
        objMain.scrollToFAQ();
        objMain.clickCookieButton();

        switch (questionNumber) {
            case 1:
                objMain.clickQuestion1();
                objMain.isCorrectText(objMain.getAnswerOne(), expectedAnswer);
                break;
            case 2:
                objMain.clickQuestion2();
                objMain.isCorrectText(objMain.getAnswerTwo(), expectedAnswer);
                break;
            case 3:
                objMain.clickQuestion3();
                objMain.isCorrectText(objMain.getAnswerThree(), expectedAnswer);
                break;
            case 4:
                objMain.clickQuestion4();
                objMain.isCorrectText(objMain.getAnswerFour(), expectedAnswer);
                break;
            case 5:
                objMain.clickQuestion5();
                objMain.isCorrectText(objMain.getAnswerFive(), expectedAnswer);
                break;
            case 6:
                objMain.clickQuestion6();
                objMain.isCorrectText(objMain.getAnswerSix(), expectedAnswer);
                break;
            case 7:
                objMain.clickQuestion7();
                objMain.isCorrectText(objMain.getAnswerSeven(), expectedAnswer);
                break;
            case 8:
                objMain.clickQuestion8();
                objMain.isCorrectText(objMain.getAnswerEight(), expectedAnswer);
                break;
        }
    }
}
