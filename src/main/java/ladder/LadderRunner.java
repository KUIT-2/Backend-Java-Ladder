package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for(int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position.getValue();
    }

    public int runWithLog(Position curColPos) {

        int ladderHeight = rows.length;

        System.out.println("********사다리 게임 시작:" + curColPos.getValue());

        for(int curRowIdx = 0; curRowIdx < ladderHeight; curRowIdx++) {

            System.out.println("Before");
            printCurLadderState(LadderPosition.of(Position.of(curRowIdx), curColPos));

            curColPos = rows[curRowIdx].nextPosition(curColPos);

            System.out.println("After");
            printCurLadderState(LadderPosition.of(Position.of(curRowIdx), curColPos));

        }

        System.out.println("*********사다리 게임 결과:" + curColPos.getValue());

        return curColPos.getValue();
    }

    public void printCurLadderState(LadderPosition curLadderPosition) {
        for(int i = 0; i < rows.length; i++) {
            rows[i].printRow(curLadderPosition.isRowPositionSame(Position.of(i)), curLadderPosition);
        }
    }

}
