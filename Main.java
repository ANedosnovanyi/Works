import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords(); // задание 1
        checkSumSign(); // задание 2
        printColor(); // задание 3
        compareNumbers(); // задание 4
        System.out.println("Результат задания 5: " + sumNumbers(8,6));
        System.out.println("Результат задания 6: ");
        nullNumbers(6);
        System.out.println("Результат задания 7: " + numberReset(-41));
        testArgs("Задание 8 выполнено!",8);
        final boolean b = leapYear(2001);
        System.out.println("Задание 9: " + b);
        printArray(dateArray); // задание 10
        for (int i = 0; i < dateArray.length; i++) {
        if (dateArray[i] == 0) {
            dateArray[i] = 1;
        } else if (dateArray[i] == 1) {
            dateArray[i] = 0;
        }
    }
        printArray(dateArray);
        changeArray(array);
        System.out.println("Задание 11: " + Arrays.toString(array));

        multiplyNumber(integerMultiplier);
        System.out.println("Задание 12: " + Arrays.toString(integerMultiplier));

        for (int i = 0; i < size; i++) {
            arrayDiagonal[i][i] = 1;
        }
        printDiagonalArray(arrayDiagonal); // задание 13

        int len = 15;
        int initialValue = 30;
        int[] resultArray = finishArray(len, initialValue);
        System.out.println("Задание 14: " + Arrays.toString(resultArray));
    }
    public static void printThreeWords() {
        // задание 1
        System.out.println("Orange");
        System.out.println("Apple");
        System.out.println("Banana");

    }
    public static void checkSumSign() {
        // задание 2
        int a = 8;
        int b = -30;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor() {
        // задание 3
        int value = 175;
        if (value < 0) {
            System.out.println("Красный");
        } else if (value >= 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers() {
        // задание 4
        int a = 150;
        int b = 17;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    public static boolean sumNumbers(int a, int b) {
        // задание 5
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    public static void nullNumbers(int number) {
        // задание 6
        if (number >= 0) {
            System.out.println(number + " - Это число является положительным.");
        } else {
            System.out.println(number + " - Это число является отрицательным.");
        }
    }
    public static boolean numberReset(int number) {
        // задание 7
        return number < 0;
    }
    public static void testArgs(String str, int count) {
        // задание 8
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }
    public static boolean leapYear(int year) {
        // задание 9
        if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
    public static int[] dateArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    public static void printArray(int[] arg) {
        // задание 10
        for (int num : arg) {
            System.out.print( num + " ");
        }
        System.out.println();
    }
    public static int[] array = new int[100];
    public static void changeArray(int[] arr) {
        // задание 11
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }
    public static int[] integerMultiplier ={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    public static void multiplyNumber(int[] arr) {
        // Задание 12
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }
    public static int size = 7;
    public static int[][] arrayDiagonal = new int[size][size];
    public static void printDiagonalArray(int[][] arr) {
        // задание 13
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] finishArray(int len, int initialValue) {
        // задание 14
        int[] newArray = new int[len];
        Arrays.fill(newArray, initialValue);
        return newArray;
    }
}
