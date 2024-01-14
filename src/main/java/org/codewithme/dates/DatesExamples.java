package org.codewithme.dates;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DatesExamples {
    public static void main(String[] args) {
        // Sample usage of methods
        LocalDate today = getCurrentDate();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = today.minusDays(1);
        LocalDate specificDate = LocalDate.of(2024, Month.JANUARY, 13); // Specific date
        LocalTime specificTime = LocalTime.of(14, 30, 15); // Specific time (14:30:15)
        LocalDateTime specificDateTime = LocalDateTime.of(specificDate, specificTime); // Specific date and time
        LocalTime now = getCurrentTime();
        LocalDateTime currentDateTime = getCurrentDateTime();
        ZonedDateTime currentZonedDateTime = getCurrentZonedDateTime();
        LocalDateTime combineLocalDateAndLocalTime = combineLocalDateAndLocalTime(specificDate, specificTime);
        ZonedDateTime zonedSpecific = combineLocalDateAndLocalTime(specificDate, specificTime).atZone(ZoneId.of("Europe/Paris")); // Specific time-zone

        System.out.println("Current Date: " + today);
        System.out.println("Tomorrow Date: " + tomorrow);
        System.out.println("Yesterday Date: " + yesterday);
        System.out.println("Current Time: " + now);
        System.out.println("One Hour Later: " + now.plusHours(1));
        System.out.println("Current DateTime: " + currentDateTime);
        System.out.println("Specific Date Time: " + specificDateTime);
        System.out.println("Current ZonedDateTime: " + currentZonedDateTime);
        System.out.println("combine LocalDate and LocalTime : " + combineLocalDateAndLocalTime);
        System.out.println("Zoned Specific : " + zonedSpecific);
        System.out.println("Instant Now : " + Instant.now());
        System.out.println("Formatted Current Date: " + formatDate(today));
        System.out.println("Next Tuesday: " + getNextDayOfWeek(today, DayOfWeek.TUESDAY));
        System.out.println("Duration between two times: " + calculateDuration(now, LocalTime.of(23, 59)));
        System.out.println("Period between two dates: " + calculatePeriod(today, LocalDate.of(2025, 1, 1)));
        System.out.println("Adjust date to first day of next month: " + adjustToFirstDayOfNextMonth(today));
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public static ZonedDateTime getCurrentZonedDateTime() {
        return ZonedDateTime.now();
    }

    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public static LocalDate getNextDayOfWeek(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.next(dayOfWeek));
    }

    public static Duration calculateDuration(LocalTime startTime, LocalTime endTime) {
        return Duration.between(startTime, endTime);
    }

    public static Period calculatePeriod(LocalDate startDate, LocalDate endDate) {
        return Period.between(startDate, endDate);
    }

    public static LocalDate adjustToFirstDayOfNextMonth(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfNextMonth());
    }

    private static LocalDateTime combineLocalDateAndLocalTime(LocalDate specificDate, LocalTime specificTime) {
        return LocalDateTime.of(specificDate, specificTime);
    }

}
