package ladder.creator;

import ladder.LadderSize;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public interface LadderCreator {

    public void drawLine(Position row, Position col);

    public Row[] getRows();
}