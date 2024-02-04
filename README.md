# UNO-Game-Project
My UNO game project created with Java and Java Swing

This project is not associated with any institution, and the code is my own

The code, written in Java, starts a process on your computer where you can play the classic card game UNO with graphics implemented by Java Swing
The game will continue to run until exited

# Rules of the game
The game begins with 7 cards in the player's hand, 7 cards in the opponent's hand, and one card in the middle
You will be able to see your own cards; however, you can only see the back of the opponent's cards
The player begins the game, they must match a card in their hand to the card in the middle of the game. Playable cards have the same color or number as the card in the middle
The game will alert the player that the card they are trying to play is invalid with a prompt next to the middle card
Once a player plays a card, their turn ends and the computer can play (they must also match a card to the middle card, which is now the card you played), unless a special card is played
The cards you play will disappear from your hand. The goal of the game is to have no cards left
Once the opponent finishes its turn, a description of its move will appear in the middle of the screen next to the middle card, the middle card will also change based on the last card the opponent played during its turn

Special/Action Cards
There are skip, reverse, plus2, plus4, and wild cards in this game
Since this game is only the player vs the computer, playing any special card will allow you to continue your turn
Skip - You skip your opponent's turn
Reverse - You reverse the order of play, so you get to play again since its a 1 vs 1 game
Plus2 - Make the opponent add 2 cards to their hand and skip their turn
Wild - Can be matched with any card middle card, you can then play again
Plus4 - Adds 4 cards to the opponents hand and acts like a wild
The computer opponent also has access to all these cards and it works the same for them

Draw a Card
You can add a new card to your hand and continue your turn

# Game Logic/Code
Player Class
hand variable - The player has a hand of cards, represented by a linkedlist so thats cards can be easily removed from the middle of the list when played
name variable - a string variable that holds the player's name to see whether they are the player or AI
numCards variable - an int variable storing the number of cards the player has in their hand
generatecard method - A public method that returns the type of cards. It randomly generates a random color and number for an UNO card and sets its properties. Generating a specific card does not exclude it from being generated again
The class then also has other methods that allow access for the variables and adds a generated card to the player's hand

Cards class
number variable - an int variable storing a card's associated number (10 = Skip, 11 = Reverse, 12 = Plus2, 13 = Plus4, 14 = Wild)
color variable - a string variable storing a card's color representation
Cardimage variable - a ImageIcon variable storing a card's PNG representation for java swing
The class then has methods to determine whether two cards are the same color or number, accessor methods for the variables, a method to set the card's PNG from the uno folder, and a method to display the proper string representation of a card

Uno class
Initializes the game by creating a player and AI opponent
Adds 7 cards to each of the players' hand
Has a main function which calls the UnoCardDisplay class to begin the game

UnoCardDisplay class
Creates a Java Swing JFrame for the game with a North, South, and Center panel
Displays the last played card in the middle of the screen, and any messages for the player, such as if their card is invalid, or what move their opponent made
The "unoDisplay" method handles the main function of the game. It iterates through the player's hand and adds a button for all of their cards to the bottom of the screen
It changes the middle card to display the player's most recent move and calls other methods to display if the player's move is invalid or what moves their opponent made
It recursively calls itself once the player has made a move to iterate through the player's hand again, which has now removed a card, in order to update the game board to show the change
It continues to recursively call itself until the player has played a non-action card and their turn has concluded
Once the player's turn has concluded, unoDisplay calls AIPlayARound to allow the computer to make its move
AIPlayARound iterates through the AI's linkedlist of cards until it finds a card that matches the middle card and plays it
If the AI is not able to find a suitable card, it will add a random card to the AI's hand and recursively call itself to try again
If the AI plays a suitable non-action card, the AIPlayARound will call unoDisplay to continue to the player's turn
If the AI plays a special card, it will call itself to play again since it has skipped the player's turn
Both methods check the AI or Player's hand before each call to see if either have 0 cards and the game can be ended
