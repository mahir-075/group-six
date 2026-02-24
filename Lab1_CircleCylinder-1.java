
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
/**
 * Lab 1: Circle and Cylinder - Inheritance Basics
 * PT821 - Object-Oriented Programming
 * State University of Zanzibar (SUZA)
 *
 * LEARNING OBJECTIVES:
 * - Understand superclass and subclass relationships
 * - Use super() to call parent constructors
 * - Override methods using @Override annotation
 * - Demonstrate upcasting and downcasting
 *
 * SUBMITTED BY: [Your Name]
 * DATE: [Submission Date]
 */


class Circle {
    private double radius;
    private String color;

    // Default constructor
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    // Constructor with radius only
    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    // Constructor with radius and color
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getter and setter for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter and setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // toString representation
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}

// ============================================================
// PART B: The Cylinder Class (Subclass of Circle)
// ============================================================

class Cylinder extends Circle {
    private double height;

    // Default constructor
    public Cylinder() {
        super(); // calls Circle()
        this.height = 1.0;
    }

    // Constructor with radius only
    public Cylinder(double radius) {
        super(radius); // calls Circle(radius)
        this.height = 1.0;
    }

    // Constructor with radius and height
    public Cylinder(double radius, double height) {
        super(radius); // calls Circle(radius)
        this.height = height;
    }

    // Constructor with radius, height, and color
    public Cylinder(double radius, double height, String color) {
        super(radius, color); // calls Circle(radius, color)
        this.height = height;
    }

    // Getter and setter for height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Calculate volume (area * height)
    public double getVolume() {
        return getArea() * height;
    }

    
    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ", height=" + height + "]";
    }
}


public class Lab1_CircleCylinder {
    public static void main(String[] args) {

        System.out.println("  Lab 1: Circle and Cylinder Hierarchy");
        

        
        System.out.println("--- Section 1: Basic Object Creation ---");

        // ToCreate a Circle with radius 5.0 and color "blue"
        Circle c1 = new Circle(5.0, "blue");
        System.out.println("Circle: " + c1);
        System.out.println("Area: " + c1.getArea());

        // ToCreate a Cylinder with radius 5.0, height 10.0, color "green"
        Cylinder cy1 = new Cylinder(5.0, 10.0, "green");
        System.out.println("\nCylinder: " + cy1);
        System.out.println("Base Area: " + cy1.getArea());
        System.out.println("Volume: " + cy1.getVolume());

        

        // ToDemonstrate upcasting
        Circle c2 = new Cylinder(3.0, 7.0, "yellow");
        System.out.println("c2 is a: " + c2.getClass().getSimpleName());
        System.out.println("c2.toString(): " + c2);
        System.out.println("c2.getArea(): " + c2.getArea());
        System.out.println("c2.getRadius(): " + c2.getRadius());

        
        System.out.println("\n--- Section 3: Downcasting ---");

        // TODemonstrate downcasting
        Circle c3 = new Cylinder(4.0, 8.0, "purple"); 
        Cylinder cy2 = (Cylinder) c3;                
        System.out.println("After downcast: " + cy2);
        System.out.println("Now we can call getVolume(): " + cy2.getVolume());

        Circle[] shapes = {
            new Circle(2.0, "red"),
            new Cylinder(3.0, 5.0, "blue"),
            new Circle(4.0, "green"),
            new Cylinder(1.0, 10.0, "orange")
        };

        for (Circle shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Cylinder) {
                Cylinder temp = (Cylinder) shape;
                System.out.println("  -> This is a Cylinder! Volume = " + temp.getVolume());
            } else {
                System.out.println("  -> This is just a Circle. Area = " + shape.getArea());
            }
        }

    
        System.out.println("End");
        
    }
}

