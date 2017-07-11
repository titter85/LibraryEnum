package pl.sda.library.enums;

public class OldCar {
    public final static int VAN = 1950;
    public final static int WAGON = 1500;
    public final static int SEDAN = 1300;
    public final static int BATCHBACK = 1100;
    public final static int SPORTS = 1150;

    private int carType;

    public OldCar(int type) {
        carType = type;
    }

    public void setType(int type) {
        carType = type;
    }

    public int getType(){
        return this.carType;
    }

}
