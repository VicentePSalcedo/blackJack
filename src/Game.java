package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.Card.Rank;

public class Game {
    //how we keep track of the game state
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
    int bankRoll, bet, playerScore, dealerScore;

    public Game() {

        this.playerScore = 0;
        this.dealerScore = 0;

        this.shoe = new Shoe();
        this.player = new ArrayList<Card>();
        this.dealer = new ArrayList<Card>();
        this.bankRoll = 5000;
        this.bet = 0;
        this.state = State.WAGERING;
    }

    public void calculateHand(boolean isPlayer, ArrayList<Card> hand){
        int score = 0;
        for(Card card : hand){
            if(card.rank == Rank.Queen || card.rank == Rank.King || card.rank == Rank.Jack){
                score += 10;
            }else if(card.rank == Rank.Ace){
                score += 11;
            }else{
                score += card.rankInt;
            }
        }
        if(score > 21){
            for(Card aceCard : hand){
                if(aceCard.rank == Rank.Ace){
                    score -= 10;
                }
                if(score <= 21){
                    break;
                }
            }
        }
        if(isPlayer){
            playerScore = score;
            return;
        }
        dealerScore = score;
            
    }

    //the game engine
    public void run() {
        Scanner userInput = new Scanner(System.in);
        switch (state) {
            case WAGERING:
                do {
                    System.out.print("How much would you like to wager?[$10 - $" + bankRoll + "]\n\t$");
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
                hit(player);
                hit(player);

                hit(dealer);
                hit(dealer);
                calculateHand(false, dealer);
                calculateHand(true, player);

                
                state = State.PLAYERTURN;
                break;
            case PLAYERTURN:
                System.out.println("Dealer:");
                printHand(dealer, true);

                System.out.println("Player:");
                printHand(player, false);
                
                String choice = "";
                System.out.println(playerScore);
                System.out.print("Hit or Stand?[h/s]: ");
                do {
                    choice = userInput.next();
                    if(choice.equals("h")){
                        hit(player);
                        calculateHand(true, player);
                        System.out.println(player.get(player.size() - 1).rank + " of " + player.get(player.size() - 1).suit + " : " + player.get(player.size() - 1).rankInt);
                        System.out.println(playerScore);
                        if(playerScore > 21) {
                            state = State.LOSS;
                            break;
                        }
                    }
                    state = State.DEALERTURN;
                } while (!choice.equals("s"));
                break;
            case DEALERTURN:
            while(dealerScore < 17){
                hit(dealer);
                calculateHand(false, dealer);
                }
                if(dealerScore == playerScore){
                    state = State.PUSH;
                    break;
                }
                if(dealerScore > 21 || playerScore > dealerScore){
                    state = State.WIN;
                    break;
                }else{
                    state = State.LOSS;
                    break;
                }
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
                userInput.close();
                break;
        }
    }

    public void printHand(ArrayList<Card> hand, boolean dealer) {
        if (dealer == false) {
            for (Card card : hand) {
                System.out.println(card.rank + " of " + card.suit + " : " + card.rankInt);
            }
        }
        if (dealer == true) {
            System.out.println(hand.get(0).rank + " of " + hand.get(0).suit + " : " + hand.get(0).rankInt);
        }
    }

    public void hit(ArrayList<Card> hand){
        hand.add(shoe.cards[shoe.topOfDeck]);
        shoe.topOfDeck--;
    }

    public boolean IsComplete() {
        return this.state == State.QUIT;
    }
}
