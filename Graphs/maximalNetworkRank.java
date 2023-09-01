package Graphs;

import java.util.ArrayList;

public class maximalNetworkRank {
    public int maximalNetworkRankProblem(int n, int[][] roads) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int[] arr : roads) {
            int u = arr[0];
            int v = arr[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int maximalRank = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int edge1 = adjList.get(i).size();
                int edge2 = adjList.get(j).size();
                int sum = edge1 + edge2;
                if (adjList.get(i).contains(j) || adjList.get(j).contains(i)) {
                    sum -= 1;
                }
                maximalRank = Math.max(maximalRank, sum);
            }
        }
        return maximalRank;
    }
}
