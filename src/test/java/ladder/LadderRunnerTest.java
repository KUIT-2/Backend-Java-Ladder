package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.creator.StaticLadderCreator;
import org.junit.jupiter.api.Test;

public class LadderRunnerTest {

    @Test
    void 게임_결과_출력() {
        NaturalNumber numberOfRow = new NaturalNumber(10);
        NaturalNumber numberOfPerson = new NaturalNumber(5);

        LadderCreator ladderCreator = new RandomLadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderGame.RunLadderGame();
    }
}
