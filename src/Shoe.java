package src;

import java.util.Random;

public class Shoe {
    Card cards[] = new Card[312];
    int topOfDeck;
    public Shoe() {
        int decks = 0;
        int cardCount = 0;
        int rankCount;
        while (decks < 6) {
            for (Card.Suit suit : Card.Suit.values()) {
                rankCount = 1;
                for (Card.Rank rank : Card.Rank.values()) {
                    Card card = new Card(suit, rank, rank != Card.Rank.Ace ? rankCount : 0);
                    this.cards[cardCount] = card;
                    cardCount++;
                    if (rankCount <10){
                        rankCount++;
                    }
                }
            }
            decks++;
        }
        shuffle();
    }
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < this.cards.length; i++) {
            int randomIndexToSwap = rand.nextInt(this.cards.length);
            Card temp = this.cards[randomIndexToSwap];
            this.cards[randomIndexToSwap] = this.cards[i];
            this.cards[i] = temp;
        }
        this.topOfDeck = 311;
    }
    // This method is here to test the deck generation and serves no gameplay purpose
    public void printShoe() {
        for (Card card : this.cards) {
            System.out.println(card.rank + " of " + card.suit + " : " + card.rankInt);
        }
    }
}
