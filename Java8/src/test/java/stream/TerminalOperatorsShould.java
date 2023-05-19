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
}
