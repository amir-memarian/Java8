package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImmutableFunctionShould {
    @Test
    void never_be_changed_after_being_constructed() {
        final int var = 5;  // dorost shod
//        var++;            // tageer megdar
        Operation operation = number -> number + var;
        AddOperationTo addOperationTo = addOperationTo(2, operation);

        int applay = addOperationTo.applay();
        Assertions.assertThat(applay).isEqualTo(7);
    }
    private  AddOperationTo addOperationTo(int number,Operation operation){
        return () -> operation.applyOperation(number);
    }

}
