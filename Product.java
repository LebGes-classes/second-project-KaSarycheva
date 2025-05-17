package app;

public class Product extends GeneralInformation{ // товар
    private int price;

    public Product(String article, int price) {
        super(article);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
