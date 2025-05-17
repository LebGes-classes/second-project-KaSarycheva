package app;

abstract class GeneralInformation {
    private String identifier; // идентификатор: адрес (для склада, точки продажи), номер для ячейки, артикул для товара
    private String status;
    private static int service; // траты на обслуживание всех складов/точек (уборка помещения, свет, вода и тп)

    public GeneralInformation(String identifier) {
        this.identifier = identifier;
        this.status = "доступно";
    }

    public String getAddress() {
        return identifier;
    }
    public void setAddress(String identifier) {
        this.identifier = identifier;
    }


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public static int getService() {
        return service;
    }

    public static void setService(int service) {
        GeneralInformation.service = service;
    }
}
