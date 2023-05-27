package functional.Interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;

public class BiFunctionPrimitiveShould {
    @Test
    void return_a_primitive_type() {
        //ToIntBiFunction
        //ToLongBiFunction
        //ToDoubleBiFunction

        ToDoubleBiFunction<Integer,Integer> toDoubleBiFunction =
                (integer1, integer2) -> integer1 + integer2;
        double result = toDoubleBiFunction.applyAsDouble(10, 5);

        Assertions.assertThat(result).isEqualTo(15d);

    }
}
