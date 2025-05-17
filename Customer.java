package app;

public class Customer { // покупатель
    private int data; // какие-либо данные (паспорт, email)

    public Customer(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void buy(Product product, Point point) {
        Point.setMoney(Point.getMoney() + product.getPrice());
        product.setStatus("товар" + product.getAddress() + "продан");
        point.setCount_point_products(point.getCount_point_products()-1);
    }

    public void back(Product product, Point point) {
        Point.setMoney(Point.getMoney() - product.getPrice());;
        product.setStatus("товар" + product.getAddress() + "в наличии");
        point.setCount_point_products(point.getCount_point_products()+1);
    }
}
