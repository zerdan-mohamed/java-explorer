
## Java 8 Date and Time API Overview

Java 8 introduced a new Date and Time API, providing a more robust and intuitive approach to handling dates and times. This API is found in the `java.time` package and includes several key classes and functionalities.

### Key Classes

- **LocalDate**: Represents a date without time.
- **LocalTime**: Represents time without a date.
- **LocalDateTime**: Combines date and time, but without any offset or time-zone.
- **ZonedDateTime**: A complete date-time with a time-zone.
- **Instant**: Represents a specific moment on the time-line in UTC.

### Key Functionalities

#### Creation
- Create current date/time: `LocalDate.now()`, `LocalTime.now()`, `LocalDateTime.now()`.
- Create specific date/time: `LocalDate.of()`, `LocalTime.of()`, `LocalDateTime.of()`.

#### Parsing and Formatting
- Format dates and times using predefined or custom patterns with `DateTimeFormatter`.
- Parse dates and times from strings.

#### Time Zone Handling
- Handle different time zones with `ZonedDateTime`.
- Convert between time zones.

#### Duration and Period
- Calculate the duration between time points with `Duration`.
- Calculate the period between dates with `Period`.

#### Temporal Adjusters
- Perform complex date calculations using `TemporalAdjusters`.

#### Advanced Formatting
- Use `DateTimeFormatterBuilder` for complex formatting scenarios.
- Format dates and times according to different locales.

### Examples of Usage

- Formatting and parsing dates.
- Calculating durations and periods between dates/times.
- Adjusting dates to the next day, next month, etc.
- Handling time zones and offsets.

The Java 8 Date and Time API is immutable and thread-safe, making it a significant improvement over the old `java.util.Date` and `java.util.Calendar`.