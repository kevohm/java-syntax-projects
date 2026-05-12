import java.util.Scanner;
import java.util.regex.Pattern;

public class Main{

    public static void main(String [] args){
        int exitCount = 0;
        Calculator myCalc = new Calculator();
        Scanner Obj = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Welcome to CalCli.\nEnter your mathematical equation e.g 2 + 5 / 4. Enjoy:)\n");
        while(true){
            String input = Obj.next();
            input  = input.trim();
              // quit
            boolean isQuit = myCalc.exit(input);
            if(isQuit){
                break;
            }else{
            // validate input
            myCalc.validate(input);
            // parse input
            String[] data = myCalc.parse(input);
            // calculate
            double answer = myCalc.calculate(input);
            System.out.println(" = " + answer);
            }

        }
        System.out.println("Thanks for using our calculator :)");

    }

}
