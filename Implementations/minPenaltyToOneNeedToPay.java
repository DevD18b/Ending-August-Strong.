package Implementations;

public class minPenaltyToOneNeedToPay {
    public static void main(String[] args) {

    }

    public int bestClosingTime(String customer) {

        int minPenalty = Integer.MIN_VALUE;
        int minHours = Integer.MAX_VALUE;

        for (int i = 0; i < customer.length(); i++) {
            int penalty = 0;
            for (int j = i - 1; j >= 0; j--) {
                char ch = customer.charAt(j);
                if (ch == 'N') {
                    penalty++;
                }
            }
            for (int j = i; j < customer.length(); j++) {
                char ch = customer.charAt(j);
                if (ch == 'Y') {
                    penalty++;
                }
            }
            if (penalty < minPenalty) {
                minPenalty = penalty;
                minHours = i;
            }
        }
        int countCustomers = 0;
        for (int i = 0; i < customer.length(); i++) {
            if (customer.charAt(i) == 'N') {
                countCustomers++;
            }
        }
        if (minPenalty > countCustomers) {
            minHours = customer.length();
        }
        return minHours;
    }

    // better approach.

    // since in every iteration what are we doing is we are just maintaining the
    // count of
    // N for open state and count of Y for the close state.

    public static int optimized(String str) {
        int n = str.length();
        int[] preffix_n = new int[n + 1];
        int[] suffix_y = new int[n + 1];

        preffix_n[0] = 0;
        suffix_y[n] = 0;

        for (int i = 1; i <= n; i++) {
            if (str.charAt(i - 1) == 'N') {
                preffix_n[i] = 1 + preffix_n[i - 1];
            } else {
                preffix_n[i] = preffix_n[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'Y') {
                suffix_y[i] = 1 + suffix_y[i + 1];
            } else {
                suffix_y[i] = suffix_y[i - 1];
            }
        }

        int minPenalty = Integer.MAX_VALUE;
        int minHours = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int currentPenalty = suffix_y[i] + preffix_n[i];
            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                minHours = i;
            }
        }
        return minHours;
    }

}
