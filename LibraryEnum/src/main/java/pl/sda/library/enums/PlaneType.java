package pl.sda.library.enums;

import java.util.HashMap;
import java.util.Map;

public enum PlaneType {
    B737(10000) {
        String builtBy() {
            return "Boeing";
        }
    },
    A320(11000) {
        String builtBy() {
            return "Airbus";
        }
    };

    private final int maxAltitude;

    public float maxAltitude() {
        return maxAltitude;
    }

    PlaneType(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }


    abstract String builtBy();

    public String naiveBuiltBy() {
        switch (this) {
            case B737:
                return "Boeing";
            case A320:
                return "Airbus";
        }
        throw new IllegalArgumentException("Just unhandled");
    }

    private static final Map<String, PlaneType> stringToEnum = new HashMap<String, PlaneType>();

    static {
        for (PlaneType planeType : values())
            stringToEnum.put(planeType.toString(), planeType);
    }

    public static PlaneType fromString(String symbol) {
        return stringToEnum.get(symbol);
    }
}
