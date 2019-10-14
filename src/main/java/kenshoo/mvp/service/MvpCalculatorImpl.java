package kenshoo.mvp.service;

import kenshoo.mvp.domain.stats.GameStats;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class MvpCalculatorImpl implements MostValuablePlayerCalculator {

    @Override
    public String findMostValuablePlayer(List<GameStats> gameStats) {
        Map<String, Integer> totalPlayerScores = gameStats
                .stream()
                .map(stats -> Map.entry(stats.getBestPlayer(), stats.getBestPlayerScore()))
                .collect(groupingBy(Map.Entry::getKey, summingInt(Map.Entry::getValue)));

        String mostValuablePlayer = totalPlayerScores
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow()
                .getKey();

        return mostValuablePlayer;
    }
}
