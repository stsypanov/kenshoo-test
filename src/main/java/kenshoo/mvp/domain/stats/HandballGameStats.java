package kenshoo.mvp.domain.stats;

import kenshoo.mvp.domain.games.GameStatsItem;
import kenshoo.mvp.domain.games.HandballStatsItem;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class HandballGameStats implements GameStats {
    @NonNull
    private final List<HandballStatsItem> statsItems;

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
        return statsItems;
    }
}
