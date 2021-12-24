import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    try {
      File myObj = new File("Calc1.stk");
      Scanner myReader = new Scanner(myObj);
      Stack<Integer> rpn_stack = new Stack<>();

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if(data.equals("+")){
          Integer a = rpn_stack.pop();
          Integer b = rpn_stack.pop();
          rpn_stack.push(b + a);
        } else if(data.equals("-")) {
          Integer a = rpn_stack.pop();
          Integer b = rpn_stack.pop();
          rpn_stack.push(b - a);
        } else if(data.equals("*")) {
          Integer a = rpn_stack.pop();
          Integer b = rpn_stack.pop();
          rpn_stack.push(b * a);
        } else if(data.equals("/")) {
          Integer a = rpn_stack.pop();
          Integer b = rpn_stack.pop();
          rpn_stack.push(b / a);
        } else {
          rpn_stack.push(Integer.parseInt(data));
        }
      }
      Integer result = rpn_stack.pop();
      System.out.println("Saida: "+ result);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}