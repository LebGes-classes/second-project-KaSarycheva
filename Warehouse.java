package app;

import java.util.HashMap;
import java.util.Map;

public class Warehouse extends GeneralInformation implements GeneralBehavior { // склад
    private int count_cells;
    private int count_empty_cells; // кол-во незанятых ячеек
    private static int count_warehouses; // общее количество складов
    private int count_warehouse_products; // кол-во всех товаров на складе

    private Map<Cell, Product> warehouse = new HashMap<>();

    public Map<Cell, Product> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Map<Cell, Product> warehouse) {
        this.warehouse = warehouse;
    }

    public Product getProduct(Cell cell) { // получаем продукт по ячейке, в которой он хранится
        return warehouse.get(cell);
    }

    public Product putProduct(Cell cell, Product product) { // кладем продукт в ячейку
        count_warehouse_products += 1;
        count_empty_cells -= 1;
        return warehouse.put(cell, product);
    }

    public Product deleteProduct(Cell cell) { // убираем продукт из ячейки
        count_warehouse_products -= 1;
        count_empty_cells += 1;
        return warehouse.remove(cell);
    }

    public Warehouse (String address, int count_cells, int count_empty_cells) {
        super(address);
        this.count_cells= count_cells;
        this.count_empty_cells = count_empty_cells;
    }

    public static int getCount_warehouses() {
        return count_warehouses;
    }

    public int getCount_empty_cells() {
        return count_empty_cells;
    }

    public int getCount_cells() {
        return count_cells;
    }

    public int getCount_warehouse_products() {
        return count_warehouse_products;
    }

    public static void setCount_warehouses(int count_warehouses) {
        Warehouse.count_warehouses = count_warehouses;
    }

    public void setCount_empty_cells(int count_empty_cells) {
        this.count_empty_cells = count_empty_cells;
    }

    public void setCount_cells(int count_cells) {
        this.count_cells = count_cells;
    }

    public void setCount_warehouse_products(int count_warehouse_products) {
        this.count_warehouse_products = count_warehouse_products;
    }

    public void openNewWarehouse() { // открытие нового склада
        count_warehouses += 1;
    }

    public void closeWarehouse() {
        this.setStatus("недоступно");
        count_warehouses -= 1;
    }

    public boolean isAvailable() { // проверяем доступен ли склад (не полностью занят, не закрыт)
        return (this.count_empty_cells > 0 && this.getStatus().equals("доступно"));
    }

    public void showInfo() {
        System.out.println("кол-во доступных складов = " + count_warehouses);
        System.out.println("склад находится по адресу: " + this.getAddress());
        System.out.println(this.getStatus());
        if (this.getStatus().equals("доступно")) {
            System.out.println("общее кол-во ячеек = " + this.count_cells + ", свободных = " + this.count_empty_cells);
            System.out.println("Всего товаров на складе = " + this.count_warehouse_products);
        }
    }
}
