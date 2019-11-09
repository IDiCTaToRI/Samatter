package gears;

public class DateHelper {
    public static String parseDate(String date) {
        return date.replace('-', '/');
    }
}