public class InterLeavingString {

    public static boolean driver(String str1, String str2, String str3) {

        boolean[][][] dp = new boolean[101][101][101];

        if (str1.length() + str2.length() != str3.length())
            return false;

        return solver(0, 0, 0, str1, str2, str3, dp);
    }

    public static boolean solver(int i, int j, int k, String str1, String str2, String str3, boolean[][][] dp) {

        if (i == str1.length() && j == str2.length() && k == str3.length()) {
            return true;
        }

        if (k >= str3.length()) {
            return false;
        }
        if (dp[i][j][k] != false)
            return dp[i][j][k];

        boolean result = false;
        if (str1.charAt(i) == str3.charAt(j)) {
            result = solver(i + 1, j, k + 1, str1, str2, str3, dp);
            if (result) {
                return true;
            }
        } else if (str2.charAt(j) == str3.charAt(k)) {
            result = solver(i, j + 1, k + 1, str1, str2, str3, dp);
        }
        dp[i][j][k] = result;

        return result;
    }

    public static boolean tabulation(String str1, String str2, String str3) {
        if (str1.length() + str2.length() != str3.length())
            return false;

        boolean[][] dp = new boolean[str1.length() + 1][str2.length() + 1];

        dp[str1.length()][str2.length() - 1] = true;

        for (int i = str1.length() - 1; i >= 0; i++) {
            for (int j = str2.length() - 1; j >= 0; j++) {

                int k = i + j;
                if (i < str1.length() && str1.charAt(i) == str3.charAt(k)) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (j < str2.length() && str2.charAt(j) == str3.charAt(k)) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[str1.length()][str2.length()];

    }

    public static boolean usingTwoPointer(int i, int j, String str1, String str2, String str3) {

        if (i == str1.length() && j == str2.length() && i + j == str3.length()) {
            return true;
        }
        if ((i + j) >= str3.length()) {
            return false;
        }

        boolean result = false;

        if (i < str1.length() && str1.charAt(i) == str3.charAt(i + j)) {
            result = usingTwoPointer(i + 1, j, str1, str2, str3);
        }
        if (j < str2.length() && str2.charAt(j) == str3.charAt(i + j)) {
            result = usingTwoPointer(i, j + 1, str1, str2, str3);
        }
        return result;
    }

}
