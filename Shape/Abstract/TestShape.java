public class TestShape {
   public static void main(String[] args) {
     Shape s1 = new Circle(5.5, "RED", false);// Upcast Circle to Shape
     System.out.println(s1);   // Calls Shape that is already overridden by Circle 
     System.out.println(s1.getArea()); //Calls Shape, and Shape implements getArea in Circle
     System.out.println(s1.getPerimeter()); //Calls Shape, and Shape implements getPerimeter in Circle
     System.out.println(s1.getColor());
     System.out.println(s1.isFilled());
     Circle c = (Circle)s1;
     System.out.println(c.getRadius());
     
     Circle c1 = (Circle)s1;// Downcast back to Circle
     System.out.println(c1);
     System.out.println(c1.getArea());
     System.out.println(c1.getPerimeter());
     System.out.println(c1.getColor());
     System.out.println(c1.isFilled());
     System.out.println(c1.getRadius());
     
     //Shape s2 = new Shape();
     //can't instantiate Shape because it's an abstract
     
     Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
     System.out.println(s3);
     System.out.println(s3.getArea());
     System.out.println(s3.getPerimeter());
     System.out.println(s3.getColor());
     Rectangle r = (Rectangle)s3;
     System.out.println(r.getLength());
     
     Rectangle r1 = (Rectangle)s3;// downcast
     System.out.println(r1);
     System.out.println(r1.getArea());
     System.out.println(r1.getColor());
     System.out.println(r1.getLength());
     
     Shape s4 = new Square(6.6);// Upcast
     System.out.println(s4);
     System.out.println(s4.getArea());
     System.out.println(s4.getColor());
     Square sq = (Square)s4;
     System.out.println(sq.getSide());
     
// Take note that we downcast Shape s4 to Rectangle,
// which is a superclass of Square, instead of Square
     Rectangle r2 = (Rectangle)s4;
     System.out.println(r2);
     System.out.println(r2.getArea());
     System.out.println(r2.getColor());
     Square squ = (Square)r2;
     System.out.println(squ.getSide());
     System.out.println(r2.getLength());
     
// Downcast Rectangle r2 to Square
     Square sq1 = (Square)r2;
     System.out.println(sq1);
     System.out.println(sq1.getArea());
     System.out.println(sq1.getColor());
     System.out.println(sq1.getSide());
     System.out.println(sq1.getLength());
     
     Shape s5 = new Triangle(1.0, 1.0, 1.0, "BLUE", false);// Upcast Triangle to Shape
     System.out.println(s5);
     System.out.println(s5.getArea());
     System.out.println(s5.getPerimeter());
     System.out.println(s5.getColor());
     System.out.println(s5.isFilled());
    
     Triangle t1 = (Triangle)s5;// Downcast back to Circle
     System.out.println(t1);
     System.out.println(t1.getArea());
     System.out.println(t1.getPerimeter());
     System.out.println(t1.getColor());
     System.out.println(t1.isFilled());
     
     //this must throw IllegalArgumentException because side is invalid
     Shape s6 = new Triangle(20.0, 5.0, 5.0, "YELLOW", false);// Upcast Triangle to Shape
     System.out.println(s6);
     System.out.println(s6.getArea());
     System.out.println(s6.getPerimeter());
     System.out.println(s6.getColor());
     System.out.println(s6.isFilled());
     
     Triangle t2 = (Triangle)s6;
     System.out.println(t2);
     System.out.println(t2.getArea());
     System.out.println(t2.getPerimeter());
     System.out.println(t2.getColor());
     System.out.println(t2.isFilled());
     
   }
}