package functional.Interfaces;

import com.sun.deploy.net.MessageHeader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import static java.lang.System.arraycopy;
import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerShould {
    @Test
    void takes_entries_and_return_nothing() {
        List<Integer> newNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(65);


        Consumer<? super Integer> consumer = out::println;  //db.save(integer)
        numbers.forEach(consumer);

        //no Assert

        Consumer<? super Integer> copy = newNumbers::add;
        numbers.forEach(copy);

        assertThat(numbers).isEqualTo(newNumbers);

        //  IntConsumer intConsumer;
        //  LongConsumer longConsumer;
        //  DoubleConsumer doubleConsumer;

    }
}
