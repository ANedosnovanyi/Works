public class Rectangle implements GeometricFigure{


    private String fillColor;
    private String borderColor;
    private double width;
    private double height;

    public Rectangle(String fillColor, String borderColor, double width, double height){
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.width = width;
        this.height = height;

    }

    @Override
    public double getArea() {
        return width * height;
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
        return 2 * (width + height);
    }
}
