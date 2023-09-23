package ladder;

public class LadderPosition {
    private int x;
    private int y;

    public LadderPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void updataPosititon(int x, int y){
        this.x = x;
        this.y = y;
    }
}
