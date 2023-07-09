public class Game{
    public static void main(String[] args){
        int[] deck = new int[52];
        for(int i = 0; i < 52; i++){
            deck[i] = (i + 1);
        }
        printWholeDeck(deck, 52);
    }

    public static void printWholeDeck(int[] deck, int deckSize){
       for(int i = 0; i < deckSize; i++){
           System.out.println(deck[i]);
       }
    }
}

class Shoe{
    Card cards[] = new Card[312];
    public Shoe(){
        for(int i = 0; i < cards.length; i++);
    }
}

class Card{
    Suit suit;
    Rank rank;
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
}

enum Suit {
    SPADES,
    HEARTS,
    DIAMONS,
    CLUBS;
}

enum Rank {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;
}
