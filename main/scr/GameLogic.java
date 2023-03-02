package main.scr;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GameLogic {
    Scanner scanner;
    private boolean isGameOver = false;
    private int objectCount; //переменна, которая отвечает за обьект на поле Х или 0

    public void addGameObject(char[][] gameField) {
        boolean isGameObjectHere = true;
        int x, y;
        while (isGameObjectHere) { // цикл продолжается, пока игрок не выберет пустую ячейку в пределах поля
            if(objectCount % 2 == 0) { // проверяем какому объекту соответствует данная переменная (четная Х, нечетная 0)
                System.out.println("Введите координаты Х через пробел (По горизонтали, по вертикали): ");
            } else { System.out.println("Введите координаты 0 через пробел (По горизонтали, по вертикали): ");}
            try {
                scanner = new Scanner(System.in);
                x = scanner.nextInt(); // получаем координату х
                y = scanner.nextInt(); // получаем координату у
                if(isEmptyCell(gameField, x, y)) {
                    System.out.print("Введены неверные координаты, попробуйте еще раз.");
                } else {
                    addObject(gameField, x, y);
                    isGameObjectHere = false;
                }
            } catch (InputMismatchException e) { //если введены не цифры
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
            checkTied(gameField); // проверяем игру на ничью
        }
    }


    public boolean isGameOver() {
        return isGameOver;
    }

    private boolean isEmptyCell(char[][] gameField, int x, int y) { // проверяем чтобы координаты не выходили за пределы поля, а так же чтобы в ячейка была не занята
        return ((x < 1 || x > 3) || (y < 1 || y > 3) || gameField[x][y] == 'X' || gameField[x][y] == '0');
    }

    public void setObjectCount(int objectCount) {
        this.objectCount = objectCount;
    }

    private void addObject(char[][] gameField, int x, int y) {
        if(objectCount % 2 == 0) {
            gameField[x][y] = 'X';
        } else {
            gameField[x][y] = '0';}
        objectCount ++;
    }

    private boolean checkWinner(char[][] gameField, char player) { // проверка на победителя
        //по горизонтали
        if (gameField[1][1] == player && gameField[1][2] == player && gameField[1][3] == player) return true;
        if (gameField[2][1] == player && gameField[2][2] == player && gameField[2][3] == player) return true;
        if (gameField[3][1] == player && gameField[3][2] == player && gameField[3][3] == player) return true;
        //по вертикали
        if (gameField[1][1] == player && gameField[2][1] == player && gameField[3][1] == player) return true;
        if (gameField[1][2] == player && gameField[2][2] == player && gameField[3][2] == player) return true;
        if (gameField[1][3] == player && gameField[2][3] == player && gameField[3][3] == player) return true;
        //по диагонали
        if (gameField[1][1] == player && gameField[2][2] == player && gameField[3][3] == player) return true;
        return gameField[3][1] == player && gameField[2][2] == player && gameField[1][3] == player;
    }

    private void checkTied(char[][] gameField) { // Проверяем игру на ничью
        char cellIndicator = '0';
        for(int i = 1; i < 4; i++) {
            for(int j = 1; j < 4; j++) {
                cellIndicator = gameField[i][j];
                if (cellIndicator == '*') {
                    break;
                }
            }
            if (cellIndicator == '*') {
                break;
            }
        }
        if(cellIndicator != '*') {
            isGameOver = true;
        }
    }
}