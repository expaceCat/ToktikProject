package main.scr;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GameLogic {
    boolean isGameOver;
    GameObjectX gameObjectX;
    GameObject0 gameObject0;


    public void addGameObjectX() {
        boolean isGameObjectHere = true;

        while (isGameObjectHere) { // цикл продолжается, пока игрок не выберет пустую ячейку в пределах поля
            System.out.println("Введите координаты Х (По горизонтали, по вертикали через пробел): ");
            try { // если введены любые символы кроме цифр
                Scanner scanner = new Scanner(System.in);
                int x = scanner.nextInt(); // получаем координату х
                int y = scanner.nextInt(); // получаем кооржинату у
                if (((x < 1 || x > 3) || (y < 1 || y > 3) || Field.gameField[x][y] == 'X' || Field.gameField[x][y] == '0')) {
                    // проверяем чтобы координаты не выходили за пределы поля, а так же чтобы в ячейка была не занята
                    System.out.print("Введены неверные координаты, попробуйте еще раз.");
                    isGameObjectHere = true;
                } else {
                    gameObjectX = new GameObjectX(x, y); // создаем объект Х и добавляем его на игровое поле
                    isGameObjectHere = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введены неверные координаты");
            }

            checkWinner(); // проверяем был ли данный ход победным
            if (isGameOver) return;
        }
    }

    public void addGameObject0() {
        boolean isGameObjectHere = true;
        while (isGameObjectHere) { // цикл продолжается, пока игрок не выберет пустую ячейку в пределах поля
            System.out.println(" Введите координаты 0 (По горизонтали, по вертикали через пробел): ");
            try { // если введены любые символы кроме цифр
                Scanner scanner = new Scanner(System.in);
                int x = scanner.nextInt(); // получаем координату х
                int y = scanner.nextInt(); // получаем кооржинату у
                if (((x < 1 || x > 3) || (y < 1 || y > 3) || Field.gameField[x][y] == 'X' || Field.gameField[x][y] == '0')) {
                    // проверяем чтобы координаты не выходили за пределы поля, а так же чтобы в ячейка была не занята
                    System.out.print("Введены неверные координаты, попробуйте еще раз.");
                    isGameObjectHere = true;
                } else {
                    gameObject0 = new GameObject0(x, y); // создаем объект У и добавляем его на игровое поле
                    isGameObjectHere = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введены неверные координаты");
            }

            checkWinner();
            if (isGameOver) return;
        }
    }

    public void checkWinner() { // проверка на победителя
        //условие для Х
        //по горизонтали
        if (Field.gameField[1][1] == 'X' && Field.gameField[1][2] == 'X' && Field.gameField[1][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if (Field.gameField[2][1] == 'X' && Field.gameField[2][2] == 'X' && Field.gameField[2][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if(Field.gameField[3][1] == 'X' && Field.gameField[3][2] == 'X' && Field.gameField[3][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        } //по вертикали
        if (Field.gameField[1][1] == 'X' && Field.gameField[2][1] == 'X' && Field.gameField[3][1] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if (Field.gameField[1][2] == 'X' && Field.gameField[2][2] == 'X' && Field.gameField[3][2] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if (Field.gameField[1][3] == 'X' && Field.gameField[2][3] == 'X' && Field.gameField[3][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        } //по диагонали
        if (Field.gameField[1][1] == 'X' && Field.gameField[2][2] == 'X' && Field.gameField[3][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }
        if (Field.gameField[3][1] == 'X' && Field.gameField[2][2] == 'X' && Field.gameField[1][3] == 'X') {
            System.out.println("Победу одержал игрок Х");
            isGameOver = true;
        }


        //условие для 0
        //по горизонтали
        if (Field.gameField[1][1] == '0' && Field.gameField[1][2] == '0' && Field.gameField[1][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if (Field.gameField[2][1] == '0' && Field.gameField[2][2] == '0' && Field.gameField[2][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if(Field.gameField[3][1] == '0' && Field.gameField[3][2] == '0' && Field.gameField[3][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        } //по вертикали
        if (Field.gameField[1][1] == '0' && Field.gameField[2][1] == '0' && Field.gameField[3][1] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if (Field.gameField[1][2] == '0' && Field.gameField[2][2] == '0' && Field.gameField[3][2] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if (Field.gameField[1][3] == '0' && Field.gameField[2][3] == '0' && Field.gameField[3][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }//по диагонали
        if (Field.gameField[1][1] == '0' && Field.gameField[2][2] == '0' && Field.gameField[3][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
        if (Field.gameField[3][1] == '0' && Field.gameField[2][2] == '0' && Field.gameField[1][3] == '0') {
            System.out.println("Победу одержал игрок 0");
            isGameOver = true;
        }
    }
}
