package functional.principles;

import football.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstClassCitizenFunctionShould { //Shahrvand daraje one

    @Test
    void be_passed_as_method_parameter() {
        List<String> players = getPlayers();

        Collections.sort(players, (a, b) -> a.compareTo(b));

        assertPlayersSort(players);
    }

    @Test
    void be_passed_as_value_to_a_variable() {
        List<String> players = getPlayers();

        Comparator<String> stringComparator = (a, b) -> a.compareTo(b);
        Collections.sort(players, stringComparator);

        assertPlayersSort(players);
    }

    @Test
    void be_returned_from_a_method() {
        List<String> players = getPlayers();

        Comparator<String> stringComparator = getStringComparator();
        Collections.sort(players, stringComparator);

        assertPlayersSort(players);

    }

    private static Comparator<String> getStringComparator() {
        return (a, b) -> a.compareTo(b);
    }

    private static void assertPlayersSort(List<String> players) {
        assertThat(players.get(0)).isEqualTo("Abedzadeh");
        assertThat(players.get(1)).isEqualTo("Majidi");
        assertThat(players.get(2)).isEqualTo("Ronaldo");
    }

    private static List<String> getPlayers() {
        List<String> players = new ArrayList<>();
        players.add("Ronaldo");
        players.add("Abedzadeh");
        players.add("Majidi");
        return players;
    }
}
