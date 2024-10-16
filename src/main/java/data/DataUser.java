package data;

/**
 * @author Сергей Канаев
 * Класс DataUser содержит объект передачи данных
 */
public class DataUser {

    /**
     * id пользователя
     */
    private Integer id;

    /**
     * E-mail пользователя
     */
    private String email;

    /**
     * first_name - имя пользователя
     */
    private String first_name;

    /**
     * last_name - фамилия пользователя
     */
    private String last_name;

    /**
     * avatar - аватар пользователя
     */
    private String avatar;

    /**
     * Конструктор без параметров
     */
    public DataUser() {
        super();
    }

    /**
     * Конструктор с параметрами
     * @param id - идентификатор пользователя
     * @param email - электронные адрес почты пользователя
     * @param first_name - имя пользователя
     * @param last_name - фамилия пользователя
     * @param avatar - аватар пользователя
     */
    public DataUser(Integer id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    /**
     * Геттер поля id
     * @return - возвращает id пользователя
     */
    public Integer getId() {
        return id;
    }

    /**
     * Сеттер поля id
     * @param id - задаём id пользователя
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Геттер поля getEmail
     * @return - возвращает адрес электронной почты пользователя
     */
    public String getEmail() {
        return email;
    }
    /**
     * Сеттер поля setEmail
     * @param email - задаём адрес электронной почты пользователя
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Геттер поля getFirst_name
     * @return - возвращает имя пользователя
     */
    public String getFirst_name() {
        return first_name;
    }
    /**
     * Сеттер поля setFirst_name
     * @param first_name - задаём имя пользователя
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    /**
     * Геттер поля getLast_name
     * @return - возвращает фамилию пользователя
     */
    public String getLast_name() {
        return last_name;
    }
    /**
     * Сеттер поля setLast_name
     * @param last_name - задаём фамилию пользователя
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    /**
     * Геттер поля getAvatar
     * @return - возвращает аватар пользователя
     */
    public String getAvatar() {
        return avatar;
    }
    /**
     * Сеттер поля setAvatar
     * @param avatar - задаём аватар пользователя
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
