package gameTicTacToePackage;

public enum Position {
    P00(0, 0), P01(0, 1), P02(0, 2), P10(1, 0), P11(1, 1), P12(1, 2), P20(2, 0), P21(2, 1), P22(2, 2);

    private int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Position fromVal(int val) {
        switch (val) {
            case 7:
                return P00;
            case 8:
                return P01;
            case 9:
                return P02;
            case 4:
                return P10;
            case 5:
                return P11;
            case 6:
                return P12;
            case 1:
                return P20;
            case 2:
                return P21;
            case 3:
                return P22;
            default:
                return P00;
        }
    }
}
