package gr.aueb.cf.project04;

import java.util.Scanner;

public class Project04 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] originalArr = new int[5][2];
        int[][] convertedArr;
        int max;

        insertData(originalArr);
        System.out.println("Your array is the following: ");
        printArr(originalArr);

        convertedArr = convertArr(originalArr);
//        printArr(convertedArr);

        sortArr(convertedArr);
//        printArr(convertedArr);

        max = getCount(convertedArr);
        System.out.printf("There are %d cars in the parking lot at the same time", max);
    }

    public static void insertData (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
                System.out.printf("Please provide the time the car #%d came and left", i+1);
                System.out.println();
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }
        // Leaving the below data in case you want to test the program with these directly
//        arr[0][0] = 1012;
//        arr[0][1] = 1136;
//        arr[1][0] = 1317;
//        arr[1][1] = 1417;
//        arr[2][0] = 1015;
//        arr[2][1] = 1020;
    }

    public static void printArr (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] convertArr (int[][] arr) {
        int[][] arrOut = new int[arr.length * 2][2];

        for (int i = 0; i < arr.length; i++) {
            arrOut[i][0] = arr[i][0];
            arrOut[i][1] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            arrOut[i + arr.length][0] = arr[i][1];
            arrOut[i + arr.length][1] = 0;
        }
        return arrOut;
    }

    public static void sortArr (int[][] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1][0] < arr[j][0]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void swap (int[][] arr,int i, int j) {
        int temp1 = arr[i][0];
        arr[i][0] = arr[j][0];
        arr[j][0] = temp1;

        int temp2 = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = temp2;
    }

    public static int getCount (int[][] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] == 1) {
                count++;
            } else break;
        }
        return count;
    }
}
