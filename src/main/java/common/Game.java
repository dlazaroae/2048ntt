package common;

import gameTicTacToePackage.Player;

public abstract class Game {

    protected abstract void newGame();
    protected abstract boolean isGameOver();
    protected abstract boolean isGameWon();
    protected abstract void move(int n);
    protected abstract Player getPlayer1();
    protected abstract Player getPlayer2();
}

