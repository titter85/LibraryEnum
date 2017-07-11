package pl.sda.library.enums;

public class NewCar {

    private CarType type;

    public NewCar(CarType type) {
        this.type = type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public CarType getType() {
        return this.type;
    }
}
