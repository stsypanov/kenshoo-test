package kenshoo.mvp.misc;

import kenshoo.mvp.domain.stats.GameStats;
import kenshoo.mvp.domain.Game;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

public class CsvGameStatsFileReaderTest {

    @Test
    public void readFiles() throws URISyntaxException {
        File file1 = Paths.get(getClass().getClassLoader().getResource("file1.csv").toURI()).toFile();
        File file2 = Paths.get(getClass().getClassLoader().getResource("file2.csv").toURI()).toFile();

        CsvGameStatsFileReader csvFileReader = new CsvGameStatsFileReader();
        Map<Game, GameStats> map = csvFileReader.readFiles(Arrays.asList(file1, file2));

        assertThat(map.size(), is(2));

        GameStats basketballStats = map.get(Game.BASKETBALL);
        assertNotNull(basketballStats);
        basketballStats.getBestPlayer();

        assertNotNull(map.get(Game.HANDBALL));
    }
}