package functional.Interfaces;

import football.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class SupplierShould {
    @Test
    void have_any_entry_and_return_a_type() {
        Supplier<Player> hossian = () -> new Player("Hossain",95);
        Assertions.assertThat(hossian.get().getName()).isEqualTo("Hossain");
        Assertions.assertThat(hossian.get().getGoal()).isEqualTo(95);

        int var = -5;
        
        Supplier<Integer> abs = () -> Math.abs(var);
        Integer asInt = abs.get();

        Assertions.assertThat(asInt).isEqualTo(5);

        //  IntSupplier intSupplier;
        //  LongSupplier longSupplier;
        //  DoubleSupplier doubleSupplier;

    }
}
