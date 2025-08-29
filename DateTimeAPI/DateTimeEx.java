package DateTimeAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeEx {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        System.out.println("current date "+ date);

        LocalTime time =LocalTime.now();
        System.out.println("cureent time "+time);

        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : "+ current);

        LocalDate nextWeek = date.plusWeeks(1);
        System.out.println("Date a week from now: " + nextWeek);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Today's date (formatted): " + date.format(formatter));

        LocalDate independenceDay = LocalDate.of(1947, Month.AUGUST, 15);
        System.out.println("India's Independence Day: " + independenceDay);

       // Calculate the period between two dates
        Period ageOfIndia = Period.between(independenceDay, date);
        System.out.printf("Years since independence: %d years, %d months, %d days%n",
                ageOfIndia.getYears(), ageOfIndia.getMonths(), ageOfIndia.getDays());

    }
}
