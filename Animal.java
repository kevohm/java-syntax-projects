package classes;

public class Animal {
    private int age;
    enum color {
Black,White,Orange,green,Blue,Yellow,Brown
    };

    private color colour;
    
    public Animal(int Age, color c) {
        age = Age;
        colour = c;
    }

    public String sound() {
        return "This is an animal";
    }

    public String description() {
        return "This is an "+age+ " "+colour+ " animal";
    }
    public static void main(String[] args) {
        Dog tiger = new Dog(15, color.Brown);
        Cat felis = new Cat(23, color.Blue);
        System.out.println(felis.description());   
        System.out.println(tiger.description());
        System.out.println(felis.sound());   
        System.out.println(tiger.sound());   
    }

}
