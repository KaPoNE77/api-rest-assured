package unit;

import data.*;
import groovy.json.JsonOutput;
import helpers.JsonHelper;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static config.Properties.unitProperties;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specification.Specification.deleteSpec;

/**
 * @author Сергей Канаев
 * Класс UnitTests содержит в себе методы проверки тестов по заданию
 */
public class UnitTests {

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Тест на тест что имена файлов автаров пользователей уникальны")
    @MethodSource("helpers.UnitDataProvider#unitDataProviderAvatar")
    public void checkUniqueFileName (String jsonPath) {
        Resourse resourse = JsonHelper.fromJSONFile(jsonPath, Resourse.class);
        List<DataUser> users = resourse.getData();
        Set<String> uniqueAvatar = new HashSet<>();
        for (DataUser user : users) {
            String userAvatar = user.getAvatar();
            String avatarName = userAvatar.substring(userAvatar.lastIndexOf('/') + 1);
            if (!uniqueAvatar.add(avatarName)) {
                Assert.fail("Имя файла не уникальное: " + avatarName);
            }
        }
        assertTrue(users.size() > 0,
                "Список с именами файлов аватаров пользователей пуст!");

        deleteSpec();
    }

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Тест на тест по авторизации пользователя успешная")
    @MethodSource("helpers.UnitDataProvider#unitDataProviderSuccessAuthorization")
    public void checkAuthorizationSuccessful (String jsonPath, String expectedResponse) {
        UnitResponseAuthorization unitResponseAuthorization = JsonHelper.fromJSONFile(jsonPath, UnitResponseAuthorization.class);

        String getToken = unitResponseAuthorization.getToken();
        Assert.assertEquals(getToken, expectedResponse,
                "При регистрации ожидаем получения токена(token): " + expectedResponse + " отличающийся от " +
                        "того, который в ответе: " + getToken);
        deleteSpec();
    }

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Тест на тест по авторизации пользователя отрицательная")
    @MethodSource("helpers.UnitDataProvider#unitDataProviderUnSuccessfulAuthorization")
    public void checkAuthorizationUnSuccessful(String jsonPath, String expectedResponse) {
        UnitResponseAuthorization unitResponseAuthorization = JsonHelper.fromJSONFile(jsonPath, UnitResponseAuthorization.class);

        String getError = unitResponseAuthorization.getError();
        Assert.assertEquals(getError, expectedResponse,
                "При регистрации ожидаем получения ошибки: " + getError + " отличающейся от " +
                        "той, которая в ответе: " + expectedResponse);

        deleteSpec();
    }

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Тест на тест по проверке сортировки по годам")
    @MethodSource("helpers.UnitDataProvider#unitDataProviderSortedYears")
    public void checkOnSortedDataByYears(String jsonPath) {
        ResourceOfColor resourceOfColor = JsonHelper.fromJSONFile(jsonPath, ResourceOfColor.class);
        List<Integer> yearsToList = resourceOfColor.getData().stream()
                .map(DataColor::getYear)
                .collect(Collectors.toList());
        List<Integer> sortedYearsToList = yearsToList.stream()
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(yearsToList, sortedYearsToList,
                "Полученные данные не отсортированы по годам");
        Assert.assertTrue(yearsToList.size() > 0,
                "Список для теста по проверке по годам пуст.");

        deleteSpec();
    }

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Тест на тест по проверке количества тегов")
    @MethodSource("helpers.UnitDataProvider#unitDataProviderCheckTags")
    public void checkTagCount(String pathTags, int xmlJsonPath) {
        String stringOfTags;
        try {
            stringOfTags = new String(Files.readAllBytes(Paths.get(pathTags)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long countTags = Pattern.compile("<[^!/][^<]+>").matcher(stringOfTags).results().count();
        Assert.assertEquals(countTags, xmlJsonPath,
                "Ожидаемое количество тегов: " + xmlJsonPath + " а по факту: " + countTags);
    }
}
