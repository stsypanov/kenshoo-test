package kenshoo.mvp.domain.stats;

import kenshoo.mvp.domain.games.GameStatsItem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public interface GameStats {

    String getBestPlayer();

    default int getBestPlayerScore() {
        String bestPlayer = getBestPlayer();
        for (GameStatsItem basketballStatsItem : getStatsItems()) {
            if (basketballStatsItem.getName().equals(bestPlayer)) {
                return basketballStatsItem.calcRatingPoints();
            }
        }
        throw new NoSuchElementException("Player " + bestPlayer + " not present in stats");
    }

    default String findBestPlayer() {
        Comparator<GameStatsItem> gameStatsItemComparator = (item1, item2) -> {
            final int bonus = 10;
            final int player1Points = item1.calcRatingPoints();
            final int player2Points = item2.calcRatingPoints();

            final String winnerTeam = getWinnerTeam();

            final String player1Team = item1.getTeam();
            final String player2Team = item2.getTeam();

            if (winnerTeam.equals(player1Team) && winnerTeam.equals(player2Team)) {
                return Integer.compare(player1Points, player2Points);
            }

            if (winnerTeam.equals(player1Team)) {
                return Integer.compare(player1Points + bonus, player2Points);
            }

            if (winnerTeam.equals(player2Team)) {
                return Integer.compare(player1Points, player2Points + bonus);
            }

            return Integer.compare(player1Points, player2Points);
        };

        return getStatsItems().stream().max(gameStatsItemComparator).orElseThrow().getName();
    }

    default String findWinnerTeam() {
        Map<String, Integer> map = new HashMap<>();
        for (GameStatsItem item : getStatsItems()) {
            String team = item.getTeam();
            map.merge(team, item.calcRatingPoints(), Integer::sum);
        }

        return map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).orElseThrow().getKey();
    }

    default List<? extends GameStatsItem> getStatsItems() {
        throw new UnsupportedOperationException("Must be implemented");
    }

    default String getWinnerTeam() {
        throw new UnsupportedOperationException("Must be implemented!");
    }

}
