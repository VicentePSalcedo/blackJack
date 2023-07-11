package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public enum State {
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

    public Game() {
        this.shoe = new Shoe();
        this.player = new ArrayList<Card>();
        this.dealer = new ArrayList<Card>();
        this.bankRoll = 5000;
        this.bet = 0;
        this.state = State.WAGERING;
    }

    public void run() {
        Scanner userInput = new Scanner(System.in);
        switch (state) {
            case WAGERING:
                do {
                    System.out.print("How much would you like to wager?[Min:$10-Max:$" + bankRoll + "]\n\t$");
                    while (!userInput.hasNextInt()) {
                        System.out.println("Please enter a positive integer less than $" + bankRoll);
                        userInput.next();
                    }
                    bet = userInput.nextInt();
                } while ((bet < 10 || bet > bankRoll) || (bet % 10) != 0);
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
                System.out.println("Dealer:");
                printHand(dealer, 1);
                System.out.println("Player:");
                printHand(player, 0);
                System.out.print("Hit or Stand?[h/s]:");
                System.out.println("PlayerTurn State isn't working yet. Quiting out.");
                state = State.QUIT;
                break;
            case DEALERTURN:
                System.out.println("DealerTunr State isn't working yet. Quiting out.");
                state = State.QUIT;
                break;
            case LOSS:
                System.out.println("Loss State isn't working yet. Quiting out.");
                state = State.QUIT;
                break;
            case PUSH:
                System.out.println("Push State isn't working yet. Quiting out.");
                state = State.QUIT;
                break;
            case WIN:
                System.out.println("Win State isn't working yet. Quiting out.");
                state = State.QUIT;
                break;
            case ATM:
                System.out.println("Atm State isn't isn't working yet. Quiting out.");
                state = State.QUIT;
                break;
            case QUIT:
                break;
        }
        userInput.close();
    }

    public void printHand(ArrayList<Card> hand, int dealer) {
        if (dealer == 0) {
            for (Card card : hand) {
                System.out.println(card.rank + " of " + card.suit);
            }
        }
        if (dealer == 1) {
            System.out.println(hand.get(0).rank + " of " + hand.get(0).suit);
        }
    }

    public void hitPlayer() {
        player.add(shoe.cards[shoe.topOfDeck]);
        shoe.topOfDeck--;
    }

    public void hitDealer() {
        dealer.add(shoe.cards[shoe.topOfDeck]);
        shoe.topOfDeck--;
    }

    public boolean IsComplete() {
        return this.state == State.QUIT;
    }
}
