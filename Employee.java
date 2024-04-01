public class Employee {

    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private final double salary;
    private final int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age){
        this.fullName = fullName;
        this.age = age;
        this.phone = phone;
        this.position = position;
        this.email = email;
        this.salary = salary;
    }

    public  void printInformation(){
        System.out.println("ФИО: " + fullName +  " Должность: " + position + " Email: " + email + " Телефон: " + phone + " Зарплата: " + salary + " Возраст: " + age);

    }
    public static void printInformationOfMyEmployee(){
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Роман Алексеевич", "Генеральный директор", "ivanovroma@mail.ru", "89001341088", 200000, 48);
        employees[1] = new Employee("Петров Олег Валерьевич", "Менеджер", "vporoma@mail.ru", "89001341600", 60000, 37);
        employees[2] = new Employee("Попов Виктор Григорьевич", "Начальник отдела", "popovroma@mail.ru", "89001341087", 80000, 36);
        employees[3] = new Employee("Гусев Сергей Анатольевич", "Администратор", "gusevserroma@mail.ru", "89001341083", 45000, 27);
        employees[4] = new Employee("Васильченко Марат Алексеевич", "Специалист", "vasilchenkomoma@mail.ru", "89001341040", 50000, 40);
        for (Employee myEmployee : employees){
            myEmployee.printInformation();
        }
    }

    }
