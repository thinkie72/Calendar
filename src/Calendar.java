import java.io.File;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

    /**
     * MouseDemo and MouseDemoView
     * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
     * Modified for CS2 by Zach Blick on Feb. 13, 2024
     *
     * This demo implements the MouseListener and MouseMotionListener interfaces. The front-end listens for the
     * mouse events, which in turn call the methods that are implemented in the back-end.
     */
    public class Calendar implements MouseListener, MouseMotionListener {

        private Month[] months;

        // Instance Variables
        private CalendarView window;

        // Constructor
        // Constructors
        public Calendar() {
            months = new Month[12];
            readMonths();
            readDays();
            // Getters and Setters
            // Initialize the front-end
            this.window = new CalendarView(this);

            // addMouseListener attaches a MouseListener object to MouseDemoView
            // addMouseMotionListener attaches a MouseMotionListener object to MouseDemoView
            // By passing "this" as the parameter, it makes this specific Instance
            // of MouseDemo the MouseListener and the MouseMotionListener, which means
            // the front-end senses the mouse, but the back-end has the methods.
            this.window.addMouseListener(this);
            this.window.addMouseMotionListener(this);
        }

        // Edited from https://www.geeksforgeeks.org/how-to-read-write-objects-data-in-csv-format-using-notepad-in-java/
        // to read in days.csv
        public void readMonths() {
            // Try block to check for exceptions
            try {

                // Creating object of File class to get file path
                File myObj = new File("Resources/months.txt");

                if (myObj.length() != 0) {
                    Scanner myReader = new Scanner(myObj);
                    myReader.useDelimiter(",");

                    int i = 0;

                    while (myReader.hasNextLine()) {
                        String str = myReader.nextLine();

                        // trim spaces
                        String[] splitString = str.split(",");
                        months[i] = new Month(splitString[0], parseInt(splitString[1]), parseInt(splitString[2]));
                        i++;
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

        public void readDays() {
            try {

                // Creating object of File class to get file path
                File myObj = new File("Resources/days.txt");
                int x = 0;
                if (myObj.length() != 0) {
                    Scanner myReader = new Scanner(myObj);
                    myReader.useDelimiter(",");
                        int i = -1;
                        while (myReader.hasNextLine()) {
                            String str = myReader.nextLine();

                            // trim spaces
                            String[] splitString = str.split(",");
                            x = parseInt(splitString[0]);
                            if (x == 1) {
                                i++;
                            }
                            months[i].setDay(x - 1, new Day(months[i], x, splitString[1]));
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

    // Other Methods
    public static void main(String[] args) {
        Calendar c = new Calendar();
    }

    public Month[] getMonths() {
        return months;
    }

    /********************************************
     MouseListener event handlers - BEGIN
     ********************************************/

    @Override
    public void mousePressed(MouseEvent e) {
        // Check for arrow click
//        if ((e.getX() >= CalendarView.LEFT_X && e.getX() <= CalendarView.LEFT_X + CalendarView.ARROW_SIZE) &&
//                (e.getY() >= CalendarView.ARROW_Y && e.getY() <= CalendarView.ARROW_Y + CalendarView.ARROW_SIZE)) {
//            window.setMainScreen();
//        } else if ((e.getX() >= CalendarView.RIGHT_X && e.getX() <= CalendarView.RIGHT_X + CalendarView.ARROW_SIZE) &&
//                (e.getY() >= CalendarView.ARROW_Y && e.getY() <= CalendarView.ARROW_Y + CalendarView.ARROW_SIZE)) {
//            window.setMainScreen();
//        }
        if ((e.getX() >= CalendarView.BUFFER && e.getX() <= CalendarView.BUFFER + CalendarView.DAY_WIDTH * 7) &&
                (e.getY() >= 82 && e.getY() <= 82 + CalendarView.DAY_HEIGHT * 5)) {
            if (findDay(e)) {
                window.setMainScreen();
            }
        }

        window.repaint();

        // For demo purposes only
        System.out.println("mousePressed event handler executed.");
    }

    public boolean findDay(MouseEvent e) {
        int x = e.getX() - CalendarView.BUFFER;
        int y = e.getY() - CalendarView.BUFFER - CalendarView.TITLE_BAR - 10;
        int col = x / CalendarView.DAY_WIDTH;
        int row = y / CalendarView.DAY_HEIGHT;
        int index = row * 7 + col;
        if (index < getMonths()[window.getMonthIndex()].getNumDays()) {
            window.setDayIndex(index);
            return true;
        }
        return false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // For demo purposes only
        System.out.println("mouseReleased event handler executed.");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // For demo purposes only
        System.out.print("mouseClicked event handler executed");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // For demo purposes only
        System.out.println("mouseEntered event handler executed.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // For demo purposes only
        System.out.println("mouseExited event handler executed.");
    }

    /********************************************
     MouseListener event handlers - END
     ********************************************/

    /********************************************
     MouseMotionListener event handlers - BEGIN
     ********************************************/

    @Override
    public void mouseDragged(MouseEvent e) {
        // Print to terminal for demo purposes only
        System.out.println("\t\t\texecuting mouseDragged event handler");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // For demo purposes only
        System.out.println("\t\t\texecuting mouseMoved event handler");
    }

    /********************************************
     MouseMotionListener event handlers - END
     ********************************************/
    }
