package main.scr;

import java.util.Scanner;

public class GameRunner {
    private boolean isExit;


    public static void main(String[] args) {
        GameRunner game = new GameRunner();
        game.start();
    }

    private void run() {
        Field field = new Field();
        GameLogic gameLogic = new GameLogic();
        gameLogic.setObjectCount(0);
        char[][] gameField = field.getGameFieldModel();
        field.printField(gameField); // выводим в консоль стартовое поле
        while (!gameLogic.isGameOver()) { // пока игра не закончена выполняется цикл
            gameLogic.addGameObject(gameField); // ход игрока
            field.printField(gameField);
        }
    }

    private void resetOrExit() { // по окончанию игры, можно выйти или начать новую игру
        boolean isChoiceMade = false;
        while (!isChoiceMade) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.equals("y")) {
                isChoiceMade = true;
            } else if (s.equals("q")) {
                isExit = true;
                isChoiceMade = true;
            } else {
                System.out.print("Сделайте свой выбор: ");
            }
        }
    }

    private void start() {
        isExit = false;
        while (!isExit) {
            run(); // запускаем игру
            System.out.println("Чтобы играть еще раз введите: \"y\". Для выхода из игры введите: \"q\"");
            resetOrExit(); // выбираем начать новую или выйти из игры
        }
    }
}