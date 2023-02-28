package main.scr;

import java.util.Scanner;

public class GameRunner {
    GameLogic gameLogic;
    Field field;
    boolean exit = false;

    public static void main(String[] args) {
        GameRunner game = new GameRunner();
        game.start();
    }


    public void run() {
        gameLogic = new GameLogic();
        gameLogic.isGameOver = false;
        field = new Field();
        field.printField(); // выводим в консоль стартовое поле
        while (!gameLogic.isGameOver) { // пока игра не закончена выполняется цикл
            System.out.println();
            gameLogic.addGameObjectX(); // ход игрока Х
            field.printField();
            if(gameLogic.isGameOver) break; // игрок Х может выиграть раньше, чем закончится цикл, для это делаем проверку
            gameLogic.addGameObject0();
            field.printField();
        }
    }

    public void resetOrExit() { // по окончанию игры, можно выйти или начать новую игру
        boolean isChoiceMade = false;
        while (!isChoiceMade) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        switch (s) {
            case "y":
                field.fieldReset();
                isChoiceMade = true;
                break;
            case "q":
                exit = true;
                isChoiceMade = true;
                break;
            default:
                System.out.print("Сделайте свой выбор: ");
            }
        }
    }

    public void start() {
        while (!exit) {
            run(); // запускаем игру
            System.out.println("Чтобы играть еще раз введите: y ");
            System.out.println("Для выхода из игры введите: q ");
            resetOrExit(); // выбираем начать новую или выйти из игры
        }
    }
}
