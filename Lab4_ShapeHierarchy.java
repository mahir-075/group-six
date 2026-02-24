
/**
 * Write a description of class Lab4_ShapeHierarchy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class shape{

    private String color= "red";
    private boolean filled =true;
  
    public shape(){
    }

    public shape(String color, boolean filled){
            this.color= color;
            this.filled= filled;
    }
    public String getColor(){
            return color;
    }
    public void setColor(String color){
            this.color= color;
    }
    public boolean isFilled(){
            return filled;
    }
    public void setFilled(boolean filled){
            this.filled = filled;
    }

    @Override
    public String toString(){
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}
     
     
class circle extends shape{
    private double radius = 1.0;

    public circle(){
    }
    
    public circle(double radius){
        this.radius = radius;
    }
    
    public circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    public double getArea(){
        return Math.PI * radius * radius;
    }
    
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String toString(){
        return "circle["+ super. toString() +", radius=" + radius + "]";
    }
}




class rectangle extends shape{

    private double width = 1.0;
    private double length = 1.0;

    public rectangle(){
    }
    
    public rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth(){
        return width;
    }
    
    public void setWidth(double width){
        this.width = width;
    }
    
    public double getLength(){
        return length;
    }
    
    public void setLength(double length){
        this.length = length;
    }
    
    public double getArea(){
        return width * length;
    }
    
    public double getPerimeter(){
        return 2 * (width + length);
    }

    @Override
    public String toString(){
        return "Rectangle[" + super.toString() + ", width= " + width + ", length " + length + "]";
    }
}



class square extends rectangle{
     public square(){
        super();
     }
      public square(double side){
        super(side, side);
      }

      public square (double side, String color, boolean filled){
        super(side, side, color, filled);
      }

      public double getSide(){
        return getWidth();
      }

      public void setSide(double side){
        super.setWidth(side);
        super.setLength(side);
      }

      @Override
      public void setLength(double side){
        super.setWidth(side);
        super.setLength(side);
      }

      @Override
      public String toString(){
        return "Square[" + super. toString() + "]";
      }

}


public class Lab4_ShapeHierarchy{
    public static void main(String[] args){

        System.out.println("section 1: Creating objects");

        shape s1 = new shape("yellow", false);
        System.out.println(s1);
        
        circle c1 = new circle(5.0, "blue", true);
        System.out.println(c1);
        
        System.out.println(" Area: " + c1.getArea());
        System.out.println(" Perimeter: " + c1.getPerimeter());

        rectangle r1 = new rectangle(4.0, 6.0, "green", true);
        System.out.println(r1);
        System.out.println(" Area: " + r1.getArea());
        System.out.println(" Perimeter: " + r1.getPerimeter());
        
        square sq1 = new square(5.0, "Orange", false);
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Perimeter: " + sq1.getPerimeter());

        System.out.println("section 2: Square Invariant ");

        square sq2 = new square(3.0);
        System.out.println("Initial: " + sq2);
        System.out.println("width: " + sq2.getWidth() +", Length: " + sq2.getLength());

        sq2.setWidth(7.0);
        System.out.println("\nAfter setWidth(7.0):");
        System.out.println("Width: "+ sq2.getWidth() + ", Length: " + sq2.getLength());
        System.out.println("Both should be 7.0!");

        sq2.setLength(9.0);
        System.out.println("\nAfter setLength(9.0): ");
        System.out.println("Width: " + sq2.getWidth() + ", Length: " + sq2.getLength());
        System.out.println("Both should be 9.0!");

        System.out.println("\n Section 3: Polymorphism");

        shape[] shapes = {
            new circle(3.0, "red", true),
            new rectangle(4.0, 5.0, "blue", false),
            new square(6.0, "green", true),
            new circle(7.0, "purple", true),
            new rectangle(2.0, 8.0, "yellow", false)
        };

        double totalArea = 0;

        for (shape shape: shapes){
            System.out.println(shape);
            if(shape instanceof circle){
                circle c = (circle) shape;
                totalArea += c.getArea();
            }else if(shape instanceof rectangle){
                rectangle r = (rectangle) shape;
                totalArea += r.getArea();
            }
        }
        System.out.println("\nTotal area of all shapes: " + totalArea);

        System.out.println("section 4: Inheritance chain");

        square sq3 = new square(4.0, "cyan", true);
        System.out.println("sq3 intanceof square: " + (sq3 instanceof square));
        System.out.println("sq3 instanceof rectangle: " + (sq3 instanceof rectangle));
        System.out.println("sq3 instanceof shape: " + (sq3 instanceof shape));
        System.out.println("sq3 instanceof object "+ (sq3 instanceof Object));


        rectangle r2 = sq3;
        shape s2 = sq3;
        Object o = sq3;

        System.out.println("\nAll upcasts work! square -> rectangle -> shape -> object");
          System.out.println(" End of lab 4");

    }
} 