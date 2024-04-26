import javax.swing.*;
import java.awt.*;

public class CalendarView extends JFrame {
    // Instance Variables
    public static final int WINDOW_WIDTH = 1000,
                            WINDOW_HEIGHT = 622,
                            TITLE_BAR = 22,
                            BUFFER = 50,
                            DAY_WIDTH = 125,
                            DAY_HEIGHT = 100,
                            LEFT_X = 375,
                            RIGHT_X = 615,
                            ARROW_Y = 45,
                            MONTH_X = 425,
                            MONTH_Y = 70,
                            MONTH_SIZE = 40,
                            ARROW_SIZE = 25,
                            DAY_X = 100,
                            DAY_Y = 122,
                            DAY_SIZE = 100,
                            LIST_X = 200,
                            LIST_Y = 122,
                            LIST_WIDTH = 600,
                            LIST_HEIGHT = 400;
    private Calendar c;

    private boolean mainScreen;

    // Constructor
    public CalendarView(Calendar c) {
        this.mainScreen = true;
        this.c = c;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Calendar");
        this.setVisible(true);
    }

    // Getters and Setters


    public void setMainScreen() {
        this.mainScreen = !mainScreen;
    }

    // Other Methods
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        if (mainScreen) paintMonth(g);
        else paintDay(g);
    }

    public void paintMonth (Graphics g) {
        int x = BUFFER;
        int y = BUFFER + TITLE_BAR + 10;
        g.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                g.drawRect(x, y, DAY_WIDTH, DAY_HEIGHT);
                x += DAY_WIDTH;
            }
            y += DAY_HEIGHT;
            x = BUFFER;
        }
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, MONTH_SIZE));
        g.drawString("January", MONTH_X, MONTH_Y);
        g.drawImage(new ImageIcon("Resources/AbcteachImage1.png").getImage(), LEFT_X, ARROW_Y, ARROW_SIZE,
                ARROW_SIZE, this);
        g.drawImage(new ImageIcon("Resources/AbcteachImage2.png").getImage(), RIGHT_X, ARROW_Y, ARROW_SIZE,
                ARROW_SIZE, this);
    }

    public void paintDay (Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, DAY_SIZE));
        g.drawString("1", DAY_X, DAY_Y);
        g.drawRect(LIST_X, LIST_Y, LIST_WIDTH, LIST_HEIGHT);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        g.drawString("New Year's Day", 225, 222);
    }
}
