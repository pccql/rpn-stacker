import java.util.ArrayList;

class RPNStacker {
  public static int calculate(char operator, Integer a, Integer b) {
    if (operator == '+') {
      return a + b;
    } else if (operator == '-') {
      return a - b;
    } else if (operator == '*') {
      return a * b;
    } else {
      return a / b;
    }
  }

  public static int postfixRPN(String data) {
    char[] elements = data.toCharArray();

    ArrayList<Integer> stack = new ArrayList<Integer>();

    for (int i = 0; i < elements.length; i++) {
      char elem = elements[i];

      if (Character.isDigit(elem) == true) {
        stack.add(Character.getNumericValue(elem));
      } else {
        char operator = elem;
        Integer size = stack.size();
        Integer a = stack.get(size - 2);
        Integer b = stack.get(size - 1);
        stack.remove(size - 1);
        stack.remove(size - 2);
        stack.add(calculate(operator, a, b));
      }
    }
    return stack.get(0);
  }

  public static void main(String[] args) {
    String expression = "23*54*+9-";
    System.out.println(postfixRPN(expression));
  }
}