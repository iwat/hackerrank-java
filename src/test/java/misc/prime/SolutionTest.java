package misc.prime;

import static org.junit.Assert.*;
import org.junit.*;

public class SolutionTest {
    @Test
    public void testPrimeNth() {
        Solution sol = new Solution();
        assertEquals(2, sol.primeAt(1));
        assertEquals(3, sol.primeAt(2));
        assertEquals(5, sol.primeAt(3));
        assertEquals(7, sol.primeAt(4));
        assertEquals(11, sol.primeAt(5));
        assertEquals(13, sol.primeAt(6));
        assertEquals(17, sol.primeAt(7));
        assertEquals(19, sol.primeAt(8));
        assertEquals(23, sol.primeAt(9));
        assertEquals(7919, sol.primeAt(1000));
        assertEquals(104729, sol.primeAt(10000));
        assertEquals(1299827, sol.primeAt(100008));
    }

    @Test
    public void testPrime() {
        Solution sol = new Solution();

        assertFalse(sol.isPrime(1));
        assertFalse(sol.isPrime(4));
        assertFalse(sol.isPrime(9));
        assertFalse(sol.isPrime(16));
        assertFalse(sol.isPrime(25));
        assertFalse(sol.isPrime(36));
        assertFalse(sol.isPrime(49));
        assertFalse(sol.isPrime(64));
        assertFalse(sol.isPrime(81));
        assertFalse(sol.isPrime(100));
        assertFalse(sol.isPrime(121));
        assertFalse(sol.isPrime(144));
        assertFalse(sol.isPrime(169));
        assertFalse(sol.isPrime(196));
        assertFalse(sol.isPrime(225));
        assertFalse(sol.isPrime(256));
        assertFalse(sol.isPrime(289));
        assertFalse(sol.isPrime(324));
        assertFalse(sol.isPrime(361));
        assertFalse(sol.isPrime(400));
        assertFalse(sol.isPrime(441));
        assertFalse(sol.isPrime(484));
        assertFalse(sol.isPrime(529));
        assertFalse(sol.isPrime(576));
        assertFalse(sol.isPrime(625));
        assertFalse(sol.isPrime(676));
        assertFalse(sol.isPrime(729));
        assertFalse(sol.isPrime(784));
        assertFalse(sol.isPrime(841));
    }
}
