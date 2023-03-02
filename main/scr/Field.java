package main.scr;

public class Field {

    private final char[][] gameFieldModel = { // макет поля для игры
            {' ', '1', '2', '3'},
            {'1', '*', '*', '*'},
            {'2', '*', '*', '*'},
            {'3', '*', '*', '*'}
    };

    public char[][] getGameFieldModel() {
        return gameFieldModel;
    }

    public void printField(char[][] gameField) {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(gameField[i][j] + "   ");
            }
            System.out.println();
            System.out.println();
        }

    }
}
