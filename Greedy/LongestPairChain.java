package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LongestPairChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] pairs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pairs[i][j] = sc.nextInt();
            }
        }

        // [[a,b],[c,d] ,[e,f]]
        // ab is case meh longest pair chain question meh
        // aise define kr rukha haii kiii
        // bhaii agar aap kisi doh interval ko consider kr rahe ho
        // (a,b) and (c,d).
        // b agar c seh chota hai toh usko consider kr loo and
        // and then kyaa kro further discover kroo c keh end points seh

        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] arr, int[] brr) {
                return Integer.compare(arr[1], brr[1]);
            }
        });

        int currentIntervalEndTime = pairs[0][1];

        int count = 1;
        for (int i = 1; i < n; i++) {
            if (currentIntervalEndTime < pairs[i][0]) {
                count++;
                currentIntervalEndTime = pairs[i][1];
            }
        }
        System.out.println(count);
        sc.close();
    }
}
