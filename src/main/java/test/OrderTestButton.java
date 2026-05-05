package test;

import org.junit.Test;
import page.MainPage;
import page.OrderPage;
import static org.junit.Assert.assertTrue;


public class OrderTestButton extends BaseTest {


    @Test
    public void OrderTestButtonTop(){
        //Создаем объект класса домашней страницы
        MainPage objMain = new MainPage(driver);
        //Нажатие на кнопку "Заказать" вверху страницы
        objMain.clickButtonTopOrder();
        //Создаем обеъект класса страницы заказа
        OrderPage objOrder = new OrderPage(driver);
        //Проверка, что страница заказа открылась
        assertTrue("Страница заказа не открылась после нажатия кнопки вверху", OrderPage.isOrderPageOpened());

    }


    @Test
    public void OrderTestButtonDown(){

        MainPage objMain = new MainPage(driver);
        //Скрол
        objMain.scrollButtonOrderDown();
        objMain.clickButtonDownOrder();
        OrderPage objOrder = new OrderPage(driver);
        assertTrue("Страница заказа не открылась после нажатия кнопки вверху", OrderPage.isOrderPageOpened());
    }

}
