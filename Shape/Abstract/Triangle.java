public class Triangle extends Shape{
  protected double s1;
  protected double s2;
  protected double s3;
  private double p;
  
  public Triangle(){
    s1 = 1.0;
    s2 = 1.0;
    s3 = 1.0;
  }
  
  public Triangle(double s1, double s2, double s3){
    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;
  }
  
  public Triangle(double s1, double s2, double s3, String color, boolean filled){
    super(color, filled);
    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;
  }
  
  public double getSide1(){
    return s1;
  }
  
  public void setSide1(double s1){
    this.s1 = s1;
  }
  
  public double getSide2(){
    return s2;
  }
  
  public void setSide2(double s2){
    this.s2 = s2;
  }
  
  public double getSide3(){
    return s3;
  }
  
  public void setSide3(double s3){
    this.s3 = s3;
  }
  
  public double getArea(){
    if((s1 < (s2 + s3)) && (s2 < (s1 + s3)) && (s3 < (s1  + s2))){
      p = (s1 + s2 + s3) / 2;
      return Math.sqrt((p * (p - s1) * (p - s2) * (p - s3)));
    }
    else{
      throw new IllegalArgumentException("Invalid Sides.");
    }
    
  }
 
  public double getPerimeter(){
   return s1 + s2 + s3;
  }
  
  public String toString(){
    return "A Triangle with sides = " + this.s1 + ", " + this.s2 + ", " + this.s3 + " which is a subclass of " + super.toString();
  }
}