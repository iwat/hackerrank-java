package misc.prime;

import java.util.*;

public class Solution {
    int primeAt(int n) {
        List<Integer> primes = new ArrayList();
        primes.add(2);
        primes.add(3);

        int i = 5;
        while (primes.size() < n) {
            boolean matched = true;
            for (int prime : primes) {
                if (prime*prime > i) {
                    break;
                }
                if (i%prime == 0) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                primes.add(i);
            }
            matched = true;
            for (int prime : primes) {
                if (prime*prime > i+2) {
                    break;
                }
                if ((i+2)%prime == 0) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                primes.add(i+2);
            }

            i += 6;
        }
        return primes.get(n - 1);
    }

    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n%2 == 0 || n%3 == 0) {
            return false;
        }
        for (int i = 5; i*i <= n; i += 6) {
            if (n%i == 0 || n%(i+2) == 0) {
                return false;
            }
        }
        return true;
    }
}
