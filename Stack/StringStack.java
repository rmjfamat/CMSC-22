public class StringStack{

 private String[] elements;
 private int count;
 public static final int DEFAULT_SIZE = 10;

 public StringStack(){
   this(DEFAULT_SIZE);
 }

 public StringStack(int size){
   elements = new String[size];
 }
 public void push(String item){

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

 public String pop(){
  if(count <= 0){
    throw new ArrayIndexOutOfBoundsException();
  }
  else{
   return elements[--count];
  }
 }

 public int size(){
  return count;
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
 
 public String peek(){
   return elements[count-1];
 }
 
 public static void main(String[] args){
        StringStack stack = new StringStack();
        stack.push("paper");
        stack.push("plastic");
        stack.push("tissue");
        stack.push("plate");
        System.out.println(stack);
        System.out.println(stack.size());

        String item1 = stack.pop();
        String item2 = stack.pop();
        String item3 = stack.pop();

        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(stack);
        System.out.println(stack.size());
        
        stack.push("spoon");
        System.out.println(stack);
    }
}