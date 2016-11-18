public class Rectangle extends Shape{
  protected double length;
  protected double width;
  
  public Rectangle(){
    width = 1.0;
    length = 1.0;
  }
  
  public Rectangle(double width, double length){
    this.width = width;
    this.length = length;
  }
  
  public Rectangle(double width, double length, String color, boolean filled){
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
    return length * width;
  }
  
  public double getPerimeter(){
    return (2 * length) + (2 * width);
  }
  
  public String toString(){
    return "A rectangle with width = " + this.width + " and length " + this.length + ", which is a subclass of " + super.toString();
  }
  
}