package time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Java8DateAndTime {
    public boolean isWeekend(LocalDate aDate) {
        DayOfWeek dayOfWeek = aDate.getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.THURSDAY);
    }
}
