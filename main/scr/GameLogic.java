package main.scr;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GameLogic {
    boolean isGameOver;
    GameObjectX gameObjectX;
    GameObject0 gameObject0;


    public void addGameObjectX(char[][] gameField) {
        boolean isGameObjectHere = true;

        while (isGameObjectHere) { // цикл продолжается, пока игрок не выберет пустую ячейку в пределах поля
            System.out.println("Введите координаты Х (По горизонтали, по вертикали через пробел): ");
            try { // если введены любые символы кроме цифр
                Scanner scanner = new Scanner(System.in);
                int x = scanner.nextInt(); // получаем координату х
                int y = scanner.nextInt(); // получаем кооржинату у
                if (((x < 1 || x > 3) || (y < 1 || y > 3) || gameField[x][y] == 'X' || gameField[x][y] == '0')) {
                    // проверяем чтобы координаты не выходили за пределы поля, а так же чтобы в ячейка была не занята
                    System.out.print("Введены неверные координаты, попробуйте еще раз.");
                    isGameObjectHere = true;
                } else {
                    gameObjectX = new GameObjectX(x, y, gameField); // создаем объект Х и добавляем его на игровое поле
                    isGameObjectHere = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введены неверные координаты");
            }

            checkWinner(gameField); // проверяем был ли данный ход победным
            if (isGameOver) return;
        }
    }

    public void addGameObject0(char[][] gameField) {
        boolean isGameObjectHere = true;
        while (isGameObjectHere) { // цикл продолжается, пока игрок не выберет пустую ячейку в пределах поля
            System.out.println(" Введите координаты 0 (По горизонтали, по вертикали через пробел): ");
            try { // если введены любые символы кроме цифр
                Scanner scanner = new Scanner(System.in);
                int x = scanner.nextInt(); // получаем координату х
                int y = scanner.nextInt(); // получаем кооржинату у
                if (((x < 1 || x > 3) || (y < 1 || y > 3) || gameField[x][y] == 'X' || gameField[x][y] == '0')) {
                    // проверяем чтобы координаты не выходили за пределы поля, а так же чтобы в ячейка была не занята
                    System.out.print("Введены неверные координаты, попробуйте еще раз.");
                    isGameObjectHere = true;
                } else {
                    gameObject0 = new GameObject0(x, y, gameField); // создаем объект У и добавляем его на игровое поле
                    isGameObjectHere = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введены неверные координаты");
            }

            checkWinner(gameField);
            if (isGameOver) return;
        }
    }

    public void checkWinner(char[][] gameField) { // проверка на победителя
        //условие для Х
        //по горизонтали
        if (gameField[1][1] == 'X' && gameField[1][2] == 'X' && gameField[1][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if (gameField[2][1] == 'X' && gameField[2][2] == 'X' && gameField[2][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if(gameField[3][1] == 'X' && gameField[3][2] == 'X' && gameField[3][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        } //по вертикали
        if (gameField[1][1] == 'X' && gameField[2][1] == 'X' && gameField[3][1] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if (gameField[1][2] == 'X' && gameField[2][2] == 'X' && gameField[3][2] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if (gameField[1][3] == 'X' && gameField[2][3] == 'X' && gameField[3][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        } //по диагонали
        if (gameField[1][1] == 'X' && gameField[2][2] == 'X' && gameField[3][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if (gameField[3][1] == 'X' && gameField[2][2] == 'X' && gameField[1][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }


        //условие для 0
        //по горизонтали
        if (gameField[1][1] == '0' && gameField[1][2] == '0' && gameField[1][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if (gameField[2][1] == '0' && gameField[2][2] == '0' && gameField[2][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if(gameField[3][1] == '0' && gameField[3][2] == '0' && gameField[3][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        } //по вертикали
        if (gameField[1][1] == '0' && gameField[2][1] == '0' && gameField[3][1] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if (gameField[1][2] == '0' && gameField[2][2] == '0' && gameField[3][2] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if (gameField[1][3] == '0' && gameField[2][3] == '0' && gameField[3][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }//по диагонали
        if (gameField[1][1] == '0' && gameField[2][2] == '0' && gameField[3][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if (gameField[3][1] == '0' && gameField[2][2] == '0' && gameField[1][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
    }
}
