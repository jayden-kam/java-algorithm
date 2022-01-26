package jayden.learn.cases;

import java.util.Map;

public class Fibonacci {

    public static long fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static long fibMemo(int n, Map<Integer, Long> map) {
        if (n <= 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long result = fibMemo(n - 1, map) + fibMemo(n - 2, map);
            map.put(n, result);
            return result;
        }
    }
}
