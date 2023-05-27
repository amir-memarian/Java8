package helper;

import football.player.Player;
import football.player.PlayersWithCups;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class PlayerTestHelper {
    public List<Player> getPlayers() {
        final List<Player> scorers = new LinkedList<>();
        scorers.add(new Player("Ali Daei",109));
        scorers.add(new Player("Ali Daei",109));
        scorers.add(new Player("Cristiano Ronaldo",122));
        scorers.add(new Player("Lionel Messi",102));
        scorers.add(new Player("Mokhtar Dahari",89));
        return scorers;
    }

    public List<PlayersWithCups> getPlayersWithCups() {
        final List<PlayersWithCups> scorers = new LinkedList<>();
        scorers.add(new PlayersWithCups("Ali Daei",109, asList("Bundis Liga","Azadegan")));
        scorers.add(new PlayersWithCups("Cristiano Ronaldo",122,asList("Laliga","European Cup")));
        scorers.add(new PlayersWithCups("Lionel Messi",102,asList("Laliga","European Cup")));
        scorers.add(new PlayersWithCups("Mokhtar Dahari",89, emptyList()));
        return scorers;
    }
}
