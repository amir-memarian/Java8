package functional.Interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class PrimitiveFunctionShould {
    @Test
    void get_a_primitive_type_as_entry() {
        int var = 5;

        IntFunction<String> toString = String::valueOf;
        final String result = toString.apply(var);

        assertThat(result).isEqualTo("5");

        // DoubleFunction<Float> doubleFunction
        // LongFunction<Integer> longFunction
    }

    @Test
    void return_a_primitive_type_given_any_type() {
        String var= "3";

        ToIntFunction<String> toIntFunction = string -> Integer.valueOf(string).intValue();
        final int stringToInt = toIntFunction.applyAsInt(var);

        assertThat(stringToInt).isEqualTo(3);

        // ToDoubleFunction<String> toDoubleFunction
        // ToLongFunction<String> toLongFunction
    }

    @Test
    void give_a_primitive_type_as_input_and_output() {
        int var = 6;

        IntToLongFunction intToLongFunction = integer -> Long.valueOf(integer).longValue();
        long result = intToLongFunction.applyAsLong(var);

        assertThat(result).isEqualTo(6L);

//        IntToDoubleFunction intToDoubleFunction;
//        IntToLongFunction intToLongFunction1;
//        DoubleToIntFunction doubleToIntFunction;
//        DoubleToLongFunction doubleToLongFunction;
//        LongToDoubleFunction longToDoubleFunction;
//        LongToIntFunction longToIntFunction;

    }
}
