package main.scr;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GameLogic {
    Scanner scanner;
    boolean isGameOver = false;
    private int objectCount; //переменна, которая отвечает за обьект на поле Х или 0

    public void addGameObject(char[][] gameField) {
        boolean isGameObjectHere = true;
        while (isGameObjectHere) { // цикл продолжается, пока игрок не выберет пустую ячейку в пределах поля
            if(objectCount % 2 == 0) { // проверяем какому объекту соответствует данная переменная
                System.out.println("Введите координаты Х (По горизонтали, по вертикали через пробел): ");
            } else { System.out.println(" Введите координаты 0 (По горизонтали, по вертикали через пробел): ");}
            try { // если введены любые символы кроме цифр
                scanner = new Scanner(System.in);
                int x = scanner.nextInt(); // получаем координату х
                int y = scanner.nextInt(); // получаем кооржинату у
                if (((x < 1 || x > 3) || (y < 1 || y > 3) || gameField[x][y] == 'X' || gameField[x][y] == '0')) {
                    // проверяем чтобы координаты не выходили за пределы поля, а так же чтобы в ячейка была не занята
                    System.out.print("Введены неверные координаты, попробуйте еще раз.");
                } else {
                    if(objectCount % 2 == 0) {
                        gameField[x][y] = 'X';
                    } else {
                        gameField[x][y] = '0';}
                    isGameObjectHere = false;
                    objectCount ++;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введены неверные координаты. Попробуйте еще раз.");
            }

            if(checkWinner(gameField, 'X')) { // проверяем был ли данный ход победным для Х
                System.out.println("Победу одержал игрок: Х");
                isGameOver = true;
            }
            if(checkWinner(gameField, '0')) { // проверяем был ли данный ход победным для 0
                System.out.println("Победу одержал игрок: 0");
                isGameOver = true;
            }
        }
    }

    public void setObjectCount(int objectCount) {
        this.objectCount = objectCount;
    }

    private boolean checkWinner(char[][] gameField, char player) { // проверка на победителя
        //по горизонтали
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
        return gameField[3][1] == player && gameField[2][2] == player && gameField[1][3] == player;
    }
}