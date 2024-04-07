import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            int sum = MyArray.processArray(MyArray.array2);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
