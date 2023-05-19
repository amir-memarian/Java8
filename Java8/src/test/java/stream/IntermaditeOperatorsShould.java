package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.out;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class IntermaditeOperatorsShould {
    private List<Player> players;
    @BeforeEach
    void setUp() {
        players = new PlayerTestHelper().getPlayers();
    }

    @Test
    void filterData() {
        //Predicate<? super Player> topScorer = player -> player.getGoal() > 100;
        //Predicate<? super Player> nameIsAli = player -> player.getName().contains("Ali");
        Consumer<? super Player> sideEffect = out::println;
        List<Player> topScorerWhereNameContainAli = players.stream()
                .distinct()
                .filter(player -> player.getGoal() > 100)
                .peek(sideEffect)
                .filter(player -> player.getName().contains("Ali"))
                .collect(toList());

        List<Player> aliDaei = new LinkedList<>();
        aliDaei.add(new Player("Ali Daei",109));
        assertThat(topScorerWhereNameContainAli).isEqualTo(aliDaei);
    }

    @Test
    void map_data() {
//        Function<? super Player, ?> function= Player::getName;
        List<?> playerNames = players.stream()
                .map(Player::getName)
                .distinct()
                .collect(toList());

        List<String> exectedresult = new LinkedList<>();
        exectedresult.add("Ali Daei");
        exectedresult.add("Cristiano Ronaldo");
        exectedresult.add("Lionel Messi");
        exectedresult.add("Mokhtar Dahari");
        Assertions.assertThat(playerNames).isEqualTo(exectedresult);

    }

    @Test
    void Sorted_data() {
        List<Integer> sortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .distinct()
                .sorted()
                .limit(3)
                .collect(toList());

        List<Integer> exectedresult = new LinkedList<>();
        exectedresult.add(89);
        exectedresult.add(102);
        exectedresult.add(109);
     // limit   exectedresult.add(122);
        Assertions.assertThat(sortedScoredGoals).isEqualTo(exectedresult);

        List<Integer> revesedSortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .distinct()
                .sorted(reverseOrder())
                .skip(2)
                .limit(1)
                .collect(toList());

        List<Integer> exectedresult_2 = new LinkedList<>();
      //skip  exectedresult_2.add(122);
      //skip  exectedresult_2.add(109);
        exectedresult_2.add(102);
      //limit  exectedresult_2.add(89);
        Assertions.assertThat(revesedSortedScoredGoals).isEqualTo(exectedresult_2);

    }
}
