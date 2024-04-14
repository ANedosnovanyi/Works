import Lesson_5.Lesson5;
import Lesson_5.PhoneBook;

public class Main {
    public static void main(String[] args) {
        Lesson5.uniqueWords();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Недоснованый", "+79021341088");
        phoneBook.add("Курильцев", "+79811003050");
        phoneBook.add("Иванов", "+79113236876");
        phoneBook.add("Недоснованый", "+79813028000");
        phoneBook.add("Курильцев","+79318002948");

        PhoneBook.printNumbersForLastName(phoneBook, "Недоснованый");
        PhoneBook.printNumbersForLastName(phoneBook, "Курильцев");
        PhoneBook.printNumbersForLastName(phoneBook, "Иванов");

    }


}
