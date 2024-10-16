package data;

/**
 * Класс Autorization используется для осуществления авторизации пользователя в системе
 */
public class Autorization {
    /**
     * Поле email - электронный адрес почты пользователя
     */
    private String email;
    /**
     * Поле password - пароль пользователя
     */
    private String password;

    /**
     * Конструктор Autorization без параметров
     */
    public Autorization() {
        super();
    }

    /**
     * Конструктор Autorization с параметрами
     * @param email - электронный адрес почты пользователя
     * @param password - пароль пользователя
     */
    public Autorization(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Геттер email
     * @return - возвращает электронный адрес почты пользователя
     */
    public String getEmail() {
        return email;
    }

    /**
     * Сеттер email
     * @param email - задаёт адрес почты пользователя
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Геттер password
     * @return - возвращает пароль пользователя
     */
    public String getPassword() {
        return password;
    }

    /**
     * Сеттер password
     * @param password - задаёт пароль для пользователя
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
