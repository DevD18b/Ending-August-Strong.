public class UniqueBinarySearch2 {

    public static boolean isSafe(int row, int col, int[][] grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid.length;
    }

    public static int solver(int row, int col, int[][] grid) {

        if (row > grid.length || col > grid.length) {
            return 0;
        }

        if (isSafe(row, col, grid) && grid[row][col] == 1) {
            return 0;
        }

        if (row > grid.length) {
            return solver(row, col + 1, grid);
        }
        if (col > grid[0].length) {
            return solver(row + 1, col, grid);
        }

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        int bottom = solver(row + 1, col, grid);
        int right = solver(row, col + 1, grid);

        return bottom + right;

    }

    public static int numberOfWaysToReachTarget(int[][] arr) {

        return solver(0, 0, arr);
    }

    public static int tabulation(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid.length - 1; j >= 0; j--) {

                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                }

                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }

                int right = dp[i][j + 1];
                int bottom = dp[i + 1][j];

                dp[i][j] = right + bottom;

            }
        }
        return dp[0][0];

    }
}
