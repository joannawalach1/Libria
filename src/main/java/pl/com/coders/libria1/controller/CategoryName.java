package pl.com.coders.libria1.controller;

public enum CategoryName {
    THRILLER(1), SCIENCE_FICTION(2), FANTASY(3), HORROR(4), ROMANS(5), DOCUMENT(6);

    private final long value;

    CategoryName(int value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
