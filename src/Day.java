import java.awt.*;
import java.util.ArrayList;

// By Tyler Hinkie in 05.2024

public class Day {
    // Instance Variables
    private String significance;
    private Month month;
    private int number;

    // Constructor
    public Day(Month month, int number, String s) {
        this.month = month;
        this.number = number;
        this.significance = s;
    }

    // Accessor and Mutator Methods

    public Month getMonth() {
        return month;
    }

    public int getNumber() {
        return number;
    }

    public String getSignificance() {
        return significance;
    }

    // Other Methods
    // This paint method formats the significances to split each word up to make it fit better on the screen
    public void paint(Graphics g) {
        String copy = significance;
        String[] split = copy.split(" ");
        for (int i = 0; i < split.length; i++) {
            g.drawString(split[i], 225, 200 + 80 * i);
        }
    }

}
