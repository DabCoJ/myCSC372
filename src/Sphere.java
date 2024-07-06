// Sphere.java
public class Sphere extends Shape {

    private double radius;

    // Constructor
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Methods to calculate surface area and volume
    @Override
    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    // toString method
    @Override
    public String toString() {
        return "Sphere - Radius: " + radius +
                "\nSurface Area: " + surfaceArea() +
                "\nVolume: " + volume();
    }
}
