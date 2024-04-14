package Lesson_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, List<String>> CONTACTS;

    public PhoneBook() {
        this.CONTACTS = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (CONTACTS.containsKey(lastName)) {
            CONTACTS.get(lastName).add(phoneNumber);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            CONTACTS.put(lastName, numbers);
        }
    }

    public List<String> get(String lastName) {
        return CONTACTS.getOrDefault(lastName, new ArrayList<>());
    }

    public static void printNumbersForLastName(PhoneBook phoneBook, String lastName) {
        System.out.println("Номера телефонов для фамилии " + lastName + ":");
        List<String> numbers = phoneBook.get(lastName);
        for (String number : numbers) {
            System.out.println(number);
        }
    }
}
