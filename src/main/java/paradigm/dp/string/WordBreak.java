package paradigm.dp.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public WordBreak() { }

    public boolean wordBreak(String word, List<String> dictionary) {

        Set<String> dict = new HashSet<>(dictionary);
        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;

        for (int end = 1; end <= word.length(); ++end) {
            for (int begin = 0; begin < end; ++begin) {
                String test = word.substring(begin, end);
                if (dp[begin] && dict.contains(test)) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[word.length()];
    }

    public static void main(String[] args) {

        WordBreak wb = new WordBreak();
        boolean result = wb.wordBreak("leetcode", Arrays.asList("leet", "code"));

        System.out.println(result);
    }
}
