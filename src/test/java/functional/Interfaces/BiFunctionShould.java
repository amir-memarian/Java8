package functional.Interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionShould {
    @Test
    void takes_two_type_as_entry_and_return_one_type() {
        Map<String,Integer> players = new HashMap<>();
        players.put("Ali",98);
        players.put("Amir",51);

        BiFunction<? super String, ? super Integer, Integer> biFunction =
                (key,value) -> key.contains("m") ? value + 1: value - 1;
        Integer ali = players.compute("Ali", biFunction);
        Integer amir = players.compute("Amir", biFunction);

        assertThat(ali).isEqualTo(97);
        assertThat(amir).isEqualTo(52);

    }
}
