package helpers;

import data.Authorization;
import org.testng.annotations.DataProvider;

/**
 * @author Сергей Канаев
 * Класс TestDataProvider используется для параметризации тестов
 */
public class TestDataProvider {
    /**
     * Метод correctLogin - предоставляет данные для успешной авторизации
     * @return - возвращает массив, содержащий данные для авторизации
     */
    @DataProvider(name = "checkAuthorizationSuccessful")
    public static Object[][] correctLogin() {

        return new Object[][] {{"eve.holt@reqres.in", "cityslicka", "QpwL5tke4Pnpja7X4"}};
    }

    /**
     * Метод checkAuthorizationUnSuccessful - предоставляет данные для авторизации, которая не будет выполнена
     * @return - возвращает массив, содержащий данные неуспешной авторизации
     */
    @DataProvider(name = "checkAuthorizationUnSuccessful")
    public static Object[][] unCorrectLogin() {
        return new Object[][] {{"peter@klaven", "Missing password"}};
    }

    /**
     * Метод xmlTagCount предоставляет ожидаемое количество тегов на странице
     * @return - двумерный массив, сожержащий число тегов
     */
    @DataProvider(name = "xmlTagCount")
    public static Object[][] xmlTagCount() {
        return new Object[][] {{15}};
    }
}

