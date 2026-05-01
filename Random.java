public class Random{
    public static void main(String[] args){
      String[] namesOne = {
    "anchor", "bright", "cascade", "drift",
    "elevate", "fluent", "glimmer"
};

String[] namesTwo = {
    "horizon", "ignite", "jovial", "kinetic",
    "luminous", "momentum", "nurture"
};

String[] namesThree = {
    "oracle", "pioneer", "quantum", "resilient",
    "synergy", "tranquil", "venture"
};
      
      int lengthOne = namesOne.length;
      int lengthTwo = namesTwo.length;
      int lengthThree = namesThree.length;
      java.util.Random randomGenerator = new java.util.Random();
      int indexOne = randomGenerator.nextInt(lengthOne);
      int indexTwo = randomGenerator.nextInt(lengthTwo);
      int indexThree = randomGenerator.nextInt(lengthThree);
      System.out.println(namesOne[indexOne] + " " + namesTwo[indexTwo] + " " + namesThree[indexThree]);
    }
    }
