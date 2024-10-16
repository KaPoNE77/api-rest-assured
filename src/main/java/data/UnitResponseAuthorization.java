package data;

/**
 * @author Сергей Канаев
 * Класс UnitResponseAuthorization содержит в себе переменные для токена и ошибки при неуспешной авторизации
 */
public class UnitResponseAuthorization {
    /**
     * Переменная String token - токен для авторизации
     */
    private String token;
    /**
     * Переменная String error - ошибка при неуспешной авторизации
     */
    private String error;

    /**
     * Конструктор UnitResponseAuthorization без параметров
     */
    public UnitResponseAuthorization() {
        super();
    }

    /**
     * Конструктор UnitResponseAuthorization с параметрами
     * @param token - токен для авторизации
     * @param error - ошибка при неуспешной авторизации
     */
    public UnitResponseAuthorization(String token, String error) {
        this.token = token;
        this.error = error;
    }

    /**
     * Геттер getToken для получения токена
     * @return - возвращает токен
     */
    public String getToken() {
        return token;
    }

    /**
     * Сеттер token
     * @param token - строка токена
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Геттер getError для получения сообщения об ошибке
     * @return
     */
    public String getError() {
        return error;
    }

    /**
     * Сеттер setError
     * @param error - строка ошибки при неудачной авторизации
     */
    public void setError(String error) {
        this.error = error;
    }
}
