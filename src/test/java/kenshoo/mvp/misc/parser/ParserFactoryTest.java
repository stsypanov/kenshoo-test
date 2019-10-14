package kenshoo.mvp.misc.parser;

import kenshoo.mvp.domain.Game;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class ParserFactoryTest {

    @Test(expected = NullPointerException.class)
    public void getGameStatsParser() {
        new ParserFactory().getGameStatsParser(null);
    }

    @Test
    public void testBasketball() {
        final GameStatsParser parser = new ParserFactory().getGameStatsParser(Game.BASKETBALL);
        assertThat(parser, is(instanceOf(BasketballStatsParser.class)));
    }

    @Test
    public void testHandball() {
        final GameStatsParser parser = new ParserFactory().getGameStatsParser(Game.HANDBALL);
        assertThat(parser, is(instanceOf(HandballStatsParser.class)));
    }

}
