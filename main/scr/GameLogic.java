package main.scr;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GameLogic {
    Scanner scanner;
    GameObjectX gameObjectX;
    GameObject0 gameObject0;
    boolean isGameOver = false;

    public void addGameObjectX(char[][] gameField) {
        boolean isGameObjectHere = true;
        while (isGameObjectHere) { // цикл продолжается, пока игрок не выберет пустую ячейку в пределах поля
            System.out.println("Введите координаты Х (По горизонтали, по вертикали через пробел): ");
            try { // если введены любые символы кроме цифр
                scanner = new Scanner(System.in);
                int x = scanner.nextInt(); // получаем координату х
                int y = scanner.nextInt(); // получаем кооржинату у
                if (((x < 1 || x > 3) || (y < 1 || y > 3) || gameField[x][y] == 'X' || gameField[x][y] == '0')) {
                    // проверяем чтобы координаты не выходили за пределы поля, а так же чтобы в ячейка была не занята
                    System.out.print("Введены неверные координаты, попробуйте еще раз.");
                } else {
                    gameObjectX = new GameObjectX(x, y, gameField); // создаем объект Х и добавляем его на игровое поле
                    isGameObjectHere = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введены неверные координаты. Попробуйте еще раз.");
            }

            if(checkWinner(gameField, 'X')) {
                System.out.println("Победу одержал игрок: Х");
            }
             // проверяем был ли данный ход победным
        }
    }

    public void addGameObject0(char[][] gameField) {
        boolean isGameObjectHere = true;
        while (isGameObjectHere) { // цикл продолжается, пока игрок не выберет пустую ячейку в пределах поля
            System.out.println(" Введите координаты 0 (По горизонтали, по вертикали через пробел): ");
            try { // если введены любые символы кроме цифр
                scanner = new Scanner(System.in);
                int x = scanner.nextInt(); // получаем координату х
                int y = scanner.nextInt(); // получаем кооржинату у
                if (((x < 1 || x > 3) || (y < 1 || y > 3) || gameField[x][y] == 'X' || gameField[x][y] == '0')) {
                    // проверяем чтобы координаты не выходили за пределы поля, а так же чтобы в ячейка была не занята
                    System.out.print("Введены неверные координаты, попробуйте еще раз.");
                } else {
                    gameObject0 = new GameObject0(x, y, gameField); // создаем объект У и добавляем его на игровое поле
                    isGameObjectHere = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введены неверные координаты");
            }

            if(checkWinner(gameField, '0')) {
                System.out.println("Победу одержал игрок: 0");
            }
        }
    }

    private boolean checkWinner(char[][] gameField, char player) { // проверка на победителя
        //по горизонтали
        isGameOver = true;
        if (gameField[1][1] == player && gameField[1][2] == player && gameField[1][3] == player) {
            return true;
        }
        if (gameField[2][1] == player && gameField[2][2] == player && gameField[2][3] == player) {
            return true;
        }
        if (gameField[3][1] == player && gameField[3][2] == player && gameField[3][3] == player) {
            return true;
        }
        //по вертикали
        if (gameField[1][1] == player && gameField[2][1] == player && gameField[3][1] == player) {
            return true;
        }
        if (gameField[1][2] == player && gameField[2][2] == player && gameField[3][2] == player) {
            return true;
        }
        if (gameField[1][3] == player && gameField[2][3] == player && gameField[3][3] == player) {
            return true;
        }
        //по диагонали
        if (gameField[1][1] == player && gameField[2][2] == player && gameField[3][3] == player) {
            return true;
        }
        if (gameField[3][1] == player && gameField[2][2] == player && gameField[1][3] == player) {
            return true;
        } else {
            isGameOver = false;
            return false;
        }
    }

    private static class GameObjectX {
        GameObjectX(int x, int y, char[][] gameField) {
            gameField[x][y] = 'X';
        }
    }

    private static class GameObject0 {
        GameObject0(int x, int y, char[][] gameField) {
            gameField[x][y] = '0';
        }
    }
}
