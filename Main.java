import utils.Token;
import utils.TokenType;
import utils.Regex;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

class RPNStacker {
  public static int calculate(Token token, Integer a, Integer b) {
    if (token.type == TokenType.PLUS) {
      return a + b;
    } else if (token.type == TokenType.MINUS) {
      return a - b;
    } else if (token.type == TokenType.STAR) {
      return a * b;
    } else {
      return a / b;
    }
  }

  public static TokenType toTokenType(String value) throws Exception {
    if (Regex.isNum(value)) {
      return TokenType.NUM;
    } else if (Regex.isOp(value)) {
      if (Regex.isPlus(value)) {
        return TokenType.PLUS;
      } else if (Regex.isMinus(value)) {
        return TokenType.MINUS;
      } else if (Regex.isStar(value)) {
        return TokenType.STAR;
      } else if (Regex.isSlash(value)) {
        return TokenType.SLASH;
      }
    }
    throw new Exception("Error: Unexpected character: " + value);
  }

  public static int postfixRPN(List<Token> tokens) {
    ArrayList<Integer> stack = new ArrayList<Integer>();

    for (int i = 0; i < tokens.size(); i++) {
      Token token = tokens.get(i);

      try {
        Integer number = Integer.parseInt(token.lexeme);
        stack.add(number);
      } catch (NumberFormatException e) {
        Integer size = stack.size();
        Integer a = stack.get(size - 2);
        Integer b = stack.get(size - 1);
        stack.remove(size - 1);
        stack.remove(size - 2);
        stack.add(calculate(token, a, b));
      }
    }
    return stack.get(0);
  }

  public static void main(String[] args) {
    try {
      List<Token> tokens = new ArrayList<Token>();
      BufferedReader bf = new BufferedReader(new FileReader("./utils/Calc.stk"));
      String line = bf.readLine();

      while (line != null) {
        Token token = new Token(toTokenType(line), line);
        tokens.add(token);
        line = bf.readLine();
      }
      bf.close();

      System.out.println(tokens);
      System.out.println(postfixRPN(tokens));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}