
import static org.junit.Assert.assertEquals;

import org.junit.*;
public class sumTest {

    @Test
    public void testNoPairs() {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 10;
        int result = sum.findPairs(numbers, target);
        assertEquals(0, result);
    }

    @Test
    public void testOnePair() {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 6;
        int result = sum.findPairs(numbers, target);
        assertEquals(2, result);
    }

    @Test
    public void testMultiplePairs() {
        int[] numbers = {1, 2, 3, 4, 5, 2};
        int target = 5;
        int result = sum.findPairs(numbers, target);
        assertEquals(3, result);
    }

    @Test
    public void testNegativeNumbers() {
        int[] numbers = {-1, -2, 3, 4, 5};
        int target = 3;
        int result = sum.findPairs(numbers, target);
        assertEquals(2, result);
    }

    @Test
    public void testAllPairsAreZeros() {
        int[] numbers = {0, 0, 0, 0};
        int target = 0;
        int result = sum.findPairs(numbers, target);
        assertEquals(6, result);
    }

    @Test
    public void testNegativeAndPositiveNumbers() {
        int[] numbers = {-2, 1, 3, -4, 2};
        int target = -1;
        int result = sum.findPairs(numbers, target);
        assertEquals(2, result);
    }

    @Test
    public void testPairsWithDuplicates() {
        int[] numbers = {2, 2, 3, 3, 4};
        int target = 6;
        int result = sum.findPairs(numbers, target);
        assertEquals(3, result);
    }

    @Test
    public void testEmptyList() {
        int[] numbers = {};
        int target = 5;
        int result = sum.findPairs(numbers, target);
        assertEquals(0, result);
    }

}
