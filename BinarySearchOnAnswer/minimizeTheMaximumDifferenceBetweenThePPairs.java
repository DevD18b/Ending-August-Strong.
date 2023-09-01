package BinarySearchOnAnswer;

import java.util.Arrays;

public class minimizeTheMaximumDifferenceBetweenThePPairs {

    public static int solver(int[] arr, int p) {
        Arrays.sort(arr);
        int left = 0;
        int ans = Integer.MAX_VALUE;
        // the upper bond on the difference can be
        // last element - first element.
        int right = arr[arr.length - 1] - arr[0];
        while (left <= right) {
            int mid = (left + right) << 1;
            if (pPairsExist(arr, mid, p)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static boolean pPairsExist(int[] arr, int target, int pairs) {
        int count = 0;
        int i = 0;
        int n = arr.length;
        while (i < n - 1) {
            if (Math.abs(arr[i] - arr[i + 1]) <= target) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count >= pairs;
    }
}
