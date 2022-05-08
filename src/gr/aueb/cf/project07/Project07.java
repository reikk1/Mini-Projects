package gr.aueb.cf.project07;

import java.util.Arrays;

public class Project07 {

    public static void main(String[] args) {
        int[][] arr1 = {
                        {1, 2, 3},
                        {4, 6, 9},
                        {6, 2, 0}
        };
        int[][] arr2;
        int[][] arr3;

        //deep copy
        System.out.println("Deep copy demo");
        System.out.println();
        arr3 = deepCopy(arr1);

        arr3[0][0] = 5;
        arr3[0][1] = 7;
        arr3[0][2] = 0;

        System.out.print("Original array:");
        printArr(arr1);
        System.out.println();
        System.out.print("Deep copied array:");
        printArr(arr3);
        System.out.println();
        System.out.println("Original remained the same");

        System.out.println();

        //shallow copy
        System.out.println("Shallow copy demo");
        System.out.println();
        arr2 = shallowCopy(arr1);

        arr2[0][0] = 15;
        arr2[0][1] = 20;
        arr2[0][2] = 34;

        System.out.print("Original array:");
        printArr(arr1);
        System.out.println();
        System.out.print("Shallow copied array:");
        printArr(arr2);
        System.out.println();
        System.out.println("Original changed per shallow copied changes");

    }

    public static int[][] shallowCopy (int[][] arr) {
        int[][] copy = null;

        for (int i = 0; i < arr.length; i++) {
            copy = Arrays.copyOf(arr, arr[i].length);
        }
        return copy;
    }

    public static int[][] deepCopy (int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    public static void printArr (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();
    }
}
