import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Game{
    static Player player = new Player();
    public static void main(String[] args){

        Shoe shoe = new Shoe();
        Dealer dealer = new Dealer();

        System.out.println("Welcome to BlackJack.");
        //Game setup by the player
        System.out.println("How big a bankroll do you have today?");
        Scanner userIn = new Scanner(System.in);
        player.setBankroll(userIn.nextInt());
        printBankRoll();
    }
    public void hit(){
    }
    public static void printBankRoll(){
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);
        String bankString = dollar.format(player.getBankroll());
        System.out.println(bankString);
    }
}

class Dealer{
    ArrayList<Card> hand = new ArrayList<Card>();
}

class Player{
    private int bankroll;
    int currentBet;
    ArrayList<Card> hand = new ArrayList<Card>();
    public void setBankroll(int userIn){
        this.bankroll = userIn;
    }
    public int getBankroll(){
        return this.bankroll;
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
