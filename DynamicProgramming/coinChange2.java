public class coinChange2 {

    // what i know is i have infinite supply of coins.

    public static int solver(int index, int[] arr, int target) {

        if (target == 0) {
            return 1;
        }
        if (index >= arr.length) {
            return 0;
        }
        if (target < arr[index]) {
            return solver(index + 1, arr, target);
        }

        int notTake = solver(index + 1, arr, target);

        int take = 1 + solver(index, arr, target - arr[index]);

        return take + notTake;

    }

}
