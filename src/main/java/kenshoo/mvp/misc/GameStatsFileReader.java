package kenshoo.mvp.misc;

import kenshoo.mvp.domain.stats.GameStats;
import kenshoo.mvp.domain.Game;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface GameStatsFileReader {

    Map<Game, GameStats> readFiles(List<File> files);

}
