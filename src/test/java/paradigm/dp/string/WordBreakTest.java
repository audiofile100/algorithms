package paradigm.dp.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordBreakTest {

    private WordBreak wordBreak;

    @BeforeEach
    public void setUp() {
        wordBreak = new WordBreak();
    }

    @Test
    public void testValidWordBreak() {

        boolean result = wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"));

        assertTrue(result);
    }

    @Test
    public void testInvalidWordBreak() {

        boolean result = wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));

        assertFalse(result);
    }
}
