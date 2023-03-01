package main.scr;

import java.util.Scanner;

public class GameRunner {
    boolean exit = false;


    public static void main(String[] args) {
        GameRunner game = new GameRunner();
        game.start();
    }

    public void run() {
        Field field = new Field();
        GameLogic gameLogic = new GameLogic();
        gameLogic.setObjectCount(0);
        char[][] gameField  = field.getGameField();
        printField(gameField); // выводим в консоль стартовое поле
        while (!gameLogic.isGameOver) { // пока игра не закончена выполняется цикл
            gameLogic.addGameObject(gameField); // ход игрока Х
            printField(gameField);
        }
    }

    public void resetOrExit() { // по окончанию игры, можно выйти или начать новую игру
        boolean isChoiceMade = false;
        while (!isChoiceMade) {
            Scanner scanner = new Scanner(System.in);
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

    public void start() {
        while (!exit) {
            run(); // запускаем игру
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