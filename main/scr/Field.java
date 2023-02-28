package main.scr;

public class Field {

    private final char[][] gameField = { //создаем поле для игры с координатами
            {' ', '1', '2', '3'},
            {'1', '*', '*', '*'},
            {'2', '*', '*', '*'},
            {'3', '*', '*', '*'}
    };

    public char[][] getGameField() {
        return gameField;
    }
}
