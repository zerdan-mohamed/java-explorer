package org.codewithme.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateFormattingExamples {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        String dateTimePattern = "yyyy-MM-dd HH:mm:ss Z";
        String dateTimePattern2 = "EEEE, dd MMMM, yyyy";

        String dateOnly = "2024-01-13";
        String dateWithTime = "2024-01-13 15:30:45";
        LocalDate parsedDateOnly = parseWithOptionalElements(dateOnly);
        LocalDate parsedDateWithTime = parseWithOptionalElements(dateWithTime);
        String formattedDateUS = formatWithLocale(date, Locale.US, dateTimePattern2);
        String formattedDateFrance = formatWithLocale(date, Locale.FRANCE, dateTimePattern2);

        System.out.println("Formatted Date (Default) : " + formatDateDefault(date));
        System.out.println("Formatted DateTime (ISO) : " + formatDateTimeISO(dateTime));
        System.out.println("Formatted Date (Custom) : " + formatDateCustom(date, "dd/MM/yyyy"));
        System.out.println("Formatted Date (Localized) : " + formatDateLocalized(date, Locale.FRANCE, FormatStyle.FULL));
        System.out.println("Parse Date (Custom Format) : " + parseDate("31/12/2024", "dd/MM/yyyy"));

        System.out.println("Formatted Date (Offset) : " + formatWithOffset(dateTime, dateTimePattern));
        System.out.println("Formatted Date (Zone) : " + formatWithZone(dateTime, dateTimePattern));
        System.out.println("Formatted with Custom Pattern : " + formatCustomPattern(date));

        System.out.println("Parsed Date Only: " + parsedDateOnly);
        System.out.println("Parsed Date With Time: " + parsedDateWithTime);

        System.out.println("Formatted Date (US): " + formattedDateUS);
        System.out.println("Formatted Date (France): " + formattedDateFrance);
    }

    public static String formatDateDefault(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String formatDateTimeISO(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public static String formatDateCustom(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    public static String formatDateLocalized(LocalDate date, Locale locale, FormatStyle style) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(style).withLocale(locale);
        return date.format(formatter);
    }

    public static LocalDate parseDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateString, formatter);
    }

    public static String formatWithOffset(LocalDateTime dateTime, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        return dateTime.atZone(ZoneId.systemDefault()).format(formatter);
    }

    public static String formatWithZone(LocalDateTime dateTime, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        return dateTime.atZone(ZoneId.of("UTC")).format(formatter);
    }

    public static String formatCustomPattern(LocalDate date) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_WEEK)
                .appendLiteral(", ")
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(" ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendValue(ChronoField.YEAR)
                .toFormatter();
        return date.format(formatter);
    }

    public static LocalDate parseWithOptionalElements(String dateString) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd")
                .optionalStart()
                .appendPattern(" HH:mm:ss")
                .optionalEnd()
                .toFormatter();
        return LocalDate.parse(dateString, formatter);
    }

    public static String formatWithLocale(LocalDate date, Locale locale, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern, locale);
        return date.format(formatter);
    }

}
