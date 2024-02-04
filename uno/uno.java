import javax.swing.*;
import java.awt.*;

public class uno {

    public static player Player;
    public static player AI;
    public static cards lastplayed;
    public static cards lastplayedAI;

    public static void creategame() {
        Player = new player("Player");
        while (Player.getNumCards() < 7) {
            Player.addCard(); // add 7 cards to the Player's linkedlist of cards to begin the game
        }
        AI = new player("AI");
        while (AI.getNumCards() < 7) {
            AI.addCard(); // add 7 cards to the Opponent's linkedlist of cards to begin the game
        }
        lastplayed = AI.generatecard(); // generate a random cards that the player will need to match a card to
    }

    
    public static void main(String[] args) {
        creategame();
        System.out.println("Player:");
        Player.showhand();
        System.out.println("AI:");
        AI.showhand();
        System.out.println("firstcard:");
        System.out.println(lastplayed); // see all the cards each player has and the starting card they need to match with
        SwingUtilities.invokeLater(() -> new UnoCardDisplay()); // display the graphics (the program will continue to run until closed)
        
    }
}