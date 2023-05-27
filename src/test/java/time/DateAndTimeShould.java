package time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

public class DateAndTimeShould {
    // Thread Safe

    @Test
    void get_current_time() {
        // Before java 8 :
        Date date = new Date();
        out.println(date);

        //From java 8
        LocalDateTime localDateTime = LocalDateTime.now();
        out.println(localDateTime);

        LocalDate localDate = LocalDate.now();
        out.println(localDate);

        LocalTime localTime = LocalTime.now();
        out.println(localTime);

        LocalDateTime aFutureDate = LocalDateTime.of(2033, 5, 22, 10, 35);
        assertThat(aFutureDate).isAfter(LocalDateTime.now());

    }

    @Test
    void get_5_hours_later() {
        // before java 8:
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR,-5);
        Date time = calendar.getTime();
        out.println(time);

        //From Java 8
        LocalDateTime fiveHoursLater = LocalDateTime.now().minusHours(5);
        out.println(fiveHoursLater);
    }

    @Test
    void determine_if_a_date_is_a_weekend() {
        //Given
        LocalDate localDate = LocalDate.of(2022,8,5);
        Java8DateAndTime java8DateAndTime = new Java8DateAndTime();

        //When
        boolean isWeekend = java8DateAndTime.isWeekend(localDate);

        //Then
        assertThat(isWeekend).isTrue();
    }

    @Test
    void get_paris_time() {
        ZonedDateTime tehranTime = ZonedDateTime.now();
//        out.println(ZoneId.getAvailableZoneIds());
        ZonedDateTime parisTime = tehranTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        out.println(tehranTime.toLocalDateTime());
        out.println(parisTime.toLocalDateTime());

        OffsetDateTime now = OffsetDateTime.now();
        out.println(now);
        out.println(ZoneOffset.getAvailableZoneIds());
        OffsetDateTime parisOffsetDateTime = now.withOffsetSameInstant(ZoneOffset.of("+02:00"));
        out.println(parisOffsetDateTime);
    }

    @Test
    void change_date_format() {
        LocalDateTime now = LocalDateTime.now();
        out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));
        out.println(now.format(DateTimeFormatter.ISO_WEEK_DATE));
        out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    @Test
    void compare_dates() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowPlus5dayes = now.plusDays(5);
        Assertions.assertThat(now.isBefore(nowPlus5dayes)).isTrue();

        Duration duration = Duration.between(now,nowPlus5dayes);
        Assertions.assertThat(duration).isEqualTo(Duration.ofDays(5));

        Period period = Period.between(now.toLocalDate(), nowPlus5dayes.toLocalDate());
        Assertions.assertThat(period.getDays()).isEqualTo(5);

    }
}
