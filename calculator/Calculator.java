import java.util.regex.Pattern;


class Calculator{
    private int exitCount = 0;
    private String userInput;
    private String operationRegex = "[+%\\-*\\/]+";
    private String numberRegex = "\\d";

    public boolean exit(String userInput){
        boolean isQuit = Pattern.matches("exit", userInput);
        if(isQuit){
            switch(exitCount){
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

    public boolean validate(String userInput){
        boolean isValid =  Pattern.matches("^\\d(\\s[+%\\-*\\/]\\s\\d)+$", userInput);
         if(!isValid){
                System.out.println("invalid input. Should be e.g 1 + 3 * 7" + userInput);     
            }
        String[] data = this.parse(userInput);
        boolean doesInvalidValueExist = false;

        for(String value: data){
            boolean isValidValue =  Pattern.matches("[\\d+*\\-+\\/%]", value);
            if(!isValidValue){
                doesInvalidValueExist = true;
               
            }
        }
        if(doesInvalidValueExist){
             System.out.println("invalid format. Should be mathematical operators and numbers");   
        }
        
        return isValid;
    }
    public String[] parse(String userInput){
        String[] data = userInput.split("\\s+");
        return data;
    }
    public String[] parseOperations(String userInput){
        return userInput.replaceAll("\\s+","").split("[^"+ operationRegex +"]");
    }
    public String[] parseNumbers(String userInput){
        return userInput.replaceAll("\\s+","").split("[^(\\d | \\s)]");
      
    }
    public double calculate(String userInput){
        String[] operations = this.parseOperations(userInput);
        String[] nums = this.parseNumbers(userInput);
        double answer = Double.parseDouble(nums[0]);
        // 0, 1, 2, 3
        // 0 ,2, 4, 5, 6
        // [1,2,4,5]
        // [1,2,3]
        // [+,-,*]
        // [0,1,2] 
        for(int i = 1; i < nums.length; i++){
            double op2 = Double.parseDouble(nums[i]);
            switch(operations[i - 1]){
                case "+":
                    answer = Operation.add(answer, op2);
                case "*":
                    answer = Operation.multiply(answer,op2);
                case "-":
                    answer = Operation.minus(answer, op2);
                case "/":
                    answer = Operation.divide(answer,  op2);
                case "%":
                    answer = Operation.remainder(answer, op2);
                default:
                    throw new Error("Invalid Operation");
            }
        }
        return answer;
    }
}