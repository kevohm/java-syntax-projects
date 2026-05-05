import java.util.regex.Pattern;


class Calculator{
    private int exitCount = 0;

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
            boolean isValidValue =  Pattern.matches("[\\d++\\-\\*%\\/]", value);
            if(!isValidValue){
                doesInvalidValueExist = true;
               
            }
        }
        if(doesInvalidValueExist){
             System.out.println("invalid format. Should be mathematical operators and numbers only");   
        }
        
        return isValid;
    }
    public String[] parse(String userInput){
        String[] data = userInput.split("\\s+");
        return data;
    }
}