import java.util.*;

public class checkIfThereIsValidPartitionOfArray {

    public static boolean solver(int index, int[] arr) {
        if (index >= arr.length)
            return true;

        boolean result = false;

        if (arr[index] == arr[index + 1]) {
            result = solver(index + 1, arr);
        }

        if (result) {
            return true;
        }

        if (arr[index] == arr[index + 1] && arr[index + 1] == arr[index + 2]) {
            result = solver(index + 3, arr);
        }
        if (result == true) {
            return true;
        }

        if ((Math.abs(arr[index] - arr[index + 1]) == 1) && (Math.abs(arr[index + 2] - arr[index + 1]) == 1)) {
            result = solver(index + 3, arr);
        }
        return true;
    }

    public static boolean tabulation(int[] arr) {

        boolean[] dp = new boolean[arr.length + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        int n = arr.length;
        for (int i = 2; i <= n; i++) {
            boolean result = false;
            if (arr[i - 1] == arr[i - 2]) {
                result |= dp[i - 3];
            }
            if (result) {
                dp[i] = result;
            }
            if (i > 2 && arr[i - 1] == arr[i - 2] && arr[i - 2] == arr[i - 3]) {
                result |= dp[i - 3];
            }
            if (result) {
                dp[i] = result;
            }
            if (i > 2 && Math.abs(arr[i - 1] - arr[i - 2]) == 1 && Math.abs(arr[i - 2] - arr[i - 3]) == 1) {
                result |= dp[i - 3];
            }
            dp[i] = result;
        }
        return dp[n];

    }

    // lets think of how to write the tail recursion for this problem
    public static boolean tailRec(int index, int[] arr) {

        if (index <= 0)
            return true;
        boolean result = false;
        if (arr[index] == arr[index - 1]) {
            result |= tailRec(index - 2, arr);
        }
        if (result) {
            return true;
        }

        if (arr[index] == arr[index - 1] && arr[index - 1] == arr[index - 2]) {
            result |= solver(index - 3, arr);
        }
        if (result)
            return true;

        if (Math.abs(arr[index] - arr[index - 1]) == 1 && Math.abs(arr[index - 2] - arr[index - 1]) == 1) {
            result |= solver(index - 3, arr);
        }
        return result;
    }

}