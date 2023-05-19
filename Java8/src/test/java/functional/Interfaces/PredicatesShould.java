package functional.Interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicatesShould {
    @Test
    void take_a_type_as_entry_and_return_a_boolean() {
        int var = 8;

        Predicate<Integer> isOdd = integer -> integer % 2 == 0;
        boolean result = isOdd.test(8);

        assertThat(result).isTrue();

    }
}
