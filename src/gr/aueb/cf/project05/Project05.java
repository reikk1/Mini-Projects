package gr.aueb.cf.project05;

public class Project05 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 9};
        int[] index;

        index = getLowAndHighIndexOf(arr, 8);
        System.out.printf("Low index: %d & High index: %d", index[0], index[1]);
     }

    public static int[] getLowAndHighIndexOf (int[] arr, int key) {
        int[] arrOut = new int[2];
        int positionOfLow = -1;
        int positionOfHigh = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                positionOfLow = i;
                for (int j = positionOfLow + 1; j < arr.length; j++) {
                    if (arr[j] == arr[i]) count++;
                }
                positionOfHigh = positionOfLow + count;
                break;
            }
        }
        arrOut[0] = positionOfLow;
        arrOut[1] = positionOfHigh;
        return arrOut;
    }
}
