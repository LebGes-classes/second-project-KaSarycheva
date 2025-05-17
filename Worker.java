package app;

public class Worker { // работник
    private static int count_workers;
    private String surname;
    private static String main; // ответственное лицо (фамилия)

    public Worker(String surname) {
        this.surname = surname;
    }

    public static void setCount_workers(int count_workers) {
        Worker.count_workers = count_workers;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static void setMain(String main) {
        Worker.main = main;
    }

    public static int getCount_workers() {
        return count_workers;
    }

    public String getSurname() {
        return surname;
    }

    public static String getMain() {
        return main;
    }

    public void minusWorker() {
        this.surname = null;
        count_workers -= 1;
    }

    public void plusWorker() {
        count_workers += 1;
    }

    public void moveProductTo(Warehouse warehouse, Cell cell, Product product) {
        if (warehouse.isAvailable()) {
            if (cell.isFree()) {
                product.setStatus("товар " + product.getAddress() + " находится на складе " + warehouse.getAddress() + ", в ячейке " + cell.getAddress());
                cell.setStatus("недоступно");

                warehouse.setCount_empty_cells(warehouse.getCount_empty_cells() - 1);
                warehouse.setCount_warehouse_products(warehouse.getCount_warehouse_products() + 1);
                warehouse.putProduct(cell, product);

                System.out.println("Товар успешно доставлен на выбранный вами склад!");
            } else {
                System.out.println("Нам очень жаль, но мы не можем положить товар в эту ячейку, она занята (");
                System.out.println("Пожалуйста, выберите другую ячейку для хранения!");
            }
        } else {
            System.out.println("Нам очень жаль, но мы не можем перевезти товар на этот склад, он недоступен (");
            System.out.println("Пожалуйста, выберите другой склад!");
        }
    }

    public void moveProductTo(Point point, Product product) {
        if (!point.isAvailable()){
            System.out.println("Нам очень жаль, но этот пункт продаж недоступен (");
            System.out.println("Пожалуйста, выберите другой!");
        } else {
            product.setStatus("товар " + product.getAddress() + " находится в пункте продаж " + point.getAddress());
            point.setCount_point_products(point.getCount_point_products() + 1);
            System.out.println("Товар успешно доставлен в выбранный вами пункт продаж!");
        }
    }

    public static void changeMain(String surname) { // смена ответственного лица
        Worker.main = surname;
    }

}
