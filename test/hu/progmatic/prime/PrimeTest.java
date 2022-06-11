package hu.progmatic.prime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void isPrimeTest() {

        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertTrue(Prime.isPrime(29));
        assertFalse(Prime.isPrime(1));
        assertFalse(Prime.isPrime(-1));
        assertFalse(Prime.isPrime(0));
        assertTrue(Prime.isPrime(Integer.MAX_VALUE));

        // HIBAS
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(9));
        assertFalse(Prime.isPrime(25));
        assertFalse(Prime.isPrime(49));



    }
}