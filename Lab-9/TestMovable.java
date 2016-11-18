public class TestMovable {
  public static void main(String[] args){
    Movable m1 = new MovablePoint(5, 6, 10, 10);
    System.out.println(m1);
    m1.moveLeft();
    System.out.println(m1);
    
    Movable m2 = new MovableCircle(2, 1, 2, 20, 2);
    System.out.println(m2);
    m2.moveRight();
    System.out.println(m2);
    
    Movable m3 = new MovableCircle(2, 1, 2, 20, 3);
    System.out.println(m3);
    m3.moveUp();
    System.out.println(m3);
    
    Movable m4 = new MovableCircle(2, 1, 2, 20, 4);
    System.out.println(m4);
    m4.moveDown();
    System.out.println(m4);
    
    Movable m5 = new MovableRectangle(2, 1, 2, 20, 1, 3);
    System.out.println(m5);
    m5.moveDown();
    System.out.println(m5);
  }
}