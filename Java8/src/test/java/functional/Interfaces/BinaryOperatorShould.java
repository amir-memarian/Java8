package functional.Interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryOperatorShould {
    @Test
    void have_two_entry_and_onr_output_with_the_same_type() {
        int var1 = 10;
        int var2 = 3;

        BinaryOperator<Integer> muliply = (int1,int2) -> int1 * int2;
        Integer result = muliply.apply(var1, var2);

        assertThat(result).isEqualTo(30);
    }
}
