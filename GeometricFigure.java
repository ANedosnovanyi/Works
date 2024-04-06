public interface GeometricFigure {


    double getArea();
    String getFillColor();
    String getBorderColor();

    default double getPerimeter() {
        System.out.println("Для данной фигуры периметр не рассчитывается");
        return 0.0;
    }

    static void printShapeInfo(GeometricFigure geometricFigure) {
        System.out.println();
        System.out.println("Периметр: " + geometricFigure.getPerimeter());
        System.out.println("Площадь: " + geometricFigure.getArea());
        System.out.println("Цвет фона: " + geometricFigure.getFillColor());
        System.out.println("Цвет границ: " + geometricFigure.getBorderColor());

    }


}
