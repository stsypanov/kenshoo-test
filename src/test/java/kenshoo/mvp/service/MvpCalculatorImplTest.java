package kenshoo.mvp.service;

import kenshoo.mvp.domain.stats.GameStats;
import kenshoo.mvp.misc.CsvGameStatsFileReader;
import kenshoo.mvp.domain.Game;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MvpCalculatorImplTest {

    @Test
    public void findMostValuablePlayer() throws URISyntaxException {
        File file1 = Paths.get(getClass().getClassLoader().getResource("file1.csv").toURI()).toFile();
        File file2 = Paths.get(getClass().getClassLoader().getResource("file2.csv").toURI()).toFile();

        CsvGameStatsFileReader csvFileReader = new CsvGameStatsFileReader();
        Map<Game, GameStats> map = csvFileReader.readFiles(Arrays.asList(file1, file2));

        ArrayList<GameStats> gameStats = new ArrayList<>(map.values());

        String mostValuablePlayer = new MvpCalculatorImpl().findMostValuablePlayer(gameStats);

        assertThat(mostValuablePlayer, is("player 4"));
    }
}