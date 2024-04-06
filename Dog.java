public class Dog  extends Animal{

    private static int dogCount;
    public Dog(){
        super();
        dogCount++;
    }

    @Override
    public void run(int distance) {
        System.out.println(distance <= 500 ? " Собака пробежала " + distance +" м." :  " - Собака не может пробежать больше 500 метров");
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        System.out.println(distance <= 10 ? " Собака проплыла " + distance +" м." :  " - Собака не может проплыть больше 10 метров");
        super.swim(distance);
    }

    public static int getDogCount() {

        return dogCount;
    }
}
