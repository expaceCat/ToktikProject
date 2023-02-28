package main.scr;

public class GameObjectX {
    private int x;
    private int y;

    GameObjectX(int x, int y) {
        this.x = x;
        this.y = y;
        Field.gameField[x][y] = 'X';
    }

}
