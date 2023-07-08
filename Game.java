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
    private Deck decks[];
}
class Deck{
    private Card cards[];
}
class Card{
    private Suit suit;
    private Rank rank;
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    public Suit getSuit(){
        return suit;
    }
    public void setSuit(Suit suit){
        this.suit = suit;
    }
    public Rank getRank(){
        return rank;
    }
    public void setRank(Rank rank){
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
