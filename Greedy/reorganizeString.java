package Greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class reorganizeString {

    public static String solve(String str) {
        StringBuilder ans = new StringBuilder();
        int n = str.length();
        int limiting = (int) Math.ceil((n + 1) / 2);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) > limiting) {
                return " ";
            }

        }

        PriorityQueue<Character> mpq = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        mpq.addAll(map.keySet());

        // hum kyaa krenge
        // high frequency elements ko
        // Priority queue meh character wise arrange krenge...
        // just because at the end
        // what we want is character non adjacent ho
        // and so forth hum ek aise data structure ko search krte chalte hai fir jis seh
        // kiii yrr
        // hume humesha high frequency element hii mile and we can easily handle them
        // also.
        // har baar unko pop karke hum kyaa karenge ki unki frequency ko map seh
        // decrease krte jayenge.
        // and after decreasing
        // what can we do is ki agar unka count jyaada hai
        // toh i will be keep adding them to the priority queue.

        while (mpq.size() >= 2) {
            char x = mpq.remove();
            char y = mpq.remove();
            ans.append(x);
            ans.append(y);
            map.put(x, map.get(x) - 1);
            map.put(y, map.get(y) - 1);

            if (map.get(x) > 0) {
                mpq.offer(x);
            }
            if (map.get(y) > 0) {
                mpq.offer(y);
            }
        }
        if (mpq.isEmpty() == false) {
            char last = mpq.poll();
            if (map.get(last) > 1)
                return " ";
            ans.append(last);
        }
        return ans.toString();

    }
}
