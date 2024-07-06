// Cone.java
public class Cone extends Shape {

    private double radius;
    private double height;

    // Constructor
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Methods to calculate surface area and volume
    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public double volume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    // toString method
    @Override
    public String toString() {
        return "Cone - Radius: " + radius +
                ", Height: " + height +
                "\nSurface Area: " + surfaceArea() +
                "\nVolume: " + volume();
    }
}
