import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculator {

  private int exitCount = 0;
  private String userInput;
  private String operationRegex = "[+%\\-*\\/]+";
  private String numberRegex = "\\d";

  Map<String, Integer> precedence = Map.of("+", 0, "-", 1, "\\", 2, "*", 3);

  public boolean exit(String userInput) {
    boolean isQuit = Pattern.matches("exit", userInput);
    if (isQuit) {
      switch (exitCount) {
        case 1:
          System.out.println("Bye. Thanks for using Calcli.");
          this.exitCount = 0;
          return true;
        case 0:
          System.out.println("Are you quitting! Enter exit again.");
          this.exitCount = 1;
          return false;
        default:
          return false;
      }
    }
    return false;
  }

  public boolean validate(String userInput) {
    boolean isValid = Pattern.matches(
      "^\\d(\\s[+%\\-*\\/]\\s\\d)+$",
      userInput
    );
    if (!isValid) {
      System.out.println("invalid input. Should be e.g 1 + 3 * 7" + userInput);
    }
    String[] data = this.parse(userInput);
    boolean doesInvalidValueExist = false;

    for (String value : data) {
      boolean isValidValue = Pattern.matches("[\\d+*\\-+\\/%]", value);
      if (!isValidValue) {
        doesInvalidValueExist = true;
      }
    }
    if (doesInvalidValueExist) {
      System.out.println(
        "invalid format. Should be mathematical operators and numbers"
      );
    }

    return isValid;
  }

  public String[] parse(String userInput) {
    String[] data = userInput.split("\\s+");
    return data;
  }

public List<String> parseOperations(String userInput) {
    List<String> operators = new ArrayList<>();

    Matcher matcher = Pattern
        .compile("[+\\-*/%]")
        .matcher(userInput.replaceAll("\\s+", ""));

    while (matcher.find()) {
        operators.add(matcher.group());
    }

    return operators;
}

public List<String> parseNumbers(String userInput) {
    List<String> nums = new ArrayList<>();

    Matcher matcher = Pattern
        .compile("-?\\d+(\\.\\d+)?")
        .matcher(userInput.replaceAll("\\s+", ""));

    while (matcher.find()) {
        nums.add(matcher.group());
    }

    return nums;
}

  public int getIndexWithHighestPrecedence(List<String> ops) {
    int min = 0;
    int index = 0;
    if(ops.size() == 0){
        throw new RuntimeException("No operator detected");
    }
    if(ops.size() == 1){
        return 0;
    }
    for (int i = 0; i < ops.size(); i++) {
      String operator = ops.get(i);
      if (precedence.containsKey(operator)) {
        if (precedence.get(operator) > min) {
          min = precedence.get(operator);
          index = i;
        }
      }
    }
    
    return index;
  }

  public double calculateSingleOperation(double a, double b, String op) {
    double answer = a;
   
    switch (op) {
      case "+":
        return Operation.add(answer, b);
      case "*":
        return Operation.multiply(answer, b);
      case "-":
        return Operation.minus(answer, b);
      case "/":
        return Operation.divide(answer, b);
      case "%":
        return Operation.remainder(answer, b);
      default:
        throw new RuntimeException("Please enter valid operator(): " + op);
    }
  }

  public double calculate(String userInput) {
    List<String> operations = this.parseOperations(userInput);
    List<String> nums = this.parseNumbers(userInput);

   

    double answer = 0;
    // 0, 1, 2, 3
    // 0 ,2, 4, 5, 6
    // [1,2,4,5]
    // [1,2,3]
    // [+,-,*]
    // [0,1,2]
    while (operations.size() > 0) {
      // search index
      int index = getIndexWithHighestPrecedence(operations);
    //   System.out.println(operations.size() + " " + nums.size() + " " + index) ;
      // operate
      double a = Double.parseDouble(nums.get(index));
      double b = Double.parseDouble(nums.get(index + 1));
      String op = operations.get(index);
      answer = calculateSingleOperation(a, b, op);
      // replace
      // [1,2,3,5]
      // [+,-,*]
      // 1
      // 1,2
      if(operations.size() == 1){
        break;
      }
      operations.remove(index);
      nums.remove(index + 1);
      nums.remove(index);
      nums.add(index, String.valueOf(answer));
    }
    return answer;
  }
}
