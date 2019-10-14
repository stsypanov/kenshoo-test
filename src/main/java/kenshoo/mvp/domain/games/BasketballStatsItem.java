package kenshoo.mvp.domain.games;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
public class BasketballStatsItem implements GameStatsItem {
    @Getter
    private final String name;
    private final String nickName;
    private final long number;
    @Getter
    private final String team;
    private final int scoredPoints;
    private final int rebounds;
    private final int assists;

    @Override
    public int calcRatingPoints() {
        return scoredPoints * 2 + rebounds + assists;
    }
}
