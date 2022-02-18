package jayden.learn.cases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    A prime number is a positive number with no divisors but 1 and itself. 2, 3, 11, and 443 are all prime numbers.
 */
public class SieveOfEratosthenes {

    /*
        1. Create an array of all integers from 2 to n
        2. Set all elements of the array to true
        3. Starting with 2, iterate through the array.
            If the current element is true, it is still considered prime.
            Since we know that all multiples of that number are NOT prime,
                iterate through all multiples of that number up to n and set them equal to false
        4. Change the current element to the next non-false index.
        5. Return the corresponding number value for any element still marked as prime (value of true).
     */
    public static void solution(int limit) {
        boolean[] array = new boolean[limit + 1];
        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;
        for (int i = 2; i <= limit; i++) {
            if (array[i]) {
                for (int j = i * 2; j <= limit; j = j + i) {
                    array[j] = false;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                list.add(i);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    /*
        1. End Boundary
            Because the inner loop marks multiples of a base value,
            we only need to check individual numbers lower than the square root of n.

        2. First Multiple
            The inner loop started checking multiples at 2 times the current number.
            We can skip a few checks starting the checks at current^2.

     */
    public static void optimizeSolution(int limit) {
        boolean[] array = new boolean[limit + 1];
        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;
        for (int i = 2; i <= Math.pow(limit, 0.5); i++) {
            if (array[i]) {
                for (int j = (int) Math.pow(i, 2); j <= limit; j = j + i) {
                    array[j] = false;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                list.add(i);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}
