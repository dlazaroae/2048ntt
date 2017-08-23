package common;

import game2048Package.Game2048;
import gameTicTacToePackage.GameTTT;
import gameTicTacToePackage.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Type in:");
        System.out.println("1 for TicTacToe");
        System.out.println("2 for 2048");
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        int n = 1;
        Player player1=null;
        Player player2=null;
        Game game;
        if (g > 1) {
            game = new Game2048();
            System.out.println("If you type in a diffrent number than{4, 5, 6, 8} the defult direction will be left.");
            System.out.println("If you type in a letter the application will crash");
            System.out.println("For restart press 0");
        } else {
            game = new GameTTT();

            System.out.println("Use the numpad as positions.");
            System.out.println("For restart input 0.");
            System.out.println("Type the players names!");
            System.out.println("Player 1's name:");
            player1 = game.getPlayer1();
            System.out.println("Player 2's name:");
            player2 = game.getPlayer2();
        }


        game.newGame();
        while (!(game.isGameOver() || game.isGameWon())) {
            game.move(n);
            n++;
        }

        if (game.isGameOver()) {
            System.out.println("Game Over!!");
        }

//       GAME WON:
//          TicTacToe WON
        if (g == 1) {
            if (game.isGameWon()) {
                if (n % 2 == 0) {
                    System.out.println(player1.getPlayerName() + " Won!");
                } else {
                    System.out.println(player2.getPlayerName() + " Won!");
                }
            }
        }
//          2048 WON
        if (g == 2) {

            if (game.isGameWon()) {
                System.out.println("Congrats, you won!!");
            }
        }
    }
}


