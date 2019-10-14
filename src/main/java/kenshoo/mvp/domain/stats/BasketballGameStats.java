package kenshoo.mvp.domain.stats;

import kenshoo.mvp.domain.games.BasketballStatsItem;
import kenshoo.mvp.domain.games.GameStatsItem;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BasketballGameStats implements GameStats {
    @NonNull
    private final List<BasketballStatsItem> statsItem;

    private String bestPlayer;
    private String winnerTeam;

    @Override
    public String getBestPlayer() {
        String bestPlayer = this.bestPlayer;
        if (bestPlayer == null) {
            bestPlayer = findBestPlayer();
        }
        this.bestPlayer = bestPlayer;
        return bestPlayer;
    }

    public String getWinnerTeam() {
        String winnerTeam = this.winnerTeam;
        if (winnerTeam == null) {
            winnerTeam = findWinnerTeam();
        }
        this.winnerTeam = winnerTeam;
        return winnerTeam;
    }

    @Override
    public List<? extends GameStatsItem> getStatsItems() {
        return statsItem;
    }
}
