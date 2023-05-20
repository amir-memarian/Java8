package functional.Interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.management.snmp.jvminstr.JvmRTInputArgsTableMetaImpl;

import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class UnaryOperatorShould {
    @Test
    void has_the_same_type_as_entry_and_output() {
        int var = 5;
        UnaryOperator<Integer> tavan = integer -> integer * integer;
        Integer result = tavan.apply(var);

        assertThat(result).isEqualTo(25);
    }
}
