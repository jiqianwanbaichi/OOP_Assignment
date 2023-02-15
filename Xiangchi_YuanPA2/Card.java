/**
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Oct 14th, 2022
 * PA3
 * This class simulate card. It can fomulate card with value, suit, color and
 * special name. Class contains getValue(), getColor() and getSuit() to get
 * corresponding
 * item. It also has toString() to help print information of card.
 */
public class Card {
    /*
     * simulate the card
     */
    int value;
    String suit;
    String color;
    String specialName;

    public Card(int value, String suit) {
        /*
         * construction method. formulate the card
         * 
         * @param (int)value (String suit)
         * 
         * @return (String) color
         */
        this.value = value;
        this.suit = suit;
        if (suit == "Hearts" || suit == "Diamonds") {
            this.color = "red";
        } else
            this.color = "black";
        if (value > 10 || value == 1) {
            if (value == 1)
                this.specialName = "Ace";
            if (value == 11)
                this.specialName = "Jack";
            if (value == 12)
                this.specialName = "Queen";
            if (value == 13)
                this.specialName = "King";
        } else
            specialName = Integer.toString(value);
    }

    public int getValue() {
        /*
         * get the value of the card
         * 
         * @return (int) value
         */
        return value;
    }

    public String getColor() {
        /*
         * get the color of the card
         * 
         * @return (String) color
         */
        return color;
    }

    public String getSuit() {
        /*
         * get the suit of the card
         * 
         * @return (String) suit
         */
        return suit;
    }

    public String toString() {
        /*
         * to string method
         * 
         * @return (String) special name and suit of the card
         */
        return "(" + specialName + ", " + suit + ")";
    }
}
