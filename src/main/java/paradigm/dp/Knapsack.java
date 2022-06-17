package paradigm.dp;

import java.util.HashSet;
import java.util.Set;

public class Knapsack {

    public void opt(int[] values, int[] sizes, int capacity) {
        assert values.length == sizes.length && values.length >= 1 && capacity > 0;

        int N = values.length + 1;
        int C = capacity + 1;

        int[][] dp = new int[N][C];

        for (int i = 1; i < N; i++) {
            for (int c = 0; c < C; c++) {
                int idx = i - 1;
                if (sizes[idx] > c) {
                    dp[i][c] = dp[idx][c];
                } else {
                    dp[i][c] = Math.max(dp[idx][c], dp[idx][c-sizes[idx]] + values[idx]);
                }
            }
        }

        print(dp);

        System.out.println("max value: " + dp[N-1][C-1]);

        int c = capacity;
        Set<Integer> set = new HashSet<>();
        for (int i = N-1; i > 0; i--) {
            int idx = i - 1;
            if (sizes[idx] <= c && dp[idx][c-sizes[idx]] + values[idx] >= dp[idx][c]) {
                set.add(i);
                c -= sizes[idx];
            }
        }

        System.out.println("choose items: " + set);
    }

    public void print(int[][] dp) {
        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] values = { 3, 2, 4, 4 };
        int[] sizes = { 4, 3, 2, 3 };

        Knapsack knapsack = new Knapsack();
        knapsack.opt(values, sizes, 6);
    }
}
