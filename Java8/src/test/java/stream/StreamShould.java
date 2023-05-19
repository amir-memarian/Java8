package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;


public class StreamShould {
    @Test
    void be_created() {
        String hello = "Hello";
        Stream<String> helloStream = Stream.of(hello);

        // no Assert

        Stream<Player> playerStream = new PlayerTestHelper().getPlayers().stream();
        Integer[] numbers = new Integer[5];
        Stream<Integer> numbersStream = Arrays.stream(numbers);

        // no Assert
    }

}
