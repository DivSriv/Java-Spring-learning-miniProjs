package org.example;

//public class EnumClass {
//}
enum Weekday {
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "Sunday");

    private final int number;
    private final String value;

    Weekday(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }
}

class EnumClass {
    public static void main(String[] args) {

        for (Weekday weekday : Weekday.values()) {
            System.out.println(weekday + " " + weekday.getValue() + " " + weekday.getNumber());
            // System.out.println(weekday);

        }


        System.out.println(findByName("Sunday"));
        System.out.println(findByNumber(1)); // Day

    }

    public static Weekday findByName(String name) {
        for (Weekday day : Weekday.values()) {
            if (day.name().equalsIgnoreCase(name)) {
                return day;
            }
        }
        return null;
    }

    public static Weekday findByNumber(int number) {
        for (Weekday day : Weekday.values()) {
            if (day.getNumber() == number) {
                return day;
            }
        }
        return null;
    }
}