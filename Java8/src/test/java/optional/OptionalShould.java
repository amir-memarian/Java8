package optional;

import football.team.Coach;
import football.team.Degree;
import football.team.Team;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OptionalShould {
    @Test
    void avoid_null_problems() {
        Team team = new Team(new Coach(new Degree("A")));
        // Before java 8
/*
        if (team != null) {
            Coach coach = team.getCoach();
            if (coach != null) {
                Degree degree = coach.getDegree();
                if (degree != null) {
                    String value = degree.getValue();

                    out.println(value);
                }
            }
        }
*/
/*        if (team != null) {
            Optional<Coach> coach = team.getCoach();
            if (coach.isPresent()) {
                Optional<Degree> degree = coach.get().getDegree();
                if (degree.isPresent()) {
                    String value = degree.get().getValue();

                    Assertions.assertThat(value).isEqualTo("A");
                }
            }
        }
*/
        // From Java 8
        team.getCoach()
                .flatMap(Coach::getDegree)
                .map(Degree::getValue)
                .ifPresent(value-> assertThat(value).isEqualTo("A"));
    }

    @Test
    void be_created() {
        String name = "Amir";
        assertThat(Optional.of(name).get()).isEqualTo("Amir");

        name = null;
        String finalName = name;
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(()->Optional.of(finalName));
 //       assertThat(Optional.of(name).get()).isEqualTo(null);

        assertThat(Optional.ofNullable(finalName)).isEmpty();

    }
    @Test
    void have_default_values() {
        String name = "Amir";

        out.println("orElse:");
        String result = Optional.ofNullable(name).orElse(getDefaultName());
        out.println(result);
        assertThat(result).isEqualTo("Amir");

        out.println("orElseGet");
        result = Optional.ofNullable(name).orElseGet(OptionalShould::getDefaultName);
        out.println(result);
        assertThat(result).isEqualTo("Amir");

    }

    @Test
    void handle_errors() {
        String name = null;
        ThrowableAssert.ThrowingCallable result = () -> Optional.ofNullable(name)
                .orElseThrow(()-> new NullPointerException("not name"));

        assertThatExceptionOfType(NullPointerException.class).isThrownBy(result);

    }

    
    private static String getDefaultName() {
        out.println("Default name called");
        return "No name";
    }
}
