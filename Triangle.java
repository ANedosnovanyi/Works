public class Triangle implements GeometricFigure{

    private double direction1;
    private double direction2;
    private double direction3;
    private String fillColor;
    private String borderColor;


    public Triangle(String fillColor, String borderColor, double direction1, double direction2, double direction3){
        this.direction1 = direction1;
        this.direction2 = direction2;
        this.direction3 = direction3;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }



    @Override
    public double getArea() {
        double a = getPerimeter();
        return Math.sqrt(a * (a - direction1) * (a - direction2) * (a - direction3));

    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double getPerimeter() {
        return direction1 + direction2 + direction3;
    }
}
