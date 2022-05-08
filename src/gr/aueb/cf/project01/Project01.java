package gr.aueb.cf.project01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Project01 {

    public static void main(String[] args) throws IOException {
        File inFile = new File("C:/Users/reyke/OneDrive/Desktop/Reskilling/Coding Factory/Java/1. pre-Easter (week 1-6)/Week 6/Mini projects - Easter - Rei Kerma/txts/project01-input-numbers.txt");
        File middleFile = new File("C:/Users/reyke/OneDrive/Desktop/Reskilling/Coding Factory/Java/1. pre-Easter (week 1-6)/Week 6/Mini projects - Easter - Rei Kerma/txts/project01-middle-numbers.txt");
        File outFile = new File ("C:/Users/reyke/OneDrive/Desktop/Reskilling/Coding Factory/Java/1. pre-Easter (week 1-6)/Week 6/Mini projects - Easter - Rei Kerma/txts/project01-output-numbers.txt");

        Scanner in = new Scanner(inFile);
        BufferedReader br = new BufferedReader(new FileReader(middleFile));
        PrintStream psMiddle = new PrintStream(middleFile);
        PrintStream psOut = new PrintStream(outFile);

        String line;
        ArrayList<Integer> numbers = new ArrayList<>();

        int n = 6;
        int token;
        int countCombinations = 0;
        int arrLine = 0;

        do{
            token = in.nextInt();
            if (token == -1) break;
            numbers.add(token);
        } while (true);

        System.out.println(numbers);

        //bubble sort the ArrayList
        sortArrL(numbers);

        System.out.println(numbers);

        for (int i = 0; i <= numbers.size() - n; i++) {
            for (int j = i + 1; j <= numbers.size() - n + 1; j++) {
                for (int k = j + 1; k <= numbers.size() - n + 2; k++) {
                    for (int l = k + 1; l <= numbers.size() - n + 3; l++) {
                        for (int m = l + 1; m <= numbers.size() - n + 4; m++) {
                            for (int o = m + 1; o < numbers.size(); o++) {
                                psMiddle.printf("%d %d %d %d %d %d\n", numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(l), numbers.get(m), numbers.get(o));
                                countCombinations++;
                            }
                        }
                    }
                }
            }
        }

        //initializing the new table that we are going to work with
        int[][] combinations = new int[countCombinations][n];

        while ((line = br.readLine()) != null) {
            String[] str = line.split(" ");

            for (int i = 0; i < n; i++) {
                combinations[arrLine][i] = Integer.parseInt(str[i]);
            }

            arrLine++;
        }

        for (int i = 0; i < combinations.length; i++) {

            if ((isEven(combinations, i)) && (isOdd(combinations, i)) && (isContiguous(combinations, i)) &&
                    (isSameEnding(combinations, i)) && (isSameTen(combinations, i))) {
                psOut.print(Arrays.toString(combinations[i]) + "\n");
            }

        }

    }


    public static void sortArrL (ArrayList arr) {
        int temp = 0;
        for (int i = arr.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if ((int) arr.get(j) > (int) arr.get(j + 1)) {
                    temp = (int) arr.get(j);
                    arr.set(j, (int) arr.get(j  +1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    public static boolean isEven (int[][] arr, int row) {
        int count = 0;

        for (int i = 0; i < arr[row].length; i++) {
            if (arr[row][i] % 2 == 0) {
                count++;
            }
        }

        if (count > 4) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isOdd (int[][] arr, int row) {
        int count = 0;

        for (int i = 0; i < arr[row].length; i++) {
            if (arr[row][i] % 2 != 0) {
                count++;
            }
        }

        if (count > 4) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isContiguous (int[][] arr, int row) {
        int count = 0;

        for (int i = 0; i < arr[row].length - 1; i++) {
            if (arr[row][i] == arr[row][i + 1]) {
                count++;
            }
        }

        if (count > 2) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isSameEnding (int[][] arr, int row) {
        int count = 0;

        for (int i = arr[row].length - 1; i > 1 ; i--) {
            if (arr[row][i] == arr[row][i - 1]) {
                count++;
            }
        }

        if (count > 3) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isSameTen (int[][] arr, int row) {
        int count = 0;

        for (int i = 0; i < arr[row].length - 1; i++) {
            if ((arr[row][i] / 10) != 0) {
                if ((arr[row][i] / 10) == (arr[row][i + 1] / 10)) {
                    count++;
                }
            }
        }

        if (count > 3) {
            return false;
        } else {
            return true;
        }
    }

}