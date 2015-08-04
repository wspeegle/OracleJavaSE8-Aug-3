package animals;

public class Animals {

    public static void main(String[] args) {
        Animal [] zoo = {
            new Cat(),
//            new Animal(),
            new Dog(),
        };
        
        for (Animal a : zoo) {
            System.out.println("Animal says " + a.getSound());
            a.eat("food");
        }
    }
    
}
