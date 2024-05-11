import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

// By Tyler Hinkie in 05.2024

public class Month {
    // Instance Variables
    private String name;
    private Day[] days;
    private int numDays;
    private int monthNumber;

    // Constructor
    public Month(String name, int days, int number) {
        this.name = name;
        this.days = new Day[days];
        numDays = days;
        monthNumber = number;
    }

    // Accessor and Mutator Methods
    public String getName() {
        return name;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public Day[] getDays() {
        return days;
    }

    public void setDay(int i, Day d) {
        days[i] = d;
    }
}