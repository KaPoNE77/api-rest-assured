package data;

import java.util.List;
/**
 * @author Сергей Канаев
 * Класс ResourseOfColor содержит в себе данные для ресурсов: информация о странице, количество элементов на странице,
 * общее количество элементов, общее количество страниц, список цветов, информацию о поддержке.
 */
public class ResourceOfColor {
    /**
     * Номер страницы
     */
    private Integer page;
    /**
     * Количество элементов на странице
     */
    private Integer per_page;
    /**
     * Общее количество элементов
     */
    private Integer total;
    /**
     * Общее количество страниц
     */
    private Integer total_pages;
    /**
     * Список цветов
     */
    private List<DataColor> data;
    /**
     * Информация о поддержке
     */
    private Support support;

    /**
     * Конструктор для создания объекта с параметрами
     * @param page - номер текущей страницы
     * @param per_page - количество элементов на странице
     * @param total - общее количество элементов
     * @param total_pages - общее количество страниц
     * @param data - список цветов
     * @param support - информация о поддержке
     */
    public ResourceOfColor(Integer page, Integer per_page, Integer total, Integer total_pages, List<DataColor> data, Support support) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
    }
    /**
     * Конструктор без параметров
     */
    public ResourceOfColor() {
        super();
    }
    /**
     * Геттер поля page
     * @return - возвращает номер текущей страницы
     */
    public Integer getPage() {
        return page;
    }
    /**
     * Сеттер поля page
     * @param - заадём номер текущей страницы
     */
    public void setPage(Integer page) {
        this.page = page;
    }
    /**
     * Геттер поля per_page
     * @return - возвращает количество элементов на текущей страницы
     */
    public Integer getPer_page() {
        return per_page;
    }
    /**
     * Сеттер поля per_page
     * @param - задаём количество элементов на текущей страницы
     */
    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }
    /**
     * Геттер поля total
     * @return - возвращает общее количество элементов
     */
    public Integer getTotal() {
        return total;
    }
    /**
     * Сеттер поля total
     * @param - задаём общее количество элементов
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
    /**
     * Геттер поля total_pages
     * @return - возвращает общее количество страниц
     */
    public Integer getTotal_pages() {
        return total_pages;
    }
    /**
     * Сеттер поля total_pages
     * @param total_pages - задаём общее количество страниц
     */
    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }
    /**
     * Геттер поля data
     * @return - возвращает список цветов
     */
    public List<DataColor> getData() {
        return data;
    }
    /**
     * Сеттер поля dataColor
     * @param data - задаём список цветов
     */
    public void setData(List<DataColor> data) {
        this.data = data;
    }
    /**
     * Геттер support
     * @return - возвращаем информацию о поддержке
     */
    public Support getSupport() {
        return support;
    }
    /**
     * Сеттер support
     * @param support - задаём информацию о поддержке
     */
    public void setSupport(Support support) {
        this.support = support;
    }
}
