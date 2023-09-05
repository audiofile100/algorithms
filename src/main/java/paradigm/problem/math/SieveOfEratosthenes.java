package paradigm.problem.math;

import lombok.Getter;

import java.util.Arrays;

/**
 * Created by mg on 9/4/2023.
 */
@Getter
public class SieveOfEratosthenes {

    private boolean[] prime;

    public SieveOfEratosthenes() { }

    public void sieveOfEratosthenes(int n) {

        prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int p = 2; p < prime.length; p++) {
            if (prime[p] && p*p <= n) {
                for (int j = p*p; j < prime.length; j += p) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {

        SieveOfEratosthenes sieve = new SieveOfEratosthenes();
        sieve.sieveOfEratosthenes(100);
    }
}
