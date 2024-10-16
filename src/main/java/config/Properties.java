package config;

import org.aeonbits.owner.ConfigFactory;
/**
 * Класс управления глобальными настройками (пропертями)
 */
public class Properties {
    /**
     * Переменная testProperties для доступа к интерфейсу тестов
     */
    public static config.TestProperties testProperties = ConfigFactory.create(config.TestProperties.class);
    /**
     * Переменная unitProperties для доступа к интерфейсу юнит тестов
     */
    public static config.UnitProperties unitProperties = ConfigFactory.create(config.UnitProperties.class);
    /**
     * Переменная unitResponse для доступа к интерфейсу юнит тестов авторизации
     */
    public static config.UnitProperties unitResponse = ConfigFactory.create(config.UnitProperties.class);
    /**
     * Переменная unitRequest для доступа к интерфейсу юнит тестов авторизации
     */
    public static UnitProperties unitRequest = ConfigFactory.create(config.UnitProperties.class);


}
