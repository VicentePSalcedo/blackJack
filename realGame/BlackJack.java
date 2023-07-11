package realGame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack{
    public static void main(String[] args){
        System.out.println("Welcome to BlackJack.");
        Game game = new Game();
        while(!game.IsComplete()){
            game.run();
        }
        System.out.println("See ya next time!");
    }
}
class Game{
    enum State{
        WAGERING,
        DEALING,
        PLAYERTURN,
        DEALERTURN,
        LOSS,
        PUSH,
        WIN,
        ATM,
        QUIT;
    }
    State state;
    Shoe shoe;
    ArrayList<Card> player;
    ArrayList<Card> dealer;
    int bankRoll, bet;
    public Game(){
        this.shoe = new Shoe();
        this.player = new ArrayList<Card>();
        this.dealer = new ArrayList<Card>();
        this.bankRoll = 5000;
        this.bet = 0;
        this.state = State.WAGERING;
    }
    public void run(){
        switch(state){
            case WAGERING:
                Scanner userInput = new Scanner(System.in);
                do {
                    System.out.println("How much would you like to wager?[Min:$10-Max:$" + bankRoll + "]");
                    while(!userInput.hasNextInt()){
                        System.out.println("Please enter a positive integer less than $" + bankRoll);
                        userInput.next();
                    }
                    bet = userInput.nextInt();
                } while ((bet < 10 || bet > bankRoll) || (bet%10) != 0);
                System.out.println("You bet $" + bet + ".");
                state = State.DEALING;
                break;
            case DEALING:
                hitPlayer();
                hitDealer();
                hitPlayer();
                hitDealer();
                state = State.PLAYERTURN;
                break;
            case PLAYERTURN:
                printHand(player);
                System.out.println("PlaterTurn State isn't working yet. Quitint out.");
                state = State.QUIT;
                break;
            case DEALERTURN:
                System.out.println("DealerTunr State isn't working yet. Quitint out.");
                state = State.QUIT;
                break;
            case LOSS:
                System.out.println("Loss State isn't working yet. Quitint out.");
                state = State.QUIT;
                break;
            case PUSH:
                System.out.println("Push State isn't working yet. Quitint out.");
                state = State.QUIT;
                break;
            case WIN:
                System.out.println("Win State isn't working yet. Quitint out.");
                state = State.QUIT;
                break;
            case ATM:
                System.out.println("Atm State isn't isn't working yet. Quitint out.");
                state = State.QUIT;
                break;
            case QUIT:
                break;
        }
    }
    public void printHand(ArrayList<Card> hand){
        for(Card card : hand){
            System.out.println(card.rank + " of " + card.suit);
        }
    }
    public void hitPlayer(){
        player.add(shoe.cards[shoe.topOfDeck]);
        shoe.topOfDeck--;
    }
    public void hitDealer(){
        dealer.add(shoe.cards[shoe.topOfDeck]);
        shoe.topOfDeck--;
    }
    public boolean IsComplete(){
        return this.state == State.QUIT;
    }
}
//we store the cards this way so that people can count cards in this game
class Shoe{
    Card cards[] = new Card[312];
    int topOfDeck;
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
        this.topOfDeck = 311;
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
