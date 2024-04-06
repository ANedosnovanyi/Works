public class Animal {
    private static int animalCount;

    public Animal(){

        animalCount++;
    }

    public void run(int distance){
        System.out.println("Животное пробежало (м):" + distance);
    }

    public void swim(int distance){

        System.out.println("Животное проплыло (м): " + distance);
    }

    public static int getAnimalCount(){

        return animalCount;
    }
}
