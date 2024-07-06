// ShapeArray.java
public class ShapeArray {

    public static void main(String[] args) {

        // Instantiate one sphere
        Sphere sphere = new Sphere(5.0); // radius = 5.0

        // Instantiate one cylinder
        Cylinder cylinder = new Cylinder(3.0, 7.0); // radius = 3.0, height = 7.0

        // Instantiate one cone
        Cone cone = new Cone(4.0, 6.0); // radius = 4.0, height = 6.0

        // Store instances into an array
        Shape[] shapeArray = { sphere, cylinder, cone };

        // Loop through the array and print out the instance data
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
            System.out.println(); // Separate each shape's output
        }
    }
}
