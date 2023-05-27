package football.player;

import helper.PlayerTestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerShouldTest {
    private List<Player> scorers;
    @BeforeEach
    void setUp() {
        scorers = new PlayerTestHelper().getPlayers();
    }

    @Test
    void give_the_best_scorer_with_OOP() { // behtarin goolzn ra be ma tahvil bede
        Player bestPlayer = scorers.get(0);
        for (Player scorer : scorers) {
            if (scorer.getGoal()>bestPlayer.getGoal()){
                bestPlayer = scorer;
            }
        }

        assertThat(bestPlayer.getName()).isEqualTo("Cristiano Ronaldo");
    }

    @Test
    void give_the_best_scorer_with_FunctionalProgramming() {
        final Player bestPlayer = scorers.stream()

                .max(Comparator.comparing(player -> player.getGoal()))
                .get();

        assertThat(bestPlayer.getName()).isEqualTo("Cristiano Ronaldo");
    }

    @Test
    void give_the_best_scorer_with_FunctionalProgramming_2() {
        final Player bestPlayer = scorers.stream()
                .max(Comparator.comparing(a -> a.getGoal()))
                .get();

        assertThat(bestPlayer.getName()).isEqualTo("Cristiano Ronaldo");
    }

}