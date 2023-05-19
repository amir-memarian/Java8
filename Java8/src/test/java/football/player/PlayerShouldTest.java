package football.player;

import helper.PlayerTestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerShouldTest {
    @Test
    void give_the_best_scorer_with_OOP() { // behtarin goolzn ra be ma tahvil bede
        final List<Player> scorers = new PlayerTestHelper().getPlayers();

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
        final List<Player> scorers = new PlayerTestHelper().getPlayers();

        final Player bestPlayer = scorers.stream()
                .max(Comparator.comparing(player -> player.getGoal()))
                .get();

        assertThat(bestPlayer.getName()).isEqualTo("Cristiano Ronaldo");
    }

}