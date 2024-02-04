import java.util.Iterator; // makes iterating through linkedlists and removing elements simpler
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Used for button presses

public class UnoCardDisplay {
    private static boolean AIFoundCard = false; // public static variable, AIFoundCard. I will use this to determine when the AI should stop drawing cards
    private static JLabel AIMove = new JLabel("Opponent ");; // public static variable, AIMove. This variable is updated by methods to display what moves AI did during its turn
    private static boolean AIDrewACard = false; // public static variable, AIDrewACard
    // If the AI had to draw a card, AIPlayARound will update the method, then updateMoveMessage will show that AI drew a card
    public UnoCardDisplay() {
        JPanel bottom = new JPanel(); // initializes the label for the bottom of the frame
        JPanel center = new JPanel(); // initializes the label for the center of the frame
        JPanel top = new JPanel(); // initializes the label for the top of the frame
        JFrame frame = new JFrame(); // initializes the frame with all the game's graphics
        frame.setTitle("Uno Card Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1600, 600);
        frame.setVisible(true);
        center.setPreferredSize(new Dimension(800, 200));
        bottom.setPreferredSize(new Dimension(1600, 100));
        top.setPreferredSize(new Dimension(1600, 200));
        frame.setLocationRelativeTo(null);
        frame.add(top,BorderLayout.NORTH);
        frame.add(bottom,BorderLayout.SOUTH);
        frame.add(center,BorderLayout.CENTER);

        setlastplayed(center); // place the first card that the Player must match a card to in the middle of the screen
        unoDisplay(bottom, center, frame, top);
    }

    public static void setlastplayed(JPanel center) {
        // updates the game so that the last played card is the only thing in the middle of the screen
        center.removeAll();
        JLabel currentcard = new JLabel(uno.lastplayed.getImage());
        center.add(currentcard);
    }

    public static void changeAInumber(JPanel top) {
        top.removeAll();
        for (cards unoCard : uno.AI.getHand()) { // Iterate through AI's linkedlist of cards to display how many cards it has at the top of frame
            JLabel cardLabel = new JLabel(new ImageIcon("C:\\Program Files\\uno\\unoback2.PNG"));
            top.add(cardLabel);
        }
    }

    public static void updateMoveMessage() {
        // Every time the AI makes a move, update AIMove with the relevant move
        String previousAIMoves = AIMove.getText();
        String newMove = "";
        if (AIDrewACard) {
            newMove = previousAIMoves + "drew a Card, ";
            AIDrewACard = false;
        }
        else {
            newMove = previousAIMoves + "played " + uno.lastplayedAI.toString() + ", ";
        }
        AIMove.setText(newMove);
    }
    public static void displayMoveMessage(JPanel center, JFrame frame) {
        // The AI has done its final move, the actions it has taken so far can now be displayed
        String previousAIMoves = AIMove.getText();
        String newMove = "";
        if (previousAIMoves.equals("Opponent ")) { // if AIMove wasn't updated before, do not append then before played
            newMove = previousAIMoves + "played " + uno.lastplayedAI.toString(); 
        }
        else {
            newMove = previousAIMoves + "then played " + uno.lastplayedAI.toString();
        }
        AIMove.setText(newMove);
        center.add(AIMove); // AIMove is displayed
    }
    private static void endGame(String winner, JPanel center, JPanel top, JPanel bottom, JFrame frame) {
        bottom.removeAll();
        center.removeAll();
        top.removeAll();
        JLabel endLabel = new JLabel("Game over! " + winner + " wins!");
        center.add(endLabel);
        if (winner.equals("AI")) {
            center.add(AIMove);
        }
        frame.repaint();
        frame.revalidate();
        // Any additional cleanup or game-ending logic
        // Display final score, prompt for new game, etc.
    }

    public static void actionMessage(JPanel center) {
        // Displays the action of the card that Player just played if applicable
        JLabel Skip = new JLabel("Opponent's Turn Was Skipped!");
        JLabel Drew2 = new JLabel("Opponent Drew 2 and Was Skipped!");
        JLabel Reverse = new JLabel("Reverse Back to You!");
        JLabel Drew4 = new JLabel("Opponent Drew 4, Pick Another Card to Choose Your Color");
        JLabel Wild = new JLabel("Pick Another Card to Select Your Color");
        // 10 is Skip, 11 is Draw2, 12 is Reverse, 13 is Draw4, 14 is Wild
        if (uno.lastplayed.getNumber() == 10) {
            center.add(Skip);
        }
        else if (uno.lastplayed.getNumber() == 11) {
            center.add(Reverse);
        }
        else if (uno.lastplayed.getNumber() == 12) {
            center.add(Drew2);
        }
        else if (uno.lastplayed.getNumber() == 13) {
            center.add(Drew4);
        }
        else {
            center.add(Wild);
        }
        
    }

    public static void AIPlayARound(JPanel bottom, JPanel center, JFrame frame, JPanel top) {
            Iterator<cards> iterator2 = uno.AI.getHand().iterator(); 
            while (iterator2.hasNext()) {
            cards AICard = iterator2.next(); // Iterate through AI's linkedlist of cards
                if (AICard.sameCardAs(uno.lastplayed) || AICard.sameColorAs(uno.lastplayed)) { 
                    // A playable card was found
                    uno.lastplayed = AICard;
                    uno.lastplayedAI = AICard;
                    iterator2.remove(); // remove the card that will be played from AI's linkedlist of cards
                    AIFoundCard = true; // update the global variable, AIFoundCard, to use for loop completion
                    break; //break after the first playable card is found
                }
            }
            if (AIFoundCard) {
                AIFoundCard = false;
                if (uno.lastplayed.getNumber() == 10) {
                    updateMoveMessage();
                    if (uno.Player.getHand().isEmpty()) {
                        endGame("Player", center, top, bottom, frame); // check to see if a player won
                    } else if (uno.AI.getHand().isEmpty()) {
                        endGame("AI", center, top, bottom, frame);
                    }
                    AIPlayARound(bottom, center, frame, top);
                    // Displays that AI skipped you, then AI gets to play again
                }
                if (uno.lastplayed.getNumber() == 11) {
                    updateMoveMessage();
                    if (uno.Player.getHand().isEmpty()) {
                        endGame("Player", center, top, bottom, frame); // check to see if a player won
                    } else if (uno.AI.getHand().isEmpty()) {
                        endGame("AI", center, top, bottom, frame);
                    }
                    AIPlayARound(bottom, center, frame, top);
                    // Displays that AI reversed back to itself, then AI gets to play again
                }   
                if (uno.lastplayed.getNumber() == 12) {
                    updateMoveMessage();
                    uno.Player.addCard();
                    uno.Player.addCard();
                    if (uno.Player.getHand().isEmpty()) {
                        endGame("Player", center, top, bottom, frame); // check to see if a player won
                    } else if (uno.AI.getHand().isEmpty()) {
                        endGame("AI", center, top, bottom, frame);
                    }
                    AIPlayARound(bottom, center, frame, top);
                    // Displays that you drew 2, then AI gets to play again
                }
                if (uno.lastplayed.getNumber() == 13) {
                    updateMoveMessage();
                    uno.Player.addCard();
                    uno.Player.addCard();
                    uno.Player.addCard();
                    uno.Player.addCard();
                    if (uno.Player.getHand().isEmpty()) {
                        endGame("Player", center, top, bottom, frame); // check to see if a player won
                    } else if (uno.AI.getHand().isEmpty()) {
                        endGame("AI", center, top, bottom, frame);
                    }
                    AIPlayARound(bottom, center, frame, top);
                    // Displays that you drew 4, then AI gets to play again
                }   
                if (uno.lastplayed.getNumber() == 14) {
                    updateMoveMessage();
                    if (uno.Player.getHand().isEmpty()) {
                        endGame("Player", center, top, bottom, frame); // check to see if a player won
                    } else if (uno.AI.getHand().isEmpty()) {
                        endGame("AI", center, top, bottom, frame);
                    }
                    AIPlayARound(bottom, center, frame, top);
                    // Displays that AI used a wild, then AI gets to play again
                }
                else {
                    setlastplayed(center); // set the middle card to be the last card the AI player
                    if (uno.Player.getHand().isEmpty()) {
                        endGame("Player", center, top, bottom, frame); // check to see if a player won
                    } else if (uno.AI.getHand().isEmpty()) {
                        endGame("AI", center, top, bottom, frame);
                    }
                    unoDisplay(bottom, center, frame, top);
                }
            }
            else { // if no playable card was found, AI needs to draw a card and try again until it can play
                AIDrewACard = true;
                updateMoveMessage();
                uno.AI.addCard();
                if (uno.Player.getHand().isEmpty()) {
                    endGame("Player", center, top, bottom, frame); // check to see if a player won
                } else if (uno.AI.getHand().isEmpty()) {
                    endGame("AI", center, top, bottom, frame);
                }
                AIPlayARound(bottom, center, frame, top);
                // AIPlayARound will continue to call itself until the AI draws a card that can be played
            }
        }
        
    

    public static void unoDisplay(JPanel bottom, JPanel center, JFrame frame, JPanel top) {
        changeAInumber(top); // refresh the AI's cards at the beginning of each turn
        bottom.removeAll(); // remove the Player's cards from the screen so the updated hand (if any) can be added
        for (cards unoCard : uno.Player.getHand()) { // iterate the the player's linkedlist of cards
            JButton cardLabel = new JButton(unoCard.getImage()); // makes a Button with the Image of the Respective Card for each Card
            cardLabel.addActionListener(new ActionListener() { 
                @Override // card was clicked by user
                public void actionPerformed(ActionEvent e) {
                    if (unoCard.sameCardAs(uno.lastplayed) || unoCard.sameColorAs(uno.lastplayed)) { // user is not making an illegal move
                        System.out.println("valid move");
                        uno.lastplayed = unoCard; // update lastplayed with the card the user clicked on
                        setlastplayed(center);
                        Iterator<cards> iterator = uno.Player.getHand().iterator();
                        while (iterator.hasNext()) {
                            cards card = iterator.next(); // Get the current card                    
                            // Check if the current card matches the clicked
                            if (card.equals(unoCard)) {
                                // Remove the current card from the Player's linkedlist of cards
                                iterator.remove();
                            }
                        }
                        if (unoCard.getNumber() == 10) {
                            // Card is a skip
                            // Player gets to pick another card
                            actionMessage(center);
                        }
                        else if (unoCard.getNumber() == 11) {
                            // Card played is a reverse
                            // Player gets to pick another card
                            actionMessage(center);
                        }
                        else if (unoCard.getNumber() == 12) {
                            // Card played is a Draw2
                            // AI will have 2 cards added to its linkedlist of cards and player gets to pick another card
                            uno.AI.addCard();
                            uno.AI.addCard();
                            setlastplayed(center);
                            actionMessage(center);
                        }
                        else if (unoCard.getNumber() == 13) {
                            // Card played is a Draw4
                            // AI will have 4 cards added to its linkedlist of cards and player gets to pick another card
                            uno.AI.addCard();
                            uno.AI.addCard();
                            uno.AI.addCard();
                            uno.AI.addCard();
                            actionMessage(center);
                        }
                        else if (unoCard.getNumber() == 14) {
                            // Card played is a Wild
                            // Player gets to pick another card
                            actionMessage(center);
                        }
                        else {
                            if (uno.Player.getHand().isEmpty()) {
                                endGame("Player", center, top, bottom, frame); // check to see if a player won
                            } else if (uno.AI.getHand().isEmpty()) {
                                endGame("AI", center, top, bottom, frame);
                            }
                            AIMove.setText("Opponent "); // reset AIMove text in preperation for AI's move
                            AIPlayARound(bottom, center, frame, top); // call AIPlayARound for the AI's turn
                            displayMoveMessage(center, frame); // the AI finished its turn
                        }
                        bottom.removeAll();
                        if (uno.Player.getHand().isEmpty()) {
                            endGame("Player", center, top, bottom, frame); // check to see if a player won
                        } else if (uno.AI.getHand().isEmpty()) {
                            endGame("AI", center, top, bottom, frame);
                        }
                        unoDisplay(bottom, center, frame, top);
                        frame.repaint();
                        frame.revalidate();
                        // redraw the screen to show updates
                    }
                    else {
                        // the player clicked on a card that can't be played
                        JLabel label = new JLabel("Card doesn't match color or number!");
                        setlastplayed(center);
                        center.add(label);
                        frame.repaint();
                        frame.revalidate();
                    }
                }
        });
        bottom.add(cardLabel); // adds each created button representing cards to the bottom of the screen
        }
        JButton PickCard = new JButton("Draw A Card"); // this button allows a player to draw another card and continue their turn
        PickCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uno.Player.addCard();
                unoDisplay(bottom, center, frame, top);
                frame.repaint();
                frame.revalidate();
            }
        });
        bottom.add(PickCard); // adds PickCard button after all the cards have been added at the bottom
        if (uno.Player.getHand().isEmpty()) {
            endGame("Player", center, top, bottom, frame);
        } else if (uno.AI.getHand().isEmpty()) {
            endGame("AI", center, top, bottom, frame);
        }   
    }
    

}
