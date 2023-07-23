package src;

public class Card {
    Suit suit;
    Rank rank;
    int rankInt;
    public Card(Suit suit, Rank rank, int rankInt){
        this.suit = suit;
        this.rank = rank;
        this.rankInt = rankInt;
    }
    public enum Suit {
        Spades,
        Hearts,
        Diamond,
        Clubs;
    }
    public enum Rank {
        Ace,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King;
    }
}
