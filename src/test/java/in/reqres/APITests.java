package in.reqres;

import data.*;
import helpers.TestDataProvider;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Document;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static specification.Specification.*;

public class APITests {
    /**
     * Пробный тест для проверки обращения к ресурсу дял получения ответа в виде данных
     */
    @Test
    public void firstTest() {
        // чтобы отправить API запрос нужно написать given()
        given()
                // после блока given() идёт настройка запроса
                .when()
                // создаём блок запроса и задаём ссылку (если не была создана ранее)
                .get("https://reqres.in/api/users?page=2")
                //блок when() закончен, дальше идёт блок then()
                // в блоке then() мы делаем различную обработку запроса, т.е. то, что будем делать с ответом
                .then()
                // напечатаем всё в консоль с помощью команды log().all()
                .log().all()
                .body("data.first_name", not(hasItem(nullValue())))
                .statusCode(200);
                //.body("data.first_name", not(hasItem(nullValue())))
    }

    /**
     * Метод checkUniqueFileName описывает алгоритм проверки имён файлов аватаров пользователей на уникальность
     */
    @Test(description = "Проверка имён файлов аватаров пользователей на уникальность")
    public void checkUniqueFileName() {
        Resourse resourse = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .extract().as(Resourse.class);
        System.out.println("------------------------------------------------------");
        List<DataUser> users = resourse.getData();

        Set<String> uniqueAvatar = new HashSet<>();
            for (DataUser user : users) {
                String userAvatar = user.getAvatar();
                String avatarName = userAvatar.substring(userAvatar.lastIndexOf('/') + 1);
                if (!uniqueAvatar.add(avatarName)) {
                    Assert.fail("Имя файла не уникальное" + avatarName);
                }
            }

        Assert.assertEquals(uniqueAvatar.size(), users.size(),
                "Уникальные имена файлов аватаров пользователей равное: " + uniqueAvatar.size() + " не совпадает с количеством пользователей: " + users.size());
    }

    /**
     * Метод checkAuthorizationSuccessful описывает алгоритм успешной проверки авторизации пользователя
     * @param email - адрес электронной почты пользователя
     * @param password - пароль для успешной авторизации пользователя
     * @param token - токен, получаемый после успешной авторизации пользователя
     */
    @Test(description = "Проверка авторизации пользователя(успешная)",
    dataProvider = "checkAuthorizationSuccessful", dataProviderClass = TestDataProvider.class)
    public void checkAuthorizationSuccessful(String email, String password, String token) {
        Authorization authorization = new Authorization(email, password);
        installSpec(requestSpec());
        instalSpec(responseSpec200());

        Response response = given()
                .body(authorization)
                .when()
                .post("/api/login")
                .then()
                .extract().response();
        JsonPath jsonResponse = response.jsonPath();
        String getToken = jsonResponse.getString("token");

        Assert.assertEquals(getToken, token,
                "При регистрации ожидаем получения токена(token): " + token + " отличающийся от " +
                        "того, который в ответе: " + getToken);
        deleteSpec();
    }

    /**
     * Метод checkAuthorizationUnSuccessful описывает алгоритм неуспешной атвторизации пользователя
     * @param email - адрес электронной почты пользователя
     * @param error - сообщение об ошибки при авторизации
     */
    @Test(description = "Проверка авторизации пользователя(неуспешная)",
            dataProvider = "checkAuthorizationUnSuccessful", dataProviderClass = TestDataProvider.class)
    public void checkAuthorizationUnSuccessful (String email, String error) {
        Authorization authorization = new Authorization(email);
        installSpec(requestSpec());
        instalSpec(responseSpec400());

        Response response = given()
                .body(authorization)
                .when()
                .post("/api/login")
                .then()
                .log().body()
                .statusCode(400)
                .extract().response();
        JsonPath jsonResponse = response.jsonPath();
        String getError = jsonResponse.getString("error");

        Assert.assertEquals(getError, error,
                "При регистрации ожидаем получения ошибки: " + getError + " отличающейся от " +
                        "той, которая в ответе: " + error);

        deleteSpec();
    }

    @Test(description = "Тест на проверку данных по годам")
    public void checkOnSortedDataByYears() {
        installSpec(requestSpec());
        instalSpec(responseSpec200());

        ResourceOfColor resourceOfColor = given()
                .when()
                .get("/api/unknown")
                .then()
                .log().body()
                .extract().body().as(ResourceOfColor.class);

        List<Integer> yearsToList = resourceOfColor.getData().stream()
                .map(DataColor::getYear)
                .collect(Collectors.toList());
        List<Integer> sortedYearsToList = yearsToList.stream()
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(yearsToList, sortedYearsToList,
                "Полученные данные не отсортированы по годам");

        deleteSpec();
    }


    @Test(description = "Проверка XML-тела ответа на количество тегов",
    dataProvider = "xmlTagCount", dataProviderClass = TestDataProvider.class)
    public void checkTagCount(int xmlTagCount) {
        String xmlData = given()
                .when()
                .get("https://gateway.autodns.com/")
                .then()
                .log().body()
                .extract().body().asString();

        long countTags = Pattern.compile("<[^!/][^<]+>").matcher(xmlData).results().count();

        Assert.assertEquals(countTags, xmlTagCount,
                "Ожидаемое количество тегов: " + xmlTagCount + " а по факту: " + countTags);
    }
}



