package paradigm.problem.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by mg on 9/4/2023.
 */
public class SieveOfEratosthenesTest {

    private SieveOfEratosthenes sieve;

    @BeforeEach
    public void setUp() {
        sieve = new SieveOfEratosthenes();
    }

    @Test
    public void sieveOfEratosthenesTest() {

        sieve.sieveOfEratosthenes(100);
        boolean[] result = sieve.getPrime();

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < result.length; i++) {
            if (result[i]) {
                primes.add(i);
            }
        }

        int[] solution = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
        List<Integer> expected = Arrays.stream(solution).boxed().toList();

        assertEquals(expected, primes);
    }
}
