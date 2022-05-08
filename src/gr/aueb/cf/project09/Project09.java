package gr.aueb.cf.project09;

public class Project09 {

    static final int KEY = 3;

    public static void main(String[] args) {
        String code = "AUEB#";
        int[] ascValues = new int[code.length()];

        ascValues = strToAscValues(code);
        printArr(ascValues);

        encryptAsc(ascValues);
        printArr(ascValues);

//        decryptAsc(ascValues);
//        printArr(ascValues);

    }

    public static int[] strToAscValues (String s) {
        int[] arrOut = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arrOut[i] = (int) s.charAt(i);
        }
        return arrOut;
    }

    public static void encryptAsc (int[] arr) {
        int[] sums = new int[arr.length];

        for (int i = 1; i < sums.length; i++) {
            sums[i] = (arr[i] + arr[i - 1]);
        }
        sums[sums.length - 1] = -1;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = sums[i] % KEY;
        }
    }

    //couldn't make the decryption algorithm
    //not sure how to reverse the mod (%) operator
    //the way I am thinking of it is that in this example where we have 65 0 (A U)
    //we could have endless numbers that if we add to the 65 and get their mod will give us 0
    //obviously I am not getting something
    public static void decryptAsc (int[] arr) {

    }

    public static void printArr (int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
