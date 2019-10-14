package kenshoo.mvp.misc.parser;

import kenshoo.mvp.domain.stats.GameStats;

import java.util.List;

public interface GameStatsParser<T extends GameStats> {

    T parseGameStats(List<String[]> fileLines);

}
