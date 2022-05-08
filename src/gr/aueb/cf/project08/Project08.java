package gr.aueb.cf.project08;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Project08 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        char[][] gameBoard = new char[3][3];

        runTheGame(gameBoard);
    }

    public static void runTheGame (char[][] gameBoard) throws IOException {
        int[] playerMove;
        boolean won = false;

        printGameRules();

        fillArr(gameBoard);
        printArr(gameBoard);

        for (int i = 1; i <= 9; i++) {

            if (i % 2 != 0) {
                System.out.println("Player 1 round");
                playerMove = playerMove();

                playerMove = checkInput(gameBoard, playerMove);

                gameBoard[playerMove[0]][playerMove[1]] = 'X';
                printArr(gameBoard);

                won = checkIfWon(gameBoard);

                if (won) {
                    System.out.println("Player 1 won the game");
                    break;
                }
            }

            if (i % 2 == 0) {
                System.out.println("Player 2 round");
                playerMove = playerMove();

                playerMove = checkInput(gameBoard, playerMove);

                gameBoard[playerMove[0]][playerMove[1]] = 'O';
                printArr(gameBoard);

                won = checkIfWon(gameBoard);

                if (won) {
                    System.out.println("Player 2 won the game");
                    break;
                }
            }

            if (i == 9 && !won) {
                System.out.println("Game Even");
            }
        }
    }

    public static void printGameRules () {
        System.out.println("Welcome to the Game!");
        System.out.println("The game is played by two players who play alternately");
        System.out.println("Player 1 will be assigned symbol: 'X'");
        System.out.println("Player 2 will be assigned symbol: 'O'");
        System.out.println("Game board is a 3x3 table, where columns are assigned the values 1, 2, 3" +
                " and rows are assigned the values A, B, C");
        System.out.println("Each player will be asked to choose the position of he wants to place his respective symbol (eg A1, B2, C1, B3, etc)");
        System.out.println("The goal is to place your symbol 3 times consequently in a row, column or vertically");
        System.out.println("Have fun!");
    }

    public static void fillArr (char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], ' ');
        }
    }

    public static void printArr (char[][] arr) {
        System.out.println();
        System.out.println("|-1-|-2-|-3-|row|");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("| " + arr[i][j] + " ");
                if (j == 2) {
                    System.out.print("|-" + (char) (i + 65) + "-|");
                }
            }
            System.out.println();
        }
        System.out.println("|---|---|---|---|");
        System.out.println();
    }

    public static int[] playerMove () throws IOException {
        String move;
        int[] arrOut = new int[2];

        System.out.println("Please provide the position you want to place your symbol");

        move = in.next();

        switch (move.charAt(0)) {
            case 'A':
                arrOut[0] = 0;
                break;
            case 'B':
                arrOut[0] = 1;
                break;
            case 'C':
                arrOut[0] = 2;
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        switch (move.charAt(1)) {
            case '1':
                arrOut[1] = 0;
                break;
            case '2':
                arrOut[1] = 1;
                break;
            case '3':
                arrOut[1] = 2;
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        return arrOut;
    }

    public static boolean checkIfWon (char[][] arr) {
        int[][] ints = getIntValues(arr);
        boolean wonTheGame = false;
        int[] sumVertical = {0, 0, 0};
        int sumHorizontal;

        //diagonal check
        if (ints[0][0] + ints[1][1] + ints[2][2] == 264 || ints[0][0] + ints[1][1] + arr[2][2] == 237)
            wonTheGame = true;
        if (ints[0][2] + ints[1][1] + ints[2][0] == 264 || ints[0][2] + ints[1][1] + ints[2][0] == 237)
            wonTheGame = true;

        for (int i = 0; i < ints.length; i++) {
            //vertical check
            sumVertical[0] += ints[i][0];
            sumVertical[1] += ints[i][1];
            sumVertical[2] += ints[i][2];

            sumHorizontal = 0;
            for (int j = 0; j < ints[i].length; j++) {

                //horizontal check
                sumHorizontal += ints[i][j];
            }

            if (sumHorizontal == 264 || sumHorizontal == 237) {
                wonTheGame = true;
                break;
            }
        }

        if (sumVertical[0] == 264 || sumVertical[0] == 237 || sumVertical[1] == 264 || sumVertical[1] == 237 || sumVertical[2] == 264 || sumVertical[2] == 237)
            wonTheGame = true;

        return wonTheGame;
    }

    public static int[][] getIntValues (char[][] arr) {
        int[][] arrOut = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arrOut[i][j] = (int) arr[i][j];
            }
        }
        return arrOut;
    }

    public static int[] checkInput (char[][] board, int[] move) throws IOException {
        do {
            if (board[move[0]][move[1]] == 'O' || board[move[0]][move[1]] == 'X') {
                System.out.println("This position has been filed");
                move = playerMove();
            } else {
                break;
            }
        } while (true);

        return move;
    }

}