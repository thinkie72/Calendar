import java.util.ArrayList;

public class Day {
    // Instance Variables
    private int x, y;
    private ArrayList<String> importances;
    private Month month;
    private int number;

    // Constructor
    public Day(int x, int y, Month month, int number, String importance) {
       this.x = x;
       this.y = y;
       this.month = month;
       this.number = number;
       importances = new ArrayList<>();
       importances.add(importance);
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
