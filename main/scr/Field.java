package main.scr;

public class Field {

    public static char[][] gameField = { //создаем поле для игры с координатами
            {' ', '1', '2', '3'},
            {'1', '*', '*', '*'},
            {'2', '*', '*', '*'},
            {'3', '*', '*', '*'}
    };

    public void printField() {  //выводим поле в консоль
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(gameField[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public void fieldReset() {  //восстанавливаем изначальную структуру поля
        char[][] createNewField = {
                {' ', '1', '2', '3'},
                {'1', '*', '*', '*'},
                {'2', '*', '*', '*'},
                {'3', '*', '*', '*'}
        };
        gameField = createNewField;
    }
}
