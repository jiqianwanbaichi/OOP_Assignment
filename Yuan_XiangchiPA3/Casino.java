
/**
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Oct 14th, 2022
 * PA3
 * This program is a simple war game. User can play card game with
 * computer. User can input their total money and bet money in each 
 * round. If user don't want to play the game or user run out of
 * his money, the game will be over.
 * Known Bugs: no bug.
 */
import java.util.Scanner;

public class Casino {
    /*
     * This class is a simple war game. User can play card game with
     * computer. User can input their total money and bet money in each
     * round. If user don't want to play the game or user run out of
     * his money, the game will be over.
     */
    public static void main(String[] args) {
        // user input total money
        System.out.println("Game Start! Enter your totlol money:");
        Scanner input = new Scanner(System.in);
        int money = input.nextInt();

        // create a new deck and shuffle it
        Deck deck = new Deck();

        // play the game until user run out of money or don't want to play
        while (true) {
            if (money <= 0) {
                System.out.println("Run out of money,game over!");
                break;
            } else {
                System.out.println("Do you want to bet? Type 1 to end; type 0 to continue");
                int yorn = input.nextInt();
                if (yorn == 1)
                    break;
                else if (yorn == 0)
                    System.out.println("Gmae start\n-------------");
                System.out.println("Enter your bet money:");
                int bet = input.nextInt();
                if (gameRound(money, bet, deck)) {
                    System.out.println("You win in this round");
                    money += bet;
                } else {
                    System.out.println("You lose in this round");
                    money -= bet;
                }
            }
            System.out.println("Current money: " + money + "\n");

        }
        System.out.println("Your fianl money: " + money + "\n");
        input.close();
        return;

    }

    public static boolean gameRound(int money, int bet, Deck deck) {
        /*
         * method to let user and computer to play 1 round of war game.
         * caompare the value of palyers' card.
         * 
         * @param (int money, int bet, Deck deck)
         * 
         * @return (boolean) return user win or not
         */
        Card userCard = deck.drawNextCard();
        Card computerCard = deck.drawNextCard();
        System.out.println("Your value is " + userCard.toString());
        System.out.println("Computer value is " + computerCard.toString());
        if (userCard.value > computerCard.value) {
            return true;
        } else {
            return false;
        }
    }
}
