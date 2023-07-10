import java.util.ArrayList;
import java.util.Random;

public class Game{
    public static void main(String[] args){
        Shoe shoe = new Shoe();
        ArrayList<Card> dealer = new ArrayList<>();
        Player player = new Player();
        System.out.println("Welcome to BlackJack.");

        //Game setup by the player
        System.out.println("Your hand:");
        System.out.println(player.splits);
    }
}
class Player{
    ArrayList<ArrayList<Card>> splits = new ArrayList<>(4);
    public Player(){
        ArrayList<Card> hand = new ArrayList<>();
        this.splits.add(hand);
    }
    public void split(){
        try{
            ArrayList<Card> hand = new ArrayList<>();
            this.splits.add(hand);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You are at the max number of splits for this casino");
        }
    }
}
class Shoe{
    Card cards[] = new Card[312];
    int totalCards = 312;
    public Shoe(){
        int decks = 0;
        int cardCount = 0;
        while(decks < 6){
            for(Suit suit : Suit.values()){
                for(Rank rank : Rank.values()){
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
