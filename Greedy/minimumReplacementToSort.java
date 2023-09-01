package Greedy;

public class minimumReplacementToSort {
    public static int minimumOperation(int[] arr) {
        int operation = 0;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                continue;
            }
            int parts = arr[i] / arr[i + 1];
            if (arr[i] % arr[i + 1] != 0) {
                parts++;
            }
            operation += parts;
            arr[i] /= parts;
        }
        return operation - 1;
    }

}
