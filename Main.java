public class Main{
    public static void main(String[] args){
      int bottles = 5;
      String word = "bottles🍼🍼";
      System.out.println("Welcome to shop.\nWhat can I get you 😊.\n\n");
      while(bottles > 0){
          if(bottles == 1){
              word = "bottle🍼";
              }
          System.out.println(bottles + word + " available in my shop");
         bottles = bottles - 1;
      }
      if(bottles == 0){
          System.out.println("There are no bottles left. ☹️");
          System.out.println("\n\nSorry our shop is closed till tommorow.");
          }
          
      
    }
    }
