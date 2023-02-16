package Homework_3_Part_1.Task5;

public enum DayOfWeek {
    MONDAY((byte)1, "Monday"),
    TUESDAY((byte)2, "Tuesday"),
    WEDNESDAY((byte)3, "Wednesday"),
    THUSDAY((byte)4, "Thusday"),
    FRIDAY((byte)5, "Friday"),
    SATURDAY((byte)6, "Saturday"),
    SUNDAY((byte)7, "Sunday");
    private final byte dayNumber;
    private final String name;
    DayOfWeek(byte dayNumber, String name) {
        this.dayNumber = dayNumber;
        this.name = name;
    }
    public static DayOfWeek ofNumber(byte dayNumber) {
        for (DayOfWeek ownershipType : values()) {
            if (ownershipType.dayNumber == dayNumber) {
                return ownershipType;
            }
        }
        throw new IllegalArgumentException("Неизвестное значение номера для дня недели: " + dayNumber);
    }
    public byte getDayNumber() {
        return dayNumber;
    }
    public String getName() {
        return name;
    }
}
