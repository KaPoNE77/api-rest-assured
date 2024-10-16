package specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * @author Сергей Канаев
 * Класс Specification используется для создания настройки спецификации для запросов и ответов в тестировании
 */
public class Specification {
    /**
     * Метод requestSpec - используется для создания спецификации запроса с базовым адресом и типом содержимого JSON
     * @return RequestSpecBuilder - используется для создания спецификаций
     */
    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType("application/json")
                .build();
    }

    /**
     * Метод responseSpec200 - используется для создания спецификации ответа с ожиданием статус-кода 200
     *
     * @return ResponseSpecBuilder - - используется для создания спецификации ожидания ответа
     */
    public static ResponseSpecification responseSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    /**
     * Метод responseSpec200 - используется для создания спецификации ответа с ожиданием статус-кода 400
     * @return ResponseSpecBuilder - - используется для создания спецификации ожидания ответа
     */
    public static ResponseSpecification responseSpec400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    /**
     * Метод installSpec - используется для создания спецификации запроса
     * @param requestSpec - специфиакация запроса
     */
    public static void installSpec(RequestSpecification requestSpec) {
        RestAssured.requestSpecification = requestSpec;
    }

    /**
     * Метод installSpec - используется для создания спецификации ответа
     * @param responseSpec - спецификация ответа
     */
    public static void instalSpec(ResponseSpecification responseSpec) {
        RestAssured.responseSpecification = responseSpec;
    }

    /**
     * Метод installSpec - используется для создания спецификации запроса - ответа
     * @param requestSpec - специфиакация запроса
     * @param responseSpec - спецификация ответа
     */
    public static void installSpec(RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }

    /**
     * Метод deleteSpec - используется для удаления установленных спецификаций запроса - ответа
     */
    public static void deleteSpec() {
        RestAssured.requestSpecification = null;
        RestAssured.responseSpecification = null;
    }
}
