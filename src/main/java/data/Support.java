package data;

/**
 * @author Сергей Канаев
 * Класс Support содержит в себе поля url и текстовое поле
 */
public class Support {

    /**
     * String url - содержит адрес url
     */
    private String url;

    /**
     * String text - содержит текстовое описание
     */
    private String text;

    /**
     * Конструктор без параметров
     */
    public Support(){
        super();
    }

    /**
     * Конструктор с параметрами
     * @param url - адрес url
     * @param text - текстовое описание
     */
    public Support(String url, String text) {
        this.url = url;
        this.text = text;
    }

    /**
     * Геттер url
     * @return - возвращает адрес сайта
     */
    public String getUrl() {
        return url;
    }

    /**
     * Сеттер url
     * @param url - адрес url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Геттер поля text
     * @return - возвращает текстовое описание
     */
    public String getText() {
        return text;
    }

    /**
     * Сеттер text
     * @param text - задаём текстовое описание
     */
    public void setText(String text) {
        this.text = text;
    }
}
