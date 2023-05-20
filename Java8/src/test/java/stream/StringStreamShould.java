package stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

public class StringStreamShould {
    @Test
    void join_strings() {
        List<String> names = Arrays.asList("Amir","Ali","Reza");

        String joinedName = names.stream().collect(joining());
        String joinedNameWithComma = names.stream().collect(joining(","));
        String joinedNameWithCommaAroundBracket = names.stream().collect(joining(",","[","]"));

        assertThat(joinedName).isEqualTo("AmirAliReza");
        assertThat(joinedNameWithComma).isEqualTo("Amir,Ali,Reza");
        assertThat(joinedNameWithCommaAroundBracket).isEqualTo("[Amir,Ali,Reza]");

    }
}
