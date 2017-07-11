package pl.sda.library.enums;

import java.util.HashMap;
import java.util.Map;

// zadanie1: Wypełnij klasę enum wartościami VAN, WAGON, SEDAN, HATCHBACK, SPORTS
public enum CarType {
    VAN(1950){
        @Override
        public String purpose(){
            return "This is Van";
        }},
    WAGON(1500) {
        @Override
        public String purpose() {
            return "This is Vagon";
        }
    },
    SEDAN(1300) {
        @Override
        public String purpose() {
            return "This is Sedan";
        }
    },
    HATCHBACK(1100) {
        @Override
        public String purpose() {
            return "This is Hatchback";
        }
    },
    SPORTS(1150) {
        @Override
        public String purpose() {
            return "This is SportCar";
        }
    };

    // -----------------------------
    // zadanie2: Dodaj do właściwość weight, która będzie oznaczała wagę samochodu w kilogramach
    private final int weight;

    CarType(int weight) {
        this.weight = weight;
    }
    // -----------------------------
    // zadanie2: Dodaj do metodę o takiej samej nazwie, która zwraca wartość weight


    // -----------------------------
    public String naivePurpose() {
        // zadanie3: Wypełnij metodę tak by zwracała krótki opis pojazdu dla każdej
        // z wartości enuma.
        // Podpowiedź: użyj instrukcji switch(this){}
//        throw new NotImplementedException();
        String carDesc = "";
        switch (this){
            case VAN: carDesc = "This is Van";
                break;
            case WAGON: carDesc = "This is Vagon";
                break;
            case SEDAN: carDesc = "This is Sedan";
                break;
            case HATCHBACK: carDesc = "This is Hatchback";
                break;
//            case SPORTS: carDesc = "This is SportCar";
//                break;
            default: carDesc = "Some car!";
        }

        return carDesc;
    }

    // -----------------------------
    // zadanie 4: Utwórz publiczną zmienną statyczną o nazwie
    // stringToEnum i typie Map<String,CarType>.
    // Użyj klasy HashMap do zainicjalizowania jej

    public static final Map<String, Object> stringToEnum = new HashMap<String, Object>();

    static {
        // zadanie 4: Wypełnij zmienną statyczną wszystkimi wartościami naszego enuma
        // (podpowiedź, metoda values()) uzywjąc w tym celu pętli for
        for(CarType ct: values()){
            stringToEnum.put(ct.name(),ct);
            System.out.println("ENUM: "+ct.name());
        }
//       stringToEnum.put("SEDAN",new Object());
    }

    // -----------------------------
    public static CarType fromString(String symbol) {
        // zadanie 5:
        // Uzupełnij implementację metody tak, by na podstawie podanego Stringa
        // zwracała wartość naszej statycznej zmiennej stringToEnum
//        throw new NotImplementedException();
        return (CarType)stringToEnum.get(symbol.toUpperCase());
    }

    public int weight() {
        return this.weight;
    }

    // zadanie 6: Dodaj metodę abstrakcyjną purpose, zwracającą String
    // i przeciąż ją tak, by zwracała krótki opis pojazdu
    public abstract String purpose();
}
