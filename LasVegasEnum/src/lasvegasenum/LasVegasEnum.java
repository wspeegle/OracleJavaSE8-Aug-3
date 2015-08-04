package lasvegasenum;

public class LasVegasEnum {

    public static boolean isTrumps(Suit s) {
        return s == Suit.SPADES;
    }
    
    public static void main(String[] args) {
        Suit s = Suit.CLUBS;
        System.out.println(s + (isTrumps(s) ? " is " : " isn't ") + "trumps");
        s = Suit.SPADES;
        System.out.println(s + (isTrumps(s) ? " is " : " isn't ") + "trumps");
        // cannot instantiate!
//        Suit s1 = new Suit();
        s = Suit.valueOf("SPADES");
        System.out.println(s + (isTrumps(s) ? " is " : " isn't ") + "trumps");
        for (Suit s1 : Suit.values()) {
            System.out.println("> " + s1 + " : " + s1.ordinal());
            System.out.println(".. " + s1.getFancyName());

        }
    }
}
