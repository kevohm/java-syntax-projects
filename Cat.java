package classes;

public class Cat extends Animal{
     public Cat(int Age, color c) {
        super(Age, c);
    }
    @Override
    public String sound() {
        return "Meaw meaw";
    }
}
