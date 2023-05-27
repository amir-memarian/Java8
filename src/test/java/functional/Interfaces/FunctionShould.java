package functional.Interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionShould {
    @Test
    void get_an_entry_and_produce_an_output() {
        Map<String,Integer> map = new HashMap<>();

        Function<? super String, Integer> function = String::length;
        Integer result = map.computeIfAbsent("Amir", function);

        assertThat(result).isEqualTo(4);

    }
}
