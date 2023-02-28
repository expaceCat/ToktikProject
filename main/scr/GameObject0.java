package main.scr;
import java.util.ArrayList;
import java.util.List;

public class GameObject0 {
    private int x;
    private int y;

    GameObject0(int x, int y) {
        this.x = x;
        this.y = y;
        Field.gameField[x][y] = '0';
    }

}
