package christmas.domain;

import christmas.error.ErrorCode;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calender {

    private final int DEFAULT_YEAR = 2023;
    private final int DEFAULT_MONTH = 12;
    private final int MAX_DATE = 31;
    private final int MIN_DATE = 1;

    private LocalDate date;

    public Calender(String inputDate) {
        this.date = getParseDate(inputDate);
    }

    private LocalDate getParseDate(String inputDate) {
        int date = parseInt(inputDate);
        if(date > MAX_DATE || date < MIN_DATE) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DATE_FORMAT.getMessage());
        }
        return LocalDate.of(DEFAULT_YEAR, DEFAULT_MONTH, date);
    }

    private static int parseInt(String value){
        try{
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorCode.INVALID_DATE_FORMAT.getMessage());
        }
    }

    public DayOfWeek getDayOfWeek() {
        return date.getDayOfWeek();
    }
}
