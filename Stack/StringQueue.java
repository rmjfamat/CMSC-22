//Created by Alvarez Comparativo, Famat
import java.util.Arrays; 

public class StringQueue{
  private String[] elements;
  private int count;
  public static final int DEFAULT_SIZE = 10;
  
  public StringQueue(){
    this(DEFAULT_SIZE);
  }
  public StringQueue(int size){
   elements = new String[size];
 }
  
  public void queue(String item){
    String q = new String();
    if(count >= elements.length){
      String[] temp = new String[elements.length*2];
    for(int i = 0; i <= elements.length; i++){
      temp[i] = elements[i];
    }
    elements = temp;
  }
  else{
   elements[count++] = item;
  }
  }
  
  public String dequeue(){
    if(count <= 0){
      throw new ArrayIndexOutOfBoundsException();
    }
    else{
      String temp = elements[0];
      for(int i = 1; i < count; i++) {
            elements[i - 1] = elements[i];
        }
       count--;
       return temp;
    }
    
  }
  
  public String peek(){
    return elements[count-1];
  }
  
  public String toString(){
      if(size() == 0){
        return "EMPTY";
  }
  String str = "";
   for(int i = 0; i < count - 1; i++){
    str += elements[i] + ", ";
   } 
   return str + elements[size() - 1];
  }
  
  public void singit(int position, String x){
   count++;
   if(count >= elements.length){
    String[] temp = new String[elements.length*2];
    for(int i = 0; i <= elements.length; i++){
      temp[i] = elements[i];
    }
    elements = temp;
   }
    for(int a = count-1; a >= position-1; a--){
      elements[a+1] = elements[a];
     }
      elements[position] = x;
    } 
 
  public int size(){
    return count;
  }
  
  public static void main(String[] args) {
        StringQueue line = new StringQueue();
        line.queue("Ruffa");
        line.queue("Jayfer");
        line.queue("MM");
        line.queue("Gwapa");
        System.out.println(line);
        System.out.println(line.size());

        String item1 = line.dequeue();
        String item2 = line.dequeue();
        String item3 = line.dequeue();

        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(line);
        System.out.println(line.size());

        line.queue("Nico");
        line.queue("Martin");
        line.queue("Enego");
        System.out.println(line);
        line.singit(2, "JJ");
        System.out.println(line);
    }
}