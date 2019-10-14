package kenshoo.mvp.domain.games;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HandballStatsItem implements GameStatsItem {
    @Getter
    private final String name;
    private final String nickName;
    private final long number;
    @Getter
    private final String team;
    private final int goalMade;
    private final int goalReceived;

    @Override
    public int calcRatingPoints() {
        return 2 * goalMade - goalReceived;
    }
}
