package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Comparator.naturalOrder;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TerminalOperatorsShould {
    private List<Player> players;
    @BeforeEach
    void setUp() {
        players = new PlayerTestHelper().getPlayers();
    }

    @Test
    void collect_data() { //toList, toMap, toSet, toArray, toCollection

        Function<Player, UUID> keys = player -> randomUUID();

        UnaryOperator<Player> values = player -> player;
        Map<UUID,Player> playerWithID = players.stream()
                .collect(toMap(keys,values)); //collectAndReturn
        BiConsumer<UUID, Player> printPlayer = (key,value) -> out.println(" Key is a "+key+" value is "+ value);
        playerWithID.forEach(printPlayer);

        assertThat(playerWithID.values()).hasSameElementsAs(players);
        assertThat(playerWithID.keySet()).hasOnlyElementsOfType(UUID.class);

    }

    @Test
    void calculate_data() {
        Stream<Integer> goals = players.stream().map(Player::getGoal);
        ToIntFunction<? super Integer> intConverter= Integer::valueOf;

        //Integer sum = players.stream().map(Player::getGoal).collect(summingInt(intConverter));
        Integer sum = goals.mapToInt(intConverter).sum();

        assertThat(sum).isEqualTo(531);

        Double average = goals.collect(averagingInt(intConverter));
        //Double average = players.stream().map(Player::getGoal).mapToInt(intConverter).average().getAsDouble();

        assertThat(average).isEqualTo(106.2D);

        //Optional<Integer> maxGoalPlayer = players.stream().map(Player::getGoal).collect(maxBy(Comparator.naturalOrder()));
        Optional<Integer> maxGoalPlayer = goals.max(naturalOrder());

        assertThat(maxGoalPlayer.get()).isEqualTo(122);

        //Long countPlayer = players.stream().map(Player::getGoal).collect(counting());
        Long countPlayer = goals.count();

        assertThat(countPlayer).isEqualTo(5);

        IntSummaryStatistics summary = goals
                .collect(summarizingInt(intConverter));

        assertThat(summary.getSum()).isEqualTo(531);
        assertThat(summary.getAverage()).isEqualTo(106.2D);
        assertThat(summary.getMax()).isEqualTo(122);
        assertThat(summary.getMin()).isEqualTo(89);
        assertThat(summary.getCount()).isEqualTo(5);

    }

    @Test
    void group_data() {
        Function<Player, String> playerName = Player::getName;
        Map<String, Long> groupedPlayer = players.stream()
                .collect(groupingBy(playerName, counting()));
        groupedPlayer.forEach((k,v) -> out.println("Player is "+k+" and has "+ v));

        assertThat(groupedPlayer)
                .containsEntry("Ali Daei",2L)
                .containsEntry("Cristiano Ronaldo",1L)
                .containsEntry("Lionel Messi",1L)
                .containsEntry("Mokhtar Dahari",1L);
    }

    @Test
    void match_data() {
        Predicate<? super Integer> moreThan50Goals = goal -> goal > 50;
        boolean allPlayersScoredMoreThan50 = players.stream()
                .map(Player::getGoal)
                .allMatch(moreThan50Goals);

        assertThat(allPlayersScoredMoreThan50).isTrue();

        boolean anyPlayersScoredMoreThan50 = players.stream()
                .map(Player::getGoal)
                .anyMatch(moreThan50Goals);

        assertThat(anyPlayersScoredMoreThan50).isTrue();

        boolean nonePlayersScoredMoreThan50 = players.stream()
                .map(Player::getGoal)
                .noneMatch(moreThan50Goals);

        assertThat(nonePlayersScoredMoreThan50).isFalse();
    }

    @Test
    void find_data() {
        Optional<Integer> firstScorer = players.stream().map(Player::getGoal).findFirst();

        assertThat(firstScorer.get()).isEqualTo(109);

        Optional<String> firstScorer_2 = players.stream()
                .filter(player -> player.getGoal()<100)
                .map(Player::getName)
                .findFirst();
        assertThat(firstScorer_2.get()).isEqualTo("Mokhtar Dahari");

        Optional<String> anyScorer = players.stream()
                .filter(player -> player.getGoal()<103)
                .map(Player::getName)
                .findFirst();
        assertThat(anyScorer.get()).satisfiesAnyOf(
                players->players.equals("Lionel Messi"),
                players->players.equals("Mokhtar Dahari")
        );
    }

    @Test
    void reduce_data() {
        BinaryOperator<Integer> sumOfGoals= (total,goals) -> total + goals;
        Integer totalGoals = players.stream().map(Player::getGoal).reduce(0, sumOfGoals);

        assertThat(totalGoals).isEqualTo(531);

        String formattedNames = players.stream()
                .map(Player::getName)
                .reduce("", this::format)
                .replaceFirst("\\|","")
                .trim();

        out.println(formattedNames);

        assertThat(formattedNames).
                isEqualTo("Ali DAEI | Ali DAEI | Cristiano RONALDO | Lionel MESSI | Mokhtar DAHARI");

    }

    private String format(String res, String playerName) {
        String seprator = " ";
        String firstName = playerName.split(seprator)[0];
        String lastName = playerName.split(seprator)[1];
        return res + " | " + firstName + seprator + lastName.toUpperCase();
    }
}
