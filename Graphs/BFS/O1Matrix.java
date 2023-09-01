package Graphs.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class O1Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] steps = new int[mat.length][mat[0].length];
        for (int[] arr : steps) {
            Arrays.fill(arr, -1);
        }
        Queue<pair> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    steps[i][j] = 0;
                    queue.offer(new pair(i, j));
                }
            }
        }
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            for (int[] arr : directions) {
                int newRow = row + arr[0];
                int newCol = col + arr[1];
                if (newRow >= 0 && newCol >= 0 && newRow < mat.length && newCol < mat[0].length
                        && steps[newRow][newCol] == -1) {
                    steps[newRow][newCol] = steps[row][col] + 1;
                    queue.offer(new pair(newRow, newCol));
                }
            }
        }
        return steps;
    }
}

class pair {
    int row;
    int col;

    pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
