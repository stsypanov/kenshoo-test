package kenshoo.mvp.misc;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import kenshoo.mvp.domain.Game;
import kenshoo.mvp.domain.stats.GameStats;
import kenshoo.mvp.misc.parser.ParserFactory;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CsvGameStatsFileReader implements GameStatsFileReader {

    private final ParserFactory parserFactory = new ParserFactory();

    @Override
    @SneakyThrows
    public Map<Game, GameStats> readFiles(List<File> files) {
        Objects.requireNonNull(files);
        if (files.isEmpty()) {
            throw new IllegalArgumentException("No files for parsing, probably it's a developer's mistake");
        }
        final Map<Game, GameStats> map = new EnumMap<>(Game.class);
        final CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        for (File file : files) {
            try (FileReader reader = new FileReader(file)) {
                final CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
                List<String[]> fileLines = csvReader.readAll();
                if (fileLines.isEmpty()) {
                    throw new IllegalArgumentException("File is empty");
                }
                parseGameStats(map, fileLines);
            }
        }
        return map;
    }

    private void parseGameStats(Map<Game, GameStats> map, List<String[]> fileLines) {
        Game game = detectGame(fileLines);
        GameStats gameStats = parserFactory.getGameStatsParser(game).parseGameStats(fileLines);
        map.put(game, gameStats);
    }

    private Game detectGame(List<String[]> fileLines) {
        String[] remove = fileLines.remove(0);
        if (remove.length != 1) {
            throw new IllegalArgumentException("First line must be game name");
        }
        String gameName = remove[0].toUpperCase();
        return Game.valueOf(gameName);
    }
}
