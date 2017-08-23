package game2048Package;

import common.Table;

import java.util.Random;

public class Table2048 implements Table {
    int table[][];

    @Override
    public void print() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    @Override
    public void reset() {
    table=new int[4][4];
    }

    @Override
    public void init() {
        table=new int[4][4];
        int y = 0;
        int z = 0;
        int START = 0;
        int END = 3;
        Random random = new Random();

        for (int idx = 1; idx <= 2; ++idx) {
            y = showRandomInteger(START, END, random);
            z = showRandomInteger(START, END, random);

            if (idx == 1) {
                table[y][z] = 2;
            } else {
                table[y][z] = 4;
            }

        }

    }
    public static int showRandomInteger(int aStart, int aEnd, Random aRandom) {
        int y;
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long) aEnd - (long) aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long) (range * aRandom.nextDouble());
        int randomNumber = (int) (fraction + aStart);
        y = randomNumber;
        return y;
    }
    public boolean hasMovesAvailable(){
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] == 0)
                    return true;
            }
        }


        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 2; j++) {
                if (table[i][j] == table[i][j + 1]) {
                    return true;
                }
            }
        }
        for (int j = 0; j <= 3; j++) {
            for (int i = 0; i <= 2; i++) {
                if (table[j][i] == table[i + 1][j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean contains2048(){
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] == 2048) {

                    return true;
                }
            }

        }

        return false;
    }

    public  void shiftUD(game2048Package.Direction direction) {
        int x[] = new int[4];
        for (int j = 0; j <= 3; j++) {
            if (direction == game2048Package.Direction.UP) {
                int a = 0;
                x = new int[4];
                for (int i = 0; i <= 3; i++) {
                    if (table[i][j] != 0) {
                        x[a] = table[i][j];
                        a++;
                    }
                }
                addLU(x);


                for (a = 0; a <= 3; a++)
                    table[a][j] = x[a];
                x = new int[4];
                a = 0;
                for (int i = 0; i <= 3; i++) {
                    if (table[i][j] != 0) {
                        x[a] = table[i][j];
                        a++;
                    }
                }
                for (a = 0; a <= 3; a++)
                    table[a][j] = x[a];
            } else if (direction == game2048Package.Direction.DOWN) {
                int a = 3;
                x = new int[4];
                for (int i = 3; i >= 0; i--) {
                    if (table[i][j] != 0) {
                        x[a] = table[i][j];
                        a--;
                    }
                }
                addRD(x);
                for (a = 3; a >= 0; a--) {
                    table[a][j] = x[a];
                }
                x = new int[4];
                a = 3;
                for (int i = 3; i >= 0; i--) {
                    if (table[i][j] != 0) {
                        x[a] = table[i][j];
                        a--;
                    }
                }
                for (a = 3; a >= 0; a--) {
                    table[a][j] = x[a];
                }
            }

        }
    }

    public   int[] addLU(int x[]) {
        int a = 0;
        if (x[a] == x[a + 1]) {
            x[a] = x[a] * 2;
            x[a + 1] = 0;
        }
        a = 1;
        if (x[a] == x[a + 1]) {
            x[a] = x[a] * 2;
            x[a + 1] = 0;
        }
        a = 2;
        if (x[a] == x[a + 1]) {
            x[a] = x[a] * 2;
            x[a + 1] = 0;
        }
        return x;
    }

    public   int[] addRD(int x[]) {
        int a = 3;
        if (x[a] == x[a - 1]) {
            x[a] = x[a] * 2;
            x[a - 1] = 0;
        }
        a = 2;
        if (x[a] == x[a - 1]) {
            x[a] = x[a] * 2;
            x[a - 1] = 0;
        }
        a = 1;
        if (x[a] == x[a - 1]) {
            x[a] = x[a] * 2;
            x[a - 1] = 0;
        }
        return x;
    }

   public void addNewValue() {
        int g, h;
        Random random = new Random();
        do {
            g = showRandomInteger(0, 3, random);
            h = showRandomInteger(0, 3, random);

        } while (table[g][h] != 0);
        table[g][h] = 2;
    }
    public   void shiftLR(game2048Package.Direction direction) {
        int y[] = new int[4];

        for (int i = 0; i <= 3; i++) {
            if (direction == game2048Package.Direction.LEFT) {
                int a = 0;
                y = new int[4];
                for (int j = 0; j <= 3; j++) {
                    if (table[i][j] != 0) {
                        y[a] = table[i][j];
                        a++;
                    }
                }
                addLU(y);
                for (a = 0; a <= 3; a++) {
                    table[i][a] = y[a];
                }
                y = new int[4];
                a = 0;
                for (int j = 0; j <= 3; j++) {
                    if (table[i][j] != 0) {
                        y[a] = table[i][j];
                        a++;
                    }
                }
                for (a = 0; a <= 3; a++) {
                    table[i][a] = y[a];
                }
            } else if (direction == game2048Package.Direction.RIGHT) {
                int a = 3;
                y = new int[4];
                for (int j = 3; j >= 0; j--) {
                    if (table[i][j] != 0) {
                        y[a] = table[i][j];
                        a--;
                    }
                }
                addRD(y);
                for (a = 3; a >= 0; a--) {
                    table[i][a] = y[a];
                }
                a = 3;
                y = new int[4];
                for (int j = 3; j >= 0; j--) {
                    if (table[i][j] != 0) {
                        y[a] = table[i][j];
                        a--;
                    }
                }
                for (a = 3; a >= 0; a--) {
                    table[i][a] = y[a];
                }
            }

        }
    }
}
