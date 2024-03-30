import java.util.Arrays;

public class Lesson1 {
    public static void printThreeWords() {
        // задание 1
        System.out.println("Orange\nApple\nBanana");
    }
    public static void checkSumSign() {
        // задание 2
        int a = 8;
        int b = -30;
        int sum = a + b;

        System.out.println(sum >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }
    public static void printColor() {
        // задание 3
        int value = 175;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers() {
        // задание 4
        int a = 150;
        int b = 17;

        System.out.println(a >= b ? "a >= b" : "a < b");
    }
    public static boolean sumNumbers(int a, int b) {
        // задание 5
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    public static void nullNumbers(int number) {
        // задание 6
        System.out.println("Результат задания 6: ");
        System.out.println(number >= 0 ? number + " - Это число является положительным." : number + " - Это число является отрицательным.");
    }
    public static boolean numberReset(int number) {
        System.out.println("Результат задания 7: ");
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
        System.out.println("Задание 9: ");
        // задание 9
        if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
    public static int[] dateArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    public static void printArray(int[] arg) {
        for (int num : arg) {
            System.out.print( num + " ");
        }
        System.out.println();
    }

    public static void task10() {
        // задание 10
        printArray(dateArray);
        for (int i = 0; i < dateArray.length; i++) {
            if (dateArray[i] == 0) {
                dateArray[i] = 1;
            } else if (dateArray[i] == 1) {
                dateArray[i] = 0;
            }
        }
        printArray(dateArray);
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void task13() {
        // задание 13
        for (int i = 0; i < size; i++) {
            arrayDiagonal[i][i] = 1;
            arrayDiagonal[i][(arrayDiagonal.length - 1) - i] = 1;
        }
        printDiagonalArray(arrayDiagonal);
    }
    public static int[] finishArray(int len, int initialValue) {
        // задание 14
        int[] newArray = new int[len];
        Arrays.fill(newArray, initialValue);
        return newArray;
    }
}
