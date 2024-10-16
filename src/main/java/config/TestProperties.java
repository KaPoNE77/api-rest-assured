package config;
import org.aeonbits.owner.Config;
import static org.aeonbits.owner.Config.*;
@LoadPolicy(LoadType.MERGE)
@Sources({"file:src/test/resources/tests.properties"})
public interface TestProperties extends Config {
    @Key("reqresapi.url")
    String reqresApiUrl();
    /**
     * метод возвращает имя файла
     */
    @Config.Key("file.name.avatar.valid")
    String validAvatarnameJson();

    /**
     * Метод возвращает адрес нахождения файлов для тестирования
     * @return строка
     */
    @Key("testdata.json.path")
    String testDataJsonPath();

}
