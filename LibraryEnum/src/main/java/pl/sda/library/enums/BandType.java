package pl.sda.library.enums;

public enum BandType {
    QUARTET, SOLO, DUET, TRIO, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}