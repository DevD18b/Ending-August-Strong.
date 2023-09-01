import java.util.*;

public class minimumNumberOfTapsToOpenToWaterTheGarden {
    static int gardenTerminatingPoint;

    public static int minimumTaps(int[] ranges, int n) {
        gardenTerminatingPoint = n;
        ArrayList<Pairs> rangeSet = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(i - ranges[i], 0);
            int end = Math.min(i + ranges[i], n);
            rangeSet.add(new Pairs(start, end));
        }
        Collections.sort(rangeSet, (a, b) -> Integer.compare(a.end, b.end));

        return solver(0, 0, rangeSet);
    }

    public static int tabulation(int[] ranges, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            // In the inner loop, we check if we
            // can use less number of taps. For example,
            // in order to water garden [0..j]
            // , I can first water garden [0..l]
            // then use another tap to water
            // [l+1..j][l + 1 .. j][l+1..j].
            // In this case, that would be dp[l]+1
            // Or we can just fill water
            // directly by using dp[j] taps.
            // We have two cases. Just take the min one.

            for (int j = left; j <= right; j++) {
                // we need minimum number of taps to fill
                // water in range from left to right.
                // toh yaa toh meh dp[j] taps use kr keh garden ko water kr sakta hoon.
                // yaa toh one by one
                // first left half fill kar dunga and then
                // and then left+1 seh j tk fill karunga.

                dp[j] = Math.min(dp[j], dp[left] + 1);
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];

    }

    public static int solver(int index, int maxEnd, ArrayList<Pairs> range) {
        if (index >= range.size()) {
            if (maxEnd >= gardenTerminatingPoint) {
                return 0;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        Pairs p = range.get(index);
        if (p.start > maxEnd) {
            return Integer.MAX_VALUE;
        }

        int take = 1 + solver(index + 1, Math.max(maxEnd, p.end), range);
        int notTake = 0 + solver(index + 1, maxEnd, range);

        return Math.min(take, notTake);
    }

}

class Pairs {
    int start;
    int end;

    Pairs(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
