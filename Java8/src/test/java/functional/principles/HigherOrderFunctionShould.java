package functional.principles;

import com.sun.org.apache.xpath.internal.operations.Operation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class HigherOrderFunctionShould {
    @Test
    void take_one_or_many_other_function_as_parameter_and_return_a_function() {
        // function : adad , operation (function)
        // function ( 2 , +5) : 7
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
    @FunctionalInterface
    interface AddOperationTo {
        int applay();
    }
    // function : SAM (single Abstract Method)
    @FunctionalInterface
    interface Operation{
        int applyOperation(int number); // method Abstract yek doneh bashad.
        default int another(int number){
            return  0;
        }
    }
}
