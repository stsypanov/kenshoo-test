package kenshoo.mvp.misc.parser;

import kenshoo.mvp.domain.games.HandballStatsItem;
import kenshoo.mvp.domain.stats.HandballGameStats;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class HandballStatsParser implements GameStatsParser<HandballGameStats> {

    @Override
    public HandballGameStats parseGameStats(List<String[]> lines) {
        Objects.requireNonNull(lines);
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("No lines for parsing, probably it's a developer's mistake");
        }
        List<HandballStatsItem> handballStatsItems = lines.stream().map(this::toHandballStats).collect(Collectors.toList());
        return new HandballGameStats(handballStatsItems);
    }

    private HandballStatsItem toHandballStats(String[] strings) {
        return new HandballStatsItem(
                strings[0],
                strings[1],
                Long.parseLong(strings[2]),
                strings[3],
                Integer.parseInt(strings[4]),
                Integer.parseInt(strings[5])
        );
    }
}