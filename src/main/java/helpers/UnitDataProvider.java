package helpers;

import config.UnitProperties;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static config.Properties.*;


/**
 * @author Сергей Канаев
 * Класс, который параметризует тесты
 */
public class UnitDataProvider {
    /**
     * Метод unitDataProviderAvatar предоставляет набор параметров для теста
     * @return - возвращает набор параметров
     */
    public static List<String> unitDataProviderAvatar() {
        return Arrays.asList(
            unitProperties.avatarNameValid(), unitProperties.avatarNameInValid(), unitProperties.avatarNameEmpty()
        );
    }

    /**
     * Метод unitDataProviderSuccessAuthorization предоставляет набор аргуметов-параметров для теста
     * @return - возвращает набор аргуметов-параметров для теста
     */
    public static Stream<Arguments> unitDataProviderSuccessAuthorization() {
        return Stream.of(
                Arguments.of(unitProperties.successAuthorizationValidToken(), unitResponse.tokenResponse(), unitRequest.validScenario()),
                Arguments.of(unitProperties.successAuthorizationInvalidToken(), unitResponse.tokenResponse(), unitRequest.validScenario()),
                Arguments.of(unitProperties.successAuthorizationEmptyToken(), unitResponse.tokenResponse(), unitRequest.validScenario())
        );
    }
    /**
     * Метод unitDataProviderUnSuccessfulAuthorization предоставляет набор аргуметов-параметров для теста
     * @return - возвращает набор аргуметов-параметров для теста
     */
    public static Stream<Arguments> unitDataProviderUnSuccessfulAuthorization() {
        return Stream.of(
                Arguments.of(unitProperties.unsuccessAuthorizationValidErrorMessage(), unitResponse.errorResponse(), unitRequest.invalidScenario()),
                Arguments.of(unitProperties.unsuccessAuthorizationInvalidErrorMessage(), unitResponse.errorResponse(), unitRequest.invalidScenario()),
                Arguments.of(unitProperties.unsuccessAuthorizationEmptyErrorMessage(), unitResponse.errorResponse(), unitRequest.invalidScenario())
        );
    }

    /**
     * Метод unitDataProviderSortedYears предоставляет набор параметров для теста
     * @return - возвращает набор параметров
     */
    public static List<String> unitDataProviderSortedYears() {
        return Arrays.asList(
                unitProperties.resourceOfYearsValid(), unitProperties.resourceOfYearsInvalid(), unitProperties.resourceOfYearsEmpty()
        );
    }

    /**
     * Метод unitDataProviderCheckTags предоставляет набор параметров для теста
     * @return - возвращает набор параметров для теста
     */
    public static Stream<Arguments> unitDataProviderCheckTags() {
        String pathTags = unitProperties.testDataJsonPath() + "/";
        return Stream.of(
                Arguments.of(pathTags + unitProperties.tagCountListValidValueUnitTest(), unitProperties.tagNumber()),
                Arguments.of(pathTags + unitProperties.tagCountListLessValueUnitTest(), unitProperties.tagNumber()),
                Arguments.of(pathTags + unitProperties.tagCountListMoreValueUnittest(), unitProperties.tagNumber())
        );
    }
}
