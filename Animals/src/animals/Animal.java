package animals;

public abstract class Animal {
    public abstract String getSound();
    
    public void eat(String food) {
        System.out.println("munch munch");
    }
}
