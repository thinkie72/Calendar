import javax.swing.*;
import java.awt.*;

public class CalendarView extends JFrame {
    // Instance Variables
    public static final int WINDOW_WIDTH = 1000,
                            WINDOW_HEIGHT = 622,
                            TITLE_BAR = 22;
    private Calendar c;

    // Constructor
    public CalendarView(Calendar c) {
        this.c = c;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Calendar");
        this.setVisible(true);
    }

    // Getters and Setters

    // Other Methods
    @Override
    public void paint(Graphics g) {

    }
}
