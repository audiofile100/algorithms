package paradigm.dp.string;

import lombok.Getter;

@Getter
public class LongestPalindromicSubsequence {

    private int[][] memo;

    public LongestPalindromicSubsequence() { }

    public int longestPalindromicSubsequence(String s) {

        memo = new int[s.length()][s.length()];

        return recurse(s, 0, s.length()-1, memo);
    }

    private int recurse(String s, int i, int j, int[][] memo) {
        if (memo[i][j] > 0) return memo[i][j];
        if (i > j) return 0;
        if (i == j) return 1;

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = recurse(s, i+1, j-1, memo) + 2;
        } else {
            memo[i][j] = Math.max(recurse(s, i+1, j, memo), recurse(s, i, j-1, memo));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {

        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.longestPalindromicSubsequence("aacaa"));
    }
}
