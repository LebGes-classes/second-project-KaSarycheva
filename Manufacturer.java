package app;

public class Manufacturer { // производитель товаров
    private int count_products; // общее кол-во товаров, доступных для закупки

    public int getCount_products() {
        return count_products;
    }

    public void setCount_products(int count_products) {
        this.count_products = count_products;
    }
}
