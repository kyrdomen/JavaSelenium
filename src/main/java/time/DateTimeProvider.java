package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeProvider {

    /**
     * Returns a DateTimeFormatter instance for a specified date format pattern and locale.
     *
     * @param format a string representing the desired format pattern for the DateTimeFormatter.
     * @return a DateTimeFormatter instance with the specified format pattern and locale.
     */
    public static DateTimeFormatter getFormatter(String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
        return formatter;
    }

    /**
     * Returns the current date formatted as a string using the specified date format pattern.
     *
     * @param formatType a string representing the desired date format pattern to use.
     * @return a string representing the current date formatted according to the specified format pattern.
     */
    public static String getCurrentDate(String formatType){
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(getFormatter(formatType));
        return formattedDate;
    }

    /**
     * This method returns a string representation of a date that is the result of adding a given number of days to the current date.
     * @param numDays an integer representing the number of days to add to the current date
     * @param formatType a string representing the format of the resulting date. It should follow the pattern specified by DateTimeFormatter.
     * @return a string representation of the resulting date in the specified format
     */
    public static String getDatePlusToday(int numDays, String formatType) {
        LocalDate currentDate = LocalDate.now();
        LocalDate newDate = currentDate.plusDays(numDays);
        String formattedDate = newDate.format(getFormatter(formatType));
        return formattedDate;
    }
}
