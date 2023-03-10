package com.expacecat.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;


public class GameLogic {
    private final Field field = new Field();
    private final String X_VALUE = "X";
    private final String O_VALUE = "0";

    public void startGame() {
        while (true) {
            System.out.println("Game started:");
            while (checkWinner() == null) {
                getField();
                processFirstPlayerInput();
                getField();
                if (checkWinner() != null) {
                    break;
                }
                processSecondPlayerInput();
                checkWinner();
            }
            System.out.println(checkWinner());
            if(!isExit()) {
                resetField();
            } else break;
        }
    }

    private void processFirstPlayerInput() {
        System.out.println("Enter you choice: ");
        consoleInput(X_VALUE);
    }

    private void processSecondPlayerInput() {
        System.out.println("Enter you choice: ");
        consoleInput(O_VALUE);
    }

    private void consoleInput(String value) {
        boolean isCorrectInput = false;
        int inputNumberOfCell;
        while (!isCorrectInput) {
            try {
                Scanner scanner = new Scanner(System.in);
                inputNumberOfCell = scanner.nextInt();
                if (isValidItemInput(inputNumberOfCell)) {
                    field.setItemValue(inputNumberOfCell, value);
                    isCorrectInput = true;
                } else {
                    System.out.println("Incorrect input value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input value.");
            }
        }
    }


    private boolean isValidItemInput(int position) {
        return (position >= 0 && position <= 8) && !(field.getItemValue(position)).equals(X_VALUE) && !(field.getItemValue(position)).equals(O_VALUE);
    }

    private void getField() {
        System.out.printf("%s %s %s \n", field.getItemValue(0), field.getItemValue(1), field.getItemValue(2));
        System.out.printf("%s %s %s \n", field.getItemValue(3), field.getItemValue(4), field.getItemValue(5));
        System.out.printf("%s %s %s \n", field.getItemValue(6), field.getItemValue(7), field.getItemValue(8));
    }


    private String checkWinner() {
        if (field.getItemValue(0).equals(X_VALUE) && field.getItemValue(1).equals(X_VALUE) && field.getItemValue(2).equals(X_VALUE))
            return "X is WINNER";
        if (field.getItemValue(3).equals(X_VALUE) && field.getItemValue(4).equals(X_VALUE) && field.getItemValue(5).equals(X_VALUE))
            return "X is WINNER";
        if (field.getItemValue(6).equals(X_VALUE) && field.getItemValue(7).equals(X_VALUE) && field.getItemValue(8).equals(X_VALUE))
            return "X is WINNER";
        if (field.getItemValue(0).equals(X_VALUE) && field.getItemValue(3).equals(X_VALUE) && field.getItemValue(6).equals(X_VALUE))
            return "X is WINNER";
        if (field.getItemValue(1).equals(X_VALUE) && field.getItemValue(4).equals(X_VALUE) && field.getItemValue(7).equals(X_VALUE))
            return "X is WINNER";
        if (field.getItemValue(2).equals(X_VALUE) && field.getItemValue(5).equals(X_VALUE) && field.getItemValue(8).equals(X_VALUE))
            return "X is WINNER";
        if (field.getItemValue(0).equals(X_VALUE) && field.getItemValue(4).equals(X_VALUE) && field.getItemValue(8).equals(X_VALUE))
            return "X is WINNER";
        if (field.getItemValue(2).equals(X_VALUE) && field.getItemValue(5).equals(X_VALUE) && field.getItemValue(6).equals(X_VALUE))
            return "X is WINNER";
        if (field.getItemValue(0).equals(O_VALUE) && field.getItemValue(1).equals(O_VALUE) && field.getItemValue(2).equals(O_VALUE))
            return "0 is WINNER";
        if (field.getItemValue(3).equals(O_VALUE) && field.getItemValue(4).equals(O_VALUE) && field.getItemValue(5).equals(O_VALUE))
            return "0 is WINNER";
        if (field.getItemValue(6).equals(O_VALUE) && field.getItemValue(7).equals(O_VALUE) && field.getItemValue(8).equals(O_VALUE))
            return "0 is WINNER";
        if (field.getItemValue(0).equals(O_VALUE) && field.getItemValue(3).equals(O_VALUE) && field.getItemValue(6).equals(O_VALUE))
            return "0 is WINNER";
        if (field.getItemValue(1).equals(O_VALUE) && field.getItemValue(4).equals(O_VALUE) && field.getItemValue(7).equals(O_VALUE))
            return "0 is WINNER";
        if (field.getItemValue(2).equals(O_VALUE) && field.getItemValue(5).equals(O_VALUE) && field.getItemValue(8).equals(O_VALUE))
            return "0 is WINNER";
        if (field.getItemValue(0).equals(O_VALUE) && field.getItemValue(4).equals(O_VALUE) && field.getItemValue(8).equals(O_VALUE))
            return "0 is WINNER";
        if (field.getItemValue(2).equals(O_VALUE) && field.getItemValue(5).equals(O_VALUE) && field.getItemValue(6).equals(O_VALUE))
            return "0 is WINNER";
        if (!checkDraw()) {
            return "Draw.";
        } else return null;
    }

    private boolean checkDraw() {
        String indicator = "";
        for (int i = 0; i < 9; i++) {
            indicator = field.getItemValue(i);
            if (indicator.equals("*")) {
                break;
            }
        }
        return indicator.equals("*");
    }

    private boolean isExit() {
        System.out.println("New Game? Y to start: ");
        Scanner scanner = new Scanner(System.in);
        String inputAnswer = scanner.nextLine();
        return !inputAnswer.equalsIgnoreCase("Y");
    }

    private void resetField() {
        for (int i = 0; i < 9; i++) {
            field.setItemValue(i, "*");
        }
    }



}
