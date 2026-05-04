import java.util.Scanner;

public class Main{

    public static void main(String [] args){

        Scanner Obj = new Scanner(System.in);

        while(true){
            String input = Obj.next();

            if(input == "exit"){
                break;
            }
            System.out.println(input == "exit");
            System.out.println("Hello " + input);
        }

        System.out.println("Thanks for using our calculator.\n\n Lots of love :)");

    }

}
