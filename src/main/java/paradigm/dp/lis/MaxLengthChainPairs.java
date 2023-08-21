package paradigm.dp.lis;

import java.util.Arrays;

public class MaxLengthChainPairs {

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        int max = 1;



        return max;
    }
}
