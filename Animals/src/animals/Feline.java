package animals;

public abstract class Feline extends Animal {
    @Override
    public void eat(String food) {
        System.out.println("Play with " + food);
        super.eat(food);
    }
}
