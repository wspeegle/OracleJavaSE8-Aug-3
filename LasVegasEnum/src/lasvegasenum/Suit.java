package lasvegasenum;

public enum Suit {

    HEARTS("A very fancy heart!"), DIAMONDS("A very shiny diamond"),
    CLUBS, SPADES;

    private String fancyName;

    private Suit() {
        this.fancyName = "no fancy name specified";
    }

    private Suit(String fn) {
        this.fancyName = fn;
    }

    @Override
    public String toString() {
        String rv = name();
        rv = rv.substring(0, 1) + rv.substring(1, rv.length()).toLowerCase();
        return rv;
    }

    public String getFancyName() {
        return fancyName;
    }
}
