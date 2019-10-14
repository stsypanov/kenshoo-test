package kenshoo.mvp.misc.parser;

import kenshoo.mvp.domain.stats.BasketballGameStats;
import kenshoo.mvp.domain.games.BasketballStatsItem;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class BasketballStatsParser implements GameStatsParser<BasketballGameStats> {

    @Override
    public BasketballGameStats parseGameStats(List<String[]> lines) {
        Objects.requireNonNull(lines);
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("No lines for parsing, probably it's a developer's mistake");
        }
        List<BasketballStatsItem> basketballStatsItems = lines.stream().map(this::toBasketBallStats).collect(Collectors.toList());
        return new BasketballGameStats(basketballStatsItems);
    }

    private BasketballStatsItem toBasketBallStats(String[] strings) {
        return new BasketballStatsItem(
                strings[0],
                strings[1],
                Long.parseLong(strings[2]),
                strings[3],
                Integer.parseInt(strings[4]),
                Integer.parseInt(strings[5]),
                Integer.parseInt(strings[6])
        );
    }
}
