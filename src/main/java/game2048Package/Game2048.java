package game2048Package;

import common.Game;
import gameTicTacToePackage.Player;

import java.util.Scanner;

public class Game2048 extends Game{
    Table2048 table;

    public void newGame() {
        table = new Table2048();
        table.reset();
        table.init();
        table.print();

    }
    public boolean isGameOver() {
        return !table.hasMovesAvailable();

    }

    public boolean isGameWon() {
        return table.contains2048();

    }


    public void move(int n) {


        Scanner in = new Scanner(System.in);
        int dir = in.nextInt();
        if(dir==0){
            table.reset();
            n=0;
           newGame();
        }else{
        Direction direction = Direction.fromVal(dir);
        if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            table.shiftLR(direction);
        } else {
            table.shiftUD(direction);
        }
        table.addNewValue();
            table.print() ;
    } }

    @Override
    protected Player getPlayer1() {
        return null;
    }

    @Override
    protected Player getPlayer2() {
        return null;
    }
}