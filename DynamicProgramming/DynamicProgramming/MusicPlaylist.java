
package DynamicProgramming;

import java.util.*;

public class MusicPlaylist {

    public static int possibleSongsToPlay(int n, int goal, int k) {
        int[][] dp = new int[goal + 1][n + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return solver(0, 0, n, goal, k, dp);
    }

    public static int solver(int count_song, int count_unique, int n, int goal, int k, int[][] dp) {

        if (count_song == goal) {
            if (count_unique == n) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[count_song][count_unique] != -1)
            return dp[count_song][count_unique];

        // at every point i have 2 options to discover.

        // option number 1 ki meh ek unique song play karu.
        // i have n number songs and aur meh current ek unique song soon liye
        // toh abhi mathematically i have n-1 song to play.
        int playingUniqueSong = (n - count_unique) * solver(count_song + 1, count_unique + 1, n, goal, k, dp);

        // now lets discover other option..
        // that i can either replay a song..
        // since i am replaying so no unique increases.
        // but i can increase the song count as i am playing it
        // aur mujhe goal number of songs play krna hai

        // ab we have a condition from a question that we can replay a song after
        // playing k different songs
        // n = 3 k = 2

        // for n = 3 i have songs let say A , B , C and goal is 5
        // i have a only n songs and i need to repeat now.
        // but according to the question i can current song only
        // after playing k unique ones. lets say k = 2. so now i can play A.
        // so A , B , C , A,B,C.
        // lets take anather case where my k = 1.
        // A , B , C , for next perticular repeatation i have 2 ways A , B
        // there is a little bit of maths if i do n-k=x...
        // this x will give me number of possible songs
        // that i can replay at current situation.

        int replayASong = (count_unique - k) * solver(count_song + 1, count_unique, n, k, goal, dp);

        return dp[count_song][count_unique] = replayASong + playingUniqueSong;

    }

}
