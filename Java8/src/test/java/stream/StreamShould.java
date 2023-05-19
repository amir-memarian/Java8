package stream;

import football.player.Player;
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

        Stream<Player> playerStream = getPlayers().stream();
        Integer[] numbers = new Integer[5];
        Stream<Integer> numbersStream = Arrays.stream(numbers);

        // no Assert




    }
    private static List<Player> getPlayers() {
        final List<Player> scorers = new LinkedList<>();
        scorers.add(new Player("Ali Daei",109));
        scorers.add(new Player("Cristiano Ronaldo",122));
        scorers.add(new Player("Lionel Messi",102));
        scorers.add(new Player("Mokhtar Dahari",89));
        return scorers;
    }

}
