package app;

public class Point extends GeneralInformation implements GeneralBehavior { // точка продаж
    private static int money; // доходы всех точек
    private static int count_points;
    private int count_point_products; // кол-во всех товаров в пункте продаж

    public Point(String address) {
        super(address);
    }

    public int getCount_points() {
        return count_points;
    }

    public static int getMoney() {
        return money;
    }

    public int getCount_point_products() {
        return count_point_products;
    }

    public void setCount_points(int count_points) {
        Point.count_points = count_points;
    }

    public static void setMoney(int money) {
        Point.money = money;
    }

    public void setCount_point_products(int count_point_products) {
        this.count_point_products = count_point_products;
    }

    public void openNewPoint() {
        count_points += 1;
    }

    public void closePoint() {
        Point.count_points -= 1;
        this.setStatus("недоступно");
    }

    public void wholesale(Manufacturer manufacturer, int count) { // закупка товаров
        if (count <= manufacturer.getCount_products()) {
            this.count_point_products += count;
            manufacturer.setCount_products(manufacturer.getCount_products()-count);
        } else {
            System.out.println("Недостаточно продуктов для закупки!");
        }
    }

    @Override
    public boolean isAvailable() {
        return this.getStatus().equals("доступно");
    }

    public void showInfo() {
        System.out.println("кол-во доступных пунктов продаж = " + Point.count_points);
        System.out.println("со всех точек продаж товаров продано на сумму: " + Point.money);
        System.out.println("пункт продаж находится по адресу: " + this.getAddress());
        System.out.println(this.getStatus());
        if (this.getStatus().equals("доступно")) {
            System.out.println("Всего товаров в пункте продаж = " + this.getCount_point_products());
        }
    }
}
