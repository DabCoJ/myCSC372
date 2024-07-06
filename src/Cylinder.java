// Cylinder.java
public class Cylinder extends Shape {

    private double radius;
    private double height;

    // Constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Methods to calculate surface area and volume
    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    // toString method
    @Override
    public String toString() {
        return "Cylinder - Radius: " + radius +
                ", Height: " + height +
                "\nSurface Area: " + surfaceArea() +
                "\nVolume: " + volume();
    }
}
