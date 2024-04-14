public class FactorialCalculator {

    public static int calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал числа может быть определен только для положительных чисел.");
        }
        if (n == 0) {
            return 1;
        }
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

