import java.util.ArrayList;

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
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Month getMonth() {
        return month;
    }

    public int getNumber() {
        return number;
    }

    // Other Methods
}
