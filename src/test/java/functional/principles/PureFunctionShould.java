package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PureFunctionShould {
    @Test
    void depends_only_on_its_parameters() {
        PureMethod pureMethod = new PureMethod();

        int sum_1 = pureMethod.sum(1, 3);

        assertThat(sum_1).isEqualTo(4);

        ImpureMethod impureMethod = new ImpureMethod();

        int sum_2 = impureMethod.sum(1, 3);

        assertThat(sum_2).isEqualTo(9);

    }
    @Test
    void has_no_side_effect() {
        ImpureMethod impureMethod = new ImpureMethod();

        int sum_3 = impureMethod.sum(1, 3);

        assertThat(sum_3).isEqualTo(9);
//------------------------------------------

        int result = impureMethod.nakhales2(2, 3);

        assertThat(result).isEqualTo(5);
//--------------------------------------

/*        int sum_4 = impureMethod.sum(1, 3);

        assertThat(sum_4).isEqualTo(10);
*/
    }
}
