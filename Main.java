import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.run(200);
        cat.swim(50);
        Animal dog = new Dog();
        Animal dog2 = new Dog();
        dog.run(300);
        dog.swim(10);
        Cat.myCats();
        Animal cat1 = new Cat();
        System.out.println("Общее количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество собак: " + Dog.getDogCount());

        Circle circle = new Circle(12.0, "Red", "Black");
        Rectangle rectangle = new Rectangle("Black", "Blue",8 , 6);
        Triangle triangle = new Triangle("Black", "Yellow", 5.0,8 , 10);

        GeometricFigure.printShapeInfo(circle);
        GeometricFigure.printShapeInfo(rectangle);
        GeometricFigure.printShapeInfo(triangle);

    }
}
