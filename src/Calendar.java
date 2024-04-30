import java.util.ArrayList;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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

    // Constructors
    public Calendar() {

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

    public static void main(String[] args) {
        Calendar c = new Calendar();
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
        int y = CalendarView.BUFFER + CalendarView.TITLE_BAR + 10;
        if ((e.getX() >= CalendarView.BUFFER && e.getX() <= CalendarView.BUFFER + CalendarView.DAY_WIDTH) &&
                (e.getY() >= y && e.getY() <= y + CalendarView.DAY_HEIGHT)) {
            window.setMainScreen();
        }

        window.repaint();

        // For demo purposes only
        System.out.println("mousePressed event handler executed.");
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
