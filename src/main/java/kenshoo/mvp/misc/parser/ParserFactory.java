package kenshoo.mvp.misc.parser;

import kenshoo.mvp.domain.Game;

import java.util.Objects;

public class ParserFactory {

    public GameStatsParser getGameStatsParser(Game game) {
        Objects.requireNonNull(game);
        switch (game) {
            case HANDBALL:
                return new HandballStatsParser();
            case BASKETBALL:
                return new BasketballStatsParser();
            default: {
                final String msg = "Parser for %s not implemented";
                throw new IllegalArgumentException(String.format(msg, game));
            }
        }
    }
}
