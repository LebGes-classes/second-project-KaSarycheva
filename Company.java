package app;

public class Company implements GeneralBehavior { // компания
    private int money; // денежные возможности компании
    private int earnings; // прибыль компании
    private int service; // траты компании на закупку товаров, логистику, зп работникам, налоги и тд

    public int getMoney() {
        return money;
    }

    public int getEarnings() {
        return earnings;
    }

    public int getService() {
        return service;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int profit() { // доходы со всех точек
        return Point.getMoney();
    }

    public int charge() { // расходы
        return this.service + Point.getService() + Warehouse.getService();
    }

    public int calculateEarnings() { // прибыль
        this.earnings = profit() - charge();
        return earnings;
    }

    public void showInfo() {
        System.out.println("прибыль компании = " + this.earnings);
    }

    @Override
    public boolean isAvailable() {
        return this.earnings > 0;
    }
}
