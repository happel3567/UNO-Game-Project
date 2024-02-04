import java.util.*;

public class player {

    
    private LinkedList<cards> hand; // The Player's hand will store the information about their cards
    private String name; // Name for the Player/AI
    private int numCards; // Keeps tracks of how many cards a player has in their hand

    public cards generatecard() {
        // Randomly generate a valid UNO card
        double Cardrandom0to1 = (Math.random());
        int NumberforCard = (int) (Cardrandom0to1 * 15);

        double Colorrandom0to1 = (Math.random());
        int ColorforCard = (int) (Colorrandom0to1 * 4) + 1;

        String color = "";

        if (ColorforCard == 1) {
            color = "Red";
        }
        else if (ColorforCard == 2) {
            color = "Green"; 
        }
        else if (ColorforCard == 3) {
            color = "Yellow";
        }
        else if (ColorforCard == 4) {
            color = "Blue";
        }
        
        cards card = new cards(NumberforCard, color);
        return card;


    }

    public player(String name) {
        // Constructor for the player class
        this.name = getName();
        this.hand = new LinkedList<>(); // Create a linkedlist for the player's hand to easily remove and add cards. I used java.util. linkedlist to simplify the process
    }

    public String getName() {
        // Accessor for the name of the player. Since there is no user input, it doesn't need to worry about incorrect settings
        return this.name;
    }

    public LinkedList<cards> getHand() {
        // Accessor that returns the header of the linkedlist
        return this.hand;
    }

    public int getNumCards() {
        //  Accessor that returns the number of cards the player has. Since there is no user input, it doesn't need to worry about incorrect settings
        return this.numCards;
    }

    public void addCard() {
        // generates a card and add it to to the player's hand and updates the amount of cards the player has
        hand.add(generatecard());
        this.numCards++;
    }

    public void showhand() {
        // prints the cards in the player's hand for testing purposes
        for (cards card : hand) {
            System.out.println(card.toString());
        }
    }
}
