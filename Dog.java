package classes;

public class Dog extends Animal {
    public Dog(int Age, color c) {
        super(Age, c);
    }
    @Override
    public String sound() {
        return "woof woof";
    }

}
