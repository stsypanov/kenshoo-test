package kenshoo.mvp.misc.parser;

import kenshoo.mvp.domain.stats.BasketballGameStats;
import kenshoo.mvp.domain.stats.HandballGameStats;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BasketballStatsParserTest {

    @Test
    public void parseGameStats() {
        String[] array1 = {"player 1", "nick1", "1", "Team A", "10", "0", "0"};
        String[] array2 = {"player 2", "nick2", "2", "Team A", "10", "0", "0"};
        String[] array3 = {"player 3", "nick3", "3", "Team B", "10", "10", "0"};
        String[] array4 = {"player 4", "nick4", "4", "Team B", "10", "10", "10"};

        final List<String[]> lines = Arrays.asList(array1, array2, array3, array4);
        final BasketballGameStats stats = new BasketballStatsParser().parseGameStats(lines);

        assertThat(stats.getStatsItems().size(), is(4));
        assertThat(stats.getWinnerTeam(), is("Team B"));
        assertThat(stats.getBestPlayer(), is("player 4"));
    }
}