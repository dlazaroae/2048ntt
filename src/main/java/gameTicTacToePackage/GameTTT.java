package gameTicTacToePackage;

import common.Game;

import java.util.Scanner;

public class GameTTT extends Game {
    TableTTT table;
    Player player1 = new Player();
    Player player2 = new Player();

    public Player getPlayer1() {
        return player1;
    }


    public Player getPlayer2() {
        return player2;
    }


    @Override
    public void newGame() {

        Scanner in = new Scanner(System.in);
        String playerName1 = in.nextLine();
        String playerName2 = in.nextLine();
        player1.setPlayerName(playerName1);
        player2.setPlayerName(playerName2);
        table = new TableTTT();
        table.reset();
        table.print();

    }

    // T.T
    @Override
    public boolean isGameOver() {
        if (table.possibleMovesExist()) {
            return false;
        } else return true;
    }

    @Override
    public boolean isGameWon() {
        if (table.hasALineOfTheSameSymbol()) {
            return true;
        } else return false;
    }

    public void move(int m) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        if (x == 0) {
            newGame();
        } else {
            Position position = Position.fromVal(x);
            int a = position.getX();
            int b = position.getY();
            if (table.isPositionAlredyOccupied(a, b)) {
                System.out.println("Position already occupied.");
                move(m);
            } else {
                table.addNewValueToTheTable(m, a, b);
                table.print();
                if (m % 2 != 0) {
                    System.out.println(player2.getPlayerName() + "'s turn");
                } else System.out.println(player1.getPlayerName() + "'s turn");

            }
        }
    }


}
