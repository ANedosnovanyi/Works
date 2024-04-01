import java.util.ArrayList;
import java.util.List;

public class Park {
    private final List<ParkSide> parkSides;

    public Park() {

        parkSides = new ArrayList<>();
    }

    public void addParkSide(String name, String workingTime, double price) {
        parkSides.add(new ParkSide(name, workingTime, price));
    }
    public static void myPark(){
        Park park = new Park();
        park.addParkSide("Карусель", "10:00 - 19:00", 50.0);
        park.addParkSide("Американские горки", "10:00 - 19:00",  300.0);
        park.addParkSide("Колесо обозрения", "10:00 - 19:00",  150.0);
        park.addParkSide("Цепная карусель", "10:00 - 19:00",  150.0);
        park.addParkSide("Веревочный парк", "10:00 - 19:00",  100.0);

        for (Park.ParkSide parkSide : park.parkSides) {
            System.out.println(parkSide);
        }

    }

    public static class ParkSide {
        private final String name;
        private final String workingTime;
        private final double price;

        public ParkSide(String name, String workingTime, double price) {
            this.name = name;
            this.workingTime = workingTime;
            this.price = price;
        }
        public String getName() {

            return name;
        }
        public String getWorkingTime() {

            return workingTime;
        }
        public double getPrice() {

            return price;
        }
        @Override
        public String toString() {
            return "Мои аттракционы: " + " Название: " + name + ", рабочее время: " + workingTime  + ", стоимость: " + price;
        }

    }
}
