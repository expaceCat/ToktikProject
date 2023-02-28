package main.scr;

public class GameObjectX {
    private int x;
    private int y;

    GameObjectX(int x, int y, char gameField[][]) {
        this.x = x;
        this.y = y;
        gameField[x][y] = 'X';
    }

}
