package app;

public class Cell extends GeneralInformation{ // ячейка склада

    public Cell(String address) {
        super(address);
    }

    public boolean isFree() {
        return this.getStatus().equals("свободно");
    }

}
