package jayden.learn.cases;

public class Factorial {

    public static int recursiveFactorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * recursiveFactorial(--number);
    }

    public static int iterativeFactorial(int number) {
        int result = 1;
        while (number > 0) {
            result *= number;
            number -= 1;
        }
        return result;
    }
}
