import java.util.Random;
import java.util.Scanner;

public class MainGame2048 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println("If you type in a diffrent number than{4, 5, 6, 8} the defult direction will be left.");
        System.out.println("If you type in a letter the application will crash.");
        int table[][] = new int[4][4];
        while (true) {
            if (n == 0) {
                n = init(n, table);
                print(table);
            }
            if (gameOver(table)) {
                System.out.println("Game Over! D:");
                break;
            }
            System.out.println("Number of moves " + n);
            shift(table);
            if (n > 11) win(table);
            print(table);
            addNewValue(table);
            n++;
//            fillTable(table)
        }
    }

    private static void fillTable(int[][] table) {
        int a = 1;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                table[i][j] = a;
                a++;
            }

        }
    }

    private static void win(int[][] table) {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] == 2048) {
                    System.out.println("You win!!!! Congrats :D");
                    break;
                }
            }

        }
    }

    private static int[] addRD(int x[]) {
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

    private static int[] addLU(int x[]) {
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

    private static boolean gameOver(int[][] table) {

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] == 0)
                    return false;
            }
        }


        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 2; j++) {
                if (table[i][j] == table[i][j + 1]) {
                    return false;
                }
            }
        }
        for (int j = 0; j <= 3; j++) {
            for (int i = 0; i <= 2; i++) {
                if (table[j][i] == table[i + 1][j]) {
                    return false;
                }
            }
        }
        return true;

    }

    private static void addNewValue(int[][] table) {
        int g, h;
        Random random = new Random();
        do {
            g = showRandomInteger(0, 3, random);
            h = showRandomInteger(0, 3, random);

        } while (table[g][h] != 0);
        table[g][h] = 2;
    }

    private static void shift(int[][] table) {


        Scanner in = new Scanner(System.in);
        int dir = in.nextInt();
        Direction direction = Direction.fromVal(dir);
        if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            shiftLR(table, direction);
        } else {
            shiftUD(table, direction);
        }


    }

    private static void shiftUD(int[][] table, Direction direction) {
        int x[] = new int[4];
        for (int j = 0; j <= 3; j++) {
            if (direction == Direction.UP) {
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
            } else if (direction == Direction.DOWN) {
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

    private static void shiftLR(int[][] table, Direction direction) {
        int y[] = new int[4];

        for (int i = 0; i <= 3; i++) {
            if (direction == Direction.LEFT) {
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
            } else if (direction == Direction.RIGHT) {
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

    private static void print(int[][] table) {
     /*   for (int i = 0; i <= 3; i++) {

            System.out.println(table[i][0] + " - " + table[i][1] + " - " + table[i][2] + " - " + table[i][3]);

        }
        System.out.println("\n");*/

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    private static int init(int n, int[][] table) {
        int y = 0;
        int z = 0;
        n++;
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
        return n;
    }


    private static int showRandomInteger(int aStart, int aEnd, Random aRandom) {
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


}