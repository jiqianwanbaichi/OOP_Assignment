/**
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Oct 14th, 2022
 * PA3
 * This class simulate a deck and a discard deck. It can formulate
 * a deck with 52 different cards and shuffle them using Fisher-Yates
 * shuffle method. This class contains drawNextCard() method to simulate
 * drawing card from deck and discard(Card c) method to discard used card
 * to discard card to discard pile. This class use Card class.
 */
public class Deck {
    /*
     * simulate the deck using Card class
     */
    Card[] deckPile;
    Card[] discardPile;
    int indexDeck;

    public Deck() {
        /*
         * construction method. formulate the deck by creating
         * 52 cards and shuffle them.
         * 
         * @param
         * 
         * @return
         */
        deckPile = new Card[52];
        discardPile = new Card[52];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (i == 0)
                    deckPile[i * 13 + j] = new Card(j + 1, "Hearts");
                if (i == 1)
                    deckPile[i * 13 + j] = new Card(j + 1, "Diamonds");
                if (i == 2)
                    deckPile[i * 13 + j] = new Card(j + 1, "Spades");
                if (i == 3)
                    deckPile[i * 13 + j] = new Card(j + 1, "Clubs");
            }
        }
        shuffle();
        indexDeck = -1;
    }

    public void shuffle() {
        /*
         * Using Fisher-Yates Shuffle method to shuffle the deck.
         */
        for (int i = deckPile.length - 1; i > 0; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            Card temp = deckPile[i];
            deckPile[i] = deckPile[j];
            deckPile[j] = temp;
        }
    }

    public Card drawNextCard() {
        /*
         * method to draw the next card from the deckpile.When 52 cards are
         * are run out, get the cards from discard pile and shuffle them
         * 
         * @param
         * 
         * @return (Card) return the card in deck pile
         */
        indexDeck++;
        if (indexDeck < 52)
            return deckPile[indexDeck];
        else {
            deckPile = discardPile.clone();
            shuffle();
            indexDeck = 0;
            discardPile = new Card[52];
            return deckPile[indexDeck];
        }
    }

    public void discard(Card c) {
        /*
         * method to discard card to discard pile
         * 
         * @param (Card) c
         * 
         * @return
         */
        discardPile[indexDeck] = c;
    }
}
