package main.scr;

import java.util.Scanner;

public class GameRunner {
    Scanner scanner;
    boolean exit = false;

    public static void main(String[] args) {
        GameRunner game = new GameRunner();
        Field field = new Field();
        game.start(field);
    }


    public void run(Field field) {
        GameLogic gameLogic = new GameLogic();
        char[][] gameField  = field.getGameField();
        printField(gameField); // выводим в консоль стартовое поле
        while (!gameLogic.isGameOver) { // пока игра не закончена выполняется цикл
            gameLogic.addGameObjectX(gameField); // ход игрока Х
            printField(gameField);
            if(gameLogic.isGameOver) break; // игрок Х может выиграть раньше, чем закончится цикл, для это делаем проверку
            gameLogic.addGameObject0(gameField);
            printField(gameField);
        }
    }

    public void resetOrExit() { // по окончанию игры, можно выйти или начать новую игру
        boolean isChoiceMade = false;
        while (!isChoiceMade) {
        String s = scanner.nextLine();
            if (s.equals("y")) {
                isChoiceMade = true;
            } else if (s.equals("q")) {
                exit = true;
                isChoiceMade = true;
            } else {
                System.out.print("Сделайте свой выбор: ");
            }
        }
    }

    public void start(Field field) {
        while (!exit) {
            run(field); // запускаем игру
            System.out.println("Чтобы играть еще раз введите: \"y\". Для выхода из игры введите: \"q\"");
            resetOrExit(); // выбираем начать новую или выйти из игры
        }
    }

    public void printField(char[][] gameField) {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(gameField[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }

    }
}
