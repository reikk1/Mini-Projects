package gr.aueb.cf.project10;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Project10 {

    static int asciiValueOfAUpper = 65;
    static int asciiValueOfALower = 97;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean[][] theatre = new boolean[30][12];
        char col;
        int row;

        fillArr(theatre);

        //Book a seat
        System.out.println("Please provide the seat you want to book");
        System.out.println("First provide the col");
        col = (char) System.in.read();
        System.out.println("Now provide the row");
        row = in.nextInt();

        book(col, row, theatre);

        System.out.println();

        //cancel a seat
        System.out.println("Please provide the seat you want to cancel");
        System.out.println("First provide the col");
        col = (char) System.in.read();
        System.out.println("Now provide the row");
        row = in.nextInt();

        cancel(col, row, theatre);
    }

    public static void fillArr (boolean[][] arr) {
        for (boolean[] item : arr) Arrays.fill(item, false);
    }

    public static void book (char column, int row, boolean[][] arr) {
        boolean isFull = checkIfFull(arr);

        if (!isFull) {
            if (!arr[row][(int) column - columnValue(column)]) {
                arr[row][(int) column - columnValue(column)] = true;
                System.out.printf("Seat %c%d successfully booked", column, row);
            } else {
                System.out.println("This seat is already booked");
            }
        } else {
            System.out.println("Theater is full, you cannot book a seat");
        }
    }

    public static void cancel (char column, int row, boolean[][] arr) {
        if (arr[row][(int) column - columnValue(column)]) {
            arr[row][(int) column - columnValue(column)] = false;
            System.out.printf("Your booking of seat %c%d successfully cancelled", column, row);
        } else {
            System.out.println("This seat is not booked, so it cannot be cancelled");
        }
    }

    public static boolean checkIfFull (boolean[][] arr) {
        int trueCount = 0, itemsCount = 0;
        boolean isFull = true;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                itemsCount++;
                if (arr[i][j]) trueCount++;
            }
        }

        if (trueCount == itemsCount) {
            return isFull;
        } else {
            return !isFull;
        }
    }

    public static int columnValue (char column) {
        if ((int) column >= 65 && (int) column <= 76) {
            return asciiValueOfAUpper;
        } else if ((int) column >= 97 && (int) column <= 108) {
            return asciiValueOfALower;
        } else {
            System.out.println("Invalid seat");
            return -1;
        }
    }
}
