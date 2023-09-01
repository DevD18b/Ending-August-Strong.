package Greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class findKthLargest {
    public static int solver(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : arr) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();

    }

}
