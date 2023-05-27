package funcTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HOFunctionTest {
    @Test
    void name() {
        Operation operation = number -> number + 5;
        /*
        Operation operation = new Operation() {
            @Override
            public int applayOperation(int number) {
                return number + 5;
            }
        };*/
        int result = getAnInt(2,operation).applay();
        // --or--
        //2//////////////int result = ((AddOperationTo)() -> operation.applayOperation(2)).applay();
        // --or--
        //3//////////////AddOperationTo addOperationTo = getAnInt(2,operation);
        ////////////////int result = addOperationTo.applay();
        // --or--
        //4//////////////AddOperationTo addOperationTo = () -> getAnInt(2,operation).applay();
        /*
        AddOperationTo addOperationTo = new AddOperationTo() {
            @Override
            public int applay() {
                return getAnInt(2,operation).applay();
            }
        };*/
        Assertions.assertThat(result).isEqualTo(7);
    }
    private AddOperationTo getAnInt(int number, Operation operation) {
        return () -> operation.applayOperation(number);
    }

}
