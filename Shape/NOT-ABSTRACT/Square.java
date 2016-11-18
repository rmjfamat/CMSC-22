public class Square extends Rectangle{
  
  public Square(){
    super.length = 1.0;
    super.width = 1.0;
  }
  
  public Square(double side){
    super.length = side;
    super.width = side;
  }
  
  public Square(double side, String color, boolean filled){
    super(side, side, color, filled);
  }
  
  public double getSide(){
    return super.length;
  }
  
  public void setSide(double side){
    super.length = side;
  }
  
  public void setWidth(double side){
    super.width = side;
  }
  
  public void setLength(double side){
    super.length = side;
  }
  
  public String toString(){
    return "A Square with side = " + getSide() + ", which is a subclass of " + super.toString();
  }
   
  
}