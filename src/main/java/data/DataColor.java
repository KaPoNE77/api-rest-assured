package data;
/**
 * @author Сергей Канаев
 * Класс DataColor содержит данные о цвете
 */
public class DataColor {
    /**
     * Номер позиции цвета
     */
    private Integer id;
    /**
     * Название цвета
     */
    private String name;
    /**
     * Год цвета
     */
    private Integer year;
    /**
     * Шестнадцатеричный код цвета
     */
    private String color;
    /**
     * Цвет по пантону цветов
     */
    private String pantone_value;
    /**
     * Конструктор класса без праметров
     */
    public DataColor() {
        super();
    }

    /**
     * Конструктор класса с параметрами
     * @param id - Номер позиции цвета
     * @param name - Название цвета
     * @param year - Год цвета
     * @param color - Шестнадцатеричный код цвета
     * @param pantone_value - Цвет по пантону цветов
     */
    public DataColor(Integer id, String name, Integer year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }
    /**
     * Геттер поля id
     * @return - возвращает номер позиции цвета
     */
    public Integer getId() {
        return id;
    }
    /**
     * Сеттер поля id
     * @param id - задаёт номер позиции цвета
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Геттер поля name
     * @return - возвращает название цвета
     */
    public String getName() {
        return name;
    }
    /**
     * Сеттер поля name
     * @param name - задаёт название цвета
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Геттер поля year
     * @return - возвращает год цвета
     */
    public Integer getYear() {
        return year;
    }
    /**
     * Сеттер поля year
     * @param year - задаёт год цвета
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     * Геттер поля color
     * @return - возвращает шестнадцатеричный код цвета
     */
    public String getColor() {
        return color;
    }
    /**
     * Сеттер поля color
     * @param color - задаёт шестнадцатеричный код цвета
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * Геттер поля pantone_value
     * @return - возвращает цвет по пантону цветов
     */
    public String getPantone_value() {
        return pantone_value;
    }
    /**
     * Сеттер поля pantone_value
     * @param pantone_value - задаёт цвет по пантону цветов
     */
    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }
}
