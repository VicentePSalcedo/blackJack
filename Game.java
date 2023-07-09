public class Game{
    public static void main(String[] args){
        Shoe shoe = new Shoe();
    }

}

class Shoe{
    Card cards[] = new Card[312];
    public Shoe(){
        int decks = 0;
        int cardCount = 0;
        while(decks < 6){
            for(Suit suit : Suit.values()){
                for(Rank rank : Rank.values()){
                    Card card = new Card(suit, rank);
                    cards[cardCount] = card;
                    cardCount++;
                } 
            }
            decks++;
        }
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
    Spades,
    Hearts,
    Diamnos,
    Clubs;
}

enum Rank {
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
