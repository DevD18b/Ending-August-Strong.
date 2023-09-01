import java.util.*;

public class frogJump {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int n;
    static int[][] dp = new int[2001][2001];

    public static boolean frogJumpProble(int[] stones) {

        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solver(0, 0, stones);
    }

    public static boolean solver(int prevIndexJump, int currentIndexJump, int[] stones) {

        if (currentIndexJump == stones.length - 1) {
            return true;
        }
        boolean result = false;
        for (int nextJump = prevIndexJump - 1; nextJump <= prevIndexJump + 1; nextJump++) {
            if (nextJump > 0) {
                int nextStones = stones[currentIndexJump] + nextJump;
                if (map.containsKey(nextStones)) {
                    result |= solver(nextJump, map.get(nextStones), stones);
                }
            }
        }
        return result;
    }
}
