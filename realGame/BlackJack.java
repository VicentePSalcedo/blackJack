package realGame;
import java.util.ArrayList;
import java.util.Random;

public class BlackJack{
    public static void main(String[] args){
        System.out.println("Welcome to BlackJack.");
        Game game = new Game();
        game.run();
    }
}
class Game{
    Shoe shoe;
    ArrayList<Card> player;
    ArrayList<Card> dealer;
    int bankdRoll;
    public Game(){
        this.shoe = new Shoe();
        this.player = new ArrayList<Card>();
        this.dealer = new ArrayList<Card>();
        this.bankdRoll = 5000;
    }
    public void run(){
        
    }
}
//we store the cards this way so that people can count cards in this game
class Shoe{
    Card cards[] = new Card[312];
    int totalCards = 312;
    public Shoe(){
        int decks = 0;
        int cardCount = 0;
        while(decks < 6){
            for(Card.Suit suit : Card.Suit.values()){
                for(Card.Rank rank : Card.Rank.values()){
                    Card card = new Card(suit, rank);
                    this.cards[cardCount] = card;
                    cardCount++;
                } 
            }
            decks++;
        }
        shuffle();
    }
    public void shuffle(){
        Random rand = new Random();
        for(int i = 0; i < this.cards.length; i++){
            int randomIndexToSwap = rand.nextInt(this.cards.length);
            Card temp = this.cards[randomIndexToSwap];
            this.cards[randomIndexToSwap] = this.cards[i];
            this.cards[i] = temp;
        }
    }
    public void printShoe(){
        for(Card card : this.cards){
            System.out.println(card.rank + " of " + card.suit);
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
    public enum Suit {
        Spades,
        Hearts,
        Diamnos,
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
