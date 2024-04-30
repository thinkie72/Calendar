import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

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

    public void paint(Graphics g) {

    }

    // Other Methods
    // Edited from https://www.geeksforgeeks.org/how-to-read-write-objects-data-in-csv-format-using-notepad-in-java/
    // to read in days.csv
    public void viewFile()
    {
        // Try block to check for exceptions
        try {

            // Creating object of File class to get file path
            File myObj = new File("days.txt");

            if (myObj.length() != 0) {
                Scanner myReader = new Scanner(myObj);
                myReader.useDelimiter(",");

                int i = 0;

                while (myReader.hasNextLine()) {
                    String str = myReader.nextLine();

                    // trim spaces
                    String[] splitString = str.split(",");
                    days[i] = new Day(this, parseInt(splitString[0]), splitString[1]);
                }
                myReader.close();
            }
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            System.out.println("An error occurred." + e);
            e.printStackTrace();
        }
    }
}
