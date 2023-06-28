import org.junit.Assert;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class PrimeCheckTest {

  private int[] primes;
  private int[] nonPrimes;

  @BeforeClass
  public void init() {
    primes = Arrays.stream(Files.readString(Path.of("primes.txt")).split("\n")).mapToInt(e -> Integer.parseInt(e)).toArray();
    nonPrimes = IntStream.range(0, 20000).filter(e -> IntStream.of(primes).anyMatch(f -> f == e)).toArray();
  }

  // --------------------------------------------------------------- //
  @Test
  public void TestNegativeNumbers() {
    for (int i = -10; i < 0; ++i) {
      assertEquals("Test negative number " + i, false, PrimeCheck.isPrime(i));
    }
  }

  // --------------------------------------------------------------- //
  @Test
  public void TestEdgeCases() {
    assertEquals("Test 0", false, PrimeCheck.isPrime(0));
    assertEquals("Test 1", false, PrimeCheck.isPrime(1));
    assertEquals("Test 2", true, PrimeCheck.isPrime(2));
  }

  // --------------------------------------------------------------- //
  @Test
  public void testPrimes() {
    for (int i : primes) {
      assertEquals(true, PrimeCheck.isPrime(i))
    }
  }

  // --------------------------------------------------------------- //
  @Test
  public void testNonPrimes() {
    /* ToDo: insert a test here */
    for (int i : nonPrimes) {
      assertEquals(false, PrimeCheck.isPrime(i))
    }  }
}
