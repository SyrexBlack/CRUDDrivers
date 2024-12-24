package web.model;

public class AssignedPair {
    private final String driverName;
    private final String carModel;

    public AssignedPair(String driverName, String carModel) {
        this.driverName = driverName;
        this.carModel = carModel;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getCarModel() {
        return carModel;
    }
}
