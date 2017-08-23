package gameTicTacToePackage;

import common.Table;

public class TableTTT implements Table {
    int table[][];

    @Override
    public void print() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if(table[i][j]==1) System.out.print("X"+" ");
                if(table[i][j]==2) System.out.print("0"+" ");
                if(table[i][j]==0) System.out.print("-"+" ");
            }
            System.out.println("");
        }
        System.out.println("\n");

    }

    @Override
    public void reset() {
        table = new int[3][3];

    }

    @Override
    public void init() {
    }


    public boolean hasALineOfTheSameSymbol() {
        for (int i = 0; i <= 2; i++) {
            if (table[i][0] == table[i][1] && table[i][1] == table[i][2] && table[i][0] != 0 && table[i][1] != 0 && table[i][2] != 0) {
                return true;

            }
            if (table[0][i] == table[1][i] && table[1][i] == table[2][i] && table[0][i] != 0 && table[1][i] != 0 && table[2][i] != 0) {
                return true;
            }
        }
        if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] != 0 && table[1][1] != 0 && table[2][2] != 0) {
            return true;
        }
        if (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[1][1] != 0 && table[0][2] != 0 && table[2][0] != 0) {
            return true;
        }
        return false;
    }

    public void addNewValueToTheTable(int m, int a, int b) {
        if (m % 2 == 0) {
            table[a][b] = 2;
        } else table[a][b] = 1;

    }

    public boolean isPositionAlredyOccupied(int a, int b) {
        if (table[a][b] != 0) {
            return true;
        }
        return false;
    }

    public boolean possibleMovesExist() {
        int n = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (table[i][j] == 0) {
                    n++;
                }
            }
        }
        if (n > 0) {
            return true;
        } else return false;
    }
}
