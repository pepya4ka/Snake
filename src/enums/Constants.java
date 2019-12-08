package enums;

public enum Constants {

    SIZE("Size", 320),
    OBJECT_SIZE("Object_size", 16),
    ALL_AMOUNT_OBJECT("All_amount_object", 400);

    private String title;
    private int number;

    Constants(String title, int number) {
        this.title = title;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

}
