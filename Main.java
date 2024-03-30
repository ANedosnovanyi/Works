import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Lesson1.printThreeWords();
        Lesson1.checkSumSign();
        Lesson1.printColor();
        Lesson1.compareNumbers();
        System.out.println("Результат задания 5: " + Lesson1.sumNumbers(8,6));
        Lesson1.nullNumbers(6);
        System.out.println(Lesson1.numberReset(-41));
        Lesson1.testArgs("Задание 8 выполнено!",8);
        System.out.println(Lesson1.leapYear(2001));
        Lesson1.task10();
        Lesson1.changeArray(Lesson1.array);
        System.out.println("Задание 11: " + Arrays.toString(Lesson1.array));
        Lesson1.multiplyNumber(Lesson1.integerMultiplier);
        System.out.println("Задание 12: " + Arrays.toString(Lesson1.integerMultiplier));
        Lesson1.task13();
        System.out.println("Задание 14: " + Arrays.toString(Lesson1.finishArray(15,30)));
    }
}
