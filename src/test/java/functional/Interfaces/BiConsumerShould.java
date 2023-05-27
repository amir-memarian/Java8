package functional.Interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

public class BiConsumerShould {
    @Test
    void takes_two_entries_and_return_nothings() {
        Map<String,Integer> copyPlayers = new HashMap<>();
        Map<String,Integer> players = new HashMap<>();
        players.put("Amir",102);
        players.put("Ali",50);

        BiConsumer<? super String, ? super Integer> biConsumer =
                (key , value) -> out.println("key is "+ key +" value is "+value);
        players.forEach(biConsumer);

        // no Assert

        BiConsumer<? super String, ? super Integer> copyConsumer = copyPlayers::put;
        players.forEach(copyConsumer);

        assertThat(copyPlayers).isEqualTo(players);

        //  ObjIntConsumer objIntConsumer;
        //  ObjLongConsumer objLongConsumer;
        //  ObjDoubleConsumer objDoubleConsumer;

    }
}
