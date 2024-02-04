import javax.swing.ImageIcon;


public class cards{
    private int number; // stores the number value for the card
    private String color; // stores a string depicting the color of a card
    private ImageIcon Cardimage; // stores a card's image representation

    public static final String[] VALUE_STRINGS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Plus2", "Plus4", "Wild"};


    public int getNumber() {
        // Accessor for the card's associated number (10 = Skip, 11 = Reverse, 12 = Plus2, 13 = Plus4, 14 = Wild)
        return this.number;
    }

    public String getcolor() {
        // Accessor for the card's associated color
        return this.color;
    }

    public ImageIcon getImage() {
        return this.Cardimage;
    }

    public cards(int number, String color) {
        // Constructor for the card class. Since the user has no input, I don't need to use accessors for throwing errors
        this.number = number;
        this.color = color;
        SetImage();
    }

    public boolean sameColorAs(cards other) {
        // Determines if a card has the same color as another card. Returns true if they do and false if they do not
        if (other == null) {
            return false;
        }
        if (this.color == other.getcolor()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean sameCardAs(cards other) {
        // Determines if a card has the same number value as another card. Returns true if they do and false if they do not (For 13 and 14 all cards match them because they are Wild)
        if (other == null) {
            return false;
        }
        if (this.number == other.getNumber()) {
            return true;
        }
        if (this.number == 13 || other.getNumber() == 13) {
            return true;
        }
        if (this.number == 14 || other.getNumber() == 14) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        // returns a string of the card's color and number/action
        if (this.number < 13) {
            String snumber = VALUE_STRINGS[this.number];
            return this.color + " " + snumber;
        }
        else if (this.number == 13) {
            return "Plus4";
        }
        else {
            return "Wild";
        }
    }

    public void SetImage() {
        // Sets the correct image to each card based on its number and color
        if (this.color == "Red") {
            if (this.number == 0) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\0red.PNG");
            }
            if (this.number == 1) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\1Red.PNG");
            }
            if (this.number == 2) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\2Red.PNG");
            }
            if (this.number == 3) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\3Red.PNG");
            }
            if (this.number == 4) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\4Red.PNG");
            }
            if (this.number == 5) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\5Red.PNG");
            }
            if (this.number == 6) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\6Red.PNG");
            }
            if (this.number == 7) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\7red.PNG");
            }
            if (this.number == 8) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\8red.PNG");
            }
            if (this.number == 9) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\9red.PNG");
            }
            if (this.number == 10) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\redskip.PNG");
            }
            if (this.number == 11) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\redreverse.PNG");
            }
            if (this.number == 12) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\plus2red.PNG");
            }
            if (this.number == 13) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\plus4.PNG");
            }
            if (this.number == 14) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\wild.PNG");
            }

        }
        if (this.color == "Green") {
            if (this.number == 0) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\0green.PNG");
            }
            if (this.number == 1) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\1green.PNG");
            }
            if (this.number == 2) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\2green.PNG");
            }
            if (this.number == 3) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\3green.PNG");
            }
            if (this.number == 4) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\4green.PNG");
            }
            if (this.number == 5) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\5green.PNG");
            }
            if (this.number == 6) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\6green.PNG");
            }
            if (this.number == 7) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\7green.PNG");
            }
            if (this.number == 8) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\8green.PNG");
            }
            if (this.number == 9) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\9green.PNG");
            }
            if (this.number == 10) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\greenskip.PNG");
            }
            if (this.number == 11) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\greenreverse.PNG");
            }
            if (this.number == 12) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\plus2green.PNG");
            }
            if (this.number == 13) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\plus4.PNG");
            }
            if (this.number == 14) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\wild.PNG");
            }
        }
        if (this.color == "Yellow") {
            if (this.number == 0) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\0yellow.PNG");
            }
            if (this.number == 1) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\1yellow.PNG");
            }
            if (this.number == 2) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\2yellow.PNG");
            }
            if (this.number == 3) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\3yellow.PNG");
            }
            if (this.number == 4) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\4yellow.PNG");
            }
            if (this.number == 5) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\5yellow.PNG");
            }
            if (this.number == 6) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\6yellow.PNG");
            }
            if (this.number == 7) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\7yellow.PNG");
            }
            if (this.number == 8) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\8yellow.PNG");
            }
            if (this.number == 9) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\9yellow.PNG");
            }
            if (this.number == 10) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\yellowskip.PNG");
            }
            if (this.number == 11) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\yellowreverse.PNG");
            }
            if (this.number == 12) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\plus2yellow.PNG");
            }
            if (this.number == 13) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\plus4.PNG");
            }
            if (this.number == 14) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\wild.PNG");
            }
        }
        if (this.color == "Blue") {
            if (this.number == 0) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\0blue.PNG");
            }
            if (this.number == 1) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\1blue.PNG");
            }
            if (this.number == 2) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\2blue.PNG");
            }
            if (this.number == 3) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\3blue.PNG");
            }
            if (this.number == 4) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\4blue.PNG");
            }
            if (this.number == 5) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\5blue.PNG");
            }
            if (this.number == 6) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\6blue.PNG");
            }
            if (this.number == 7) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\7blue.PNG");
            }
            if (this.number == 8) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\8blue.PNG");
            }
            if (this.number == 9) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\9blue.PNG");
            }
            if (this.number == 10) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\blueskip.PNG");
            }
            if (this.number == 11) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\bluereverse.PNG");
            }
            if (this.number == 12) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\plus2blue.PNG");
            }
            if (this.number == 13) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\plus4.PNG");
            }
            if (this.number == 14) {
                this.Cardimage = new ImageIcon("C:\\Program Files\\uno\\wild.PNG");
            }
        }
    }

    
}