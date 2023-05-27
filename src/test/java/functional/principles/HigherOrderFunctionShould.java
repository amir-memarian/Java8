package functional.principles;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HigherOrderFunctionShould {
    @Test
    void take_one_or_many_other_function_as_parameter_and_return_a_function() {
        // function : adad , operation (function)
        // function ( 2 , +5) : 7
        Operation oper = n -> n + 5;
        AddOperationTo addOperTo = () -> oper.applyOperation(2);
               // addOperationTo(7,oper);
        int app = addOperTo.applay();
        Assertions.assertThat(app).isEqualTo(7);



        Operation operation = number -> number + 5;
        AddOperationTo addOperationTo = addOperationTo(2, operation);

        int applay = addOperationTo.applay();
        Assertions.assertThat(applay).isEqualTo(7);

        Operation tavan = number -> number * number;
        final AddOperationTo beTavanBeresan = addOperationTo(5, tavan);
        final int applayBeTavan2 = beTavanBeresan.applay();

        Assertions.assertThat(applayBeTavan2).isEqualTo(25);
    }
    private  AddOperationTo addOperationTo(int number,Operation operation){
        return () -> operation.applyOperation(number);
    }


}
