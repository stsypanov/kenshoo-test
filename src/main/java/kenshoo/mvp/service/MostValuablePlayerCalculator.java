package kenshoo.mvp.service;

import kenshoo.mvp.domain.stats.GameStats;

import java.util.List;

public interface MostValuablePlayerCalculator {

    String findMostValuablePlayer(List<GameStats> gameStats);

}
