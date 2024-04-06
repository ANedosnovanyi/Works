public class Cat extends Animal{
private static int catCount;
    private boolean satiety;
    private static int foodInBowl = 100;

 public  Cat(){
     super();
     satiety = false;
     catCount++;
 }

    @Override
    public void run(int distance) {
        System.out.println(distance <= 200 ? " - Kot пробежал " + distance +" м." :  " - Кот не может пробежать больше 200 метров");
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }

    public static   int getCatCount() {

     return catCount;
    }

    public void eat(int amount) {

        if (foodInBowl >= amount) {
            foodInBowl -= amount;
            satiety = true;
            System.out.println("Кот наелся.");
        } else {
            System.out.println("В миске не хватает еды для кота.");
        }
    }

    public static void addFood(int amount) {
        foodInBowl += amount;
        System.out.println("Добавлено " + amount + " еды в миску.");
    }

    public boolean isSatiety() {

     return satiety;
    }

    public static void myCats(){
        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat();
        }
        Cat.addFood(100);
        for (Cat cat : cats) {
            cat.eat(40);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " сытый: " + cats[i].isSatiety());
        }
    }
}
