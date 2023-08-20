package paradigm.dp.fib;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DeleteAndEarn {

    public int maxPoints(int[] nums) {

        Map<Integer, Integer> frequencyMap =
                Arrays.stream(nums).boxed().collect(
                        Collectors.toMap(Function.identity(), val -> 1, (oldVal, newVal) -> oldVal + 1)
                );

        Map<Integer, Integer> sumsMap =
                Arrays.stream(nums).boxed().collect(
                        Collectors.toMap(Function.identity(), Integer::intValue, Integer::sum)
                );

        int max = sumsMap.keySet().stream().max(Integer::compare).orElse(0);

        int[] dp = new int[max+1];
        dp[1] = sumsMap.getOrDefault(1, 0);

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i-2] + sumsMap.getOrDefault(i, 0), dp[i-1]);
        }

        return dp[max];
    }

    public static void main(String[] args) {

        DeleteAndEarn de = new DeleteAndEarn();
        int points = de.maxPoints(new int[] { 2 });

        System.out.println(points);
    }
}
