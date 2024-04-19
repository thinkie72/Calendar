import java.util.ArrayList;

public class Month {
    // Instance Variables
    private String name;
    private ArrayList<Day> days;
    private int numDays;
    private int monthNumber;

    // Constructor
    public Month(String name, int days, int number) {
        this.name = name;
        this.days = new ArrayList<>();
        numDays = days;
        monthNumber = number;
    }

    // Accessor and Mutator Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    // Other Methods
    public void add(Day d) {
        days.add(d);
    }
}
