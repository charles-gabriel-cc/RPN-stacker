import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    ArrayList<Token> tokens = new ArrayList<Token>();

    try {
      File myObj = new File("Calc1.stk");
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        TokenType aux;

        if(data.equals("+")){
          aux = TokenType.PLUS;
        } else if(data.equals("-")) {
          aux = TokenType.MINUS;
        } else if(data.equals("*")) {
          aux = TokenType.STAR;
        } else if(data.equals("/")) {
          aux = TokenType.SLASH;
        } else {
          try {
            Integer.parseInt(data);
          } catch (NumberFormatException e){
            System.out.println("Error: Unexpected character: " + data);
            System.exit(0);
          }
          aux = TokenType.NUM;
        }
        Token token = new Token(aux, data);
        tokens.add(token);
        System.out.println(token.toString());
      }
      myReader.close();
    } catch (FileNotFoundException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    Stack<Integer> rpn_stack = new Stack<>();

    for (int i = 0; i < tokens.size(); i++) {
      if (tokens.get(i).type == TokenType.PLUS) {
        Integer a = rpn_stack.pop();
        Integer b = rpn_stack.pop();
        rpn_stack.push(b + a);
      } else if (tokens.get(i).type == TokenType.MINUS) {
        Integer a = rpn_stack.pop();
        Integer b = rpn_stack.pop();
        rpn_stack.push(b - a);
      } else if (tokens.get(i).type == TokenType.STAR) {
        Integer a = rpn_stack.pop();
        Integer b = rpn_stack.pop();
        rpn_stack.push(b * a);
      } else if (tokens.get(i).type == TokenType.SLASH) {
        Integer a = rpn_stack.pop();
        Integer b = rpn_stack.pop();
        rpn_stack.push(b / a);
      } else {
        rpn_stack.push(Integer.parseInt(tokens.get(i).lexeme));
      }
    }
    Integer result = rpn_stack.pop();
    System.out.println("\nSaida: "+ result);
  }
}
