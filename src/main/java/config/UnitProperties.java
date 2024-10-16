package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:src/test/resources/unit.properties"})
public interface UnitProperties extends Config {
    @Config.Key("avatar.name.valid")
    String avatarNameValid();

    @Config.Key("avatar.name.invalid")
    String avatarNameInValid();

    @Config.Key("avatar.name.empty")
    String avatarNameEmpty();

    @Config.Key("success.authorization.empty.token")
    String successAuthorizationEmptyToken();

    @Config.Key("success.authorization.invalid.token")
    String successAuthorizationInvalidToken();

    @Config.Key("success.authorization.valid.token")
    String successAuthorizationValidToken();

    @Config.Key("unsuccess.authorization.empty.error.message")
    String unsuccessAuthorizationEmptyErrorMessage();

    @Config.Key("unsuccess.authorization.invalid.error.message")
    String unsuccessAuthorizationInvalidErrorMessage();

    @Config.Key("unsuccess.authorization.valid.error.message")
    String unsuccessAuthorizationValidErrorMessage();

    /**
     * Метод возвращает статус теста
     * @return - позитивный сценарий
     */
    @Key("valid.scenario")
    String validScenario();

    /**
     * Метод возвращает адрес электронной почты позитивного сценария
     * @return - адрес электронной почты
     */
    @Key("email.valid.scenario")
    String emailValidScenario();

    /**
     * Метод возвращает пароль для почты позитивного сценария
     * @return - пароль для почты
     */
    @Key("password.valid.scenario")
    String passwordValidScenario();

    /**
     * Метод возвращает значение токена
     * @return строка
     */
    @Key("token.response")
    String tokenResponse();

    /**
     * Метод возвращает статус отрицательного теста
     * @return - отрицательный сценарий
     */
    @Key("invalid.scenario")
    String invalidScenario();

    /**
     * Метод возвращает пароль для почты отрицательного сценария
     * @return - адрес электронной почты
     */
    @Key("email.invalid.scenario")
    String emailInvalidScenario();

    /**
     * Метод возвращает значение ошибки
     * @return строка
     */
    @Key("error.response")
    String errorResponse();

    /**
     * Метод возвращает пустые данные по годам
     * @return строка
     */
    @Config.Key("resource.of.years.empty")
    String resourceOfYearsEmpty();
    /**
     * Метод возвращает данные по годам не отсортированные
     * @return строка
     */
    @Config.Key("resource.of.years.invalid")
    String resourceOfYearsInvalid();

    /**
     * Метод возвращает данные по годам сортированные
     * @return строка
     */
    @Config.Key("resource.of.years.valid")
    String resourceOfYearsValid();

    /**
     * Метод возвращает значение тегов, меньшее чем по условию
     * @return строка
     */
    @Config.Key("tag.count.list.less.value.unit.test")
    String tagCountListLessValueUnitTest();

    /**
     * Метод возвращает значение тегов, большее чем по условию
     * @return строка
     */
    @Config.Key("tag.count.list.more.value.unit.test")
    String tagCountListMoreValueUnittest();

    /**
     * Метод возвращает значение тегов, равное условию
     * @return строка
     */
    @Config.Key("tag.count.list.valid.value.unit.test")
    String tagCountListValidValueUnitTest();

    /**
     * Метод возвращает адрес нахождения файлов для тестирования
     * @return строка
     */
    @Key("testdata.json.path")
    String testDataJsonPath();

    /**
     * Метод возвращает число, равное количеству тэгов
     * @return
     */
    @Config.Key("tags.number")
    int tagNumber();
}
