package cards;

public enum Suit {
    Diamond("Diamond"),
    Clubs("Clubs"),
    Spades("Spades"),
    Hearts("Hearts");

   final private String name;

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Suit{" +
                "name='" + name + '\'' +
                '}';
    }
}

