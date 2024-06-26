import javax.swing.*;
import java.awt.*;

// By Tyler Hinkie in 05.2024

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
            MONTH_X = 400,
            MONTH_Y = 70,
            MONTH_SIZE = 40,
            ARROW_SIZE = 25,
            DAY_X = 100,
            DAY_Y = 122,
            DAY_SIZE = 100,
            LIST_X = 205,
            LIST_Y = 122,
            LIST_WIDTH = 750,
            LIST_HEIGHT = 400,
            NUM_SIZE = 10;
    private Calendar c;

    private boolean mainScreen;
    private int monthIndex;
    private int dayIndex;

    // Constructor
    public CalendarView(Calendar c) {
        this.mainScreen = true;
        this.monthIndex = 0;
        this.dayIndex = 0;
        this.c = c;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Calendar");
        this.setVisible(true);
    }

    // Getters and Setters

    public int getMonthIndex() {
        return monthIndex;
    }

    public void incrementMonthIndex() {
        if (monthIndex == 11) monthIndex = 0;
        else monthIndex++;
    }

    public void decrementMonthIndex() {
        if (monthIndex == 0) monthIndex = 11;
        else monthIndex--;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public boolean isMainScreen() {
        return mainScreen;
    }

    public void setMainScreen() {
        this.mainScreen = !mainScreen;
    }

    // Other Methods
    @Override
    // I split this up into paintMonth() and paintDay() to have two different paint methods for each screen so that with
    // my variables I could use the same information regardless what day or month it was
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        if (mainScreen) paintMonth(g);
        else paintDay(g);
    }

    public void paintMonth(Graphics g) {
        int x = BUFFER;
        int y = BUFFER + TITLE_BAR + 10;
        g.setColor(Color.BLACK);
        int num = 0;
        int days = c.getMonths()[monthIndex].getNumDays();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                num = i * 7 + j + 1;
                g.drawRect(x, y, DAY_WIDTH, DAY_HEIGHT);
                if (num <= days) {
                    g.setFont(new Font(Font.MONOSPACED, Font.BOLD, NUM_SIZE));
                    g.drawString(num + "", x + 3, y + 10);
                }
                x += DAY_WIDTH;
            }
            y += DAY_HEIGHT;
            x = BUFFER;
        }
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, MONTH_SIZE));
        g.drawString(c.getMonths()[monthIndex].getName(), MONTH_X, MONTH_Y);
        g.drawImage(new ImageIcon("Resources/Abc-teachImage1.png").getImage(), LEFT_X, ARROW_Y, ARROW_SIZE,
                ARROW_SIZE, this);
        g.drawImage(new ImageIcon("Resources/Abc-teachImage2.png").getImage(), RIGHT_X, ARROW_Y, ARROW_SIZE,
                ARROW_SIZE, this);
    }

    public void paintDay(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, DAY_SIZE));
        g.drawString(c.getMonths()[monthIndex].getDays()[dayIndex].getNumber() + "", DAY_X, DAY_Y);
        g.drawRect(LIST_X, LIST_Y, LIST_WIDTH, LIST_HEIGHT);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 80));
        c.getMonths()[monthIndex].getDays()[dayIndex].paint(g);
        g.drawImage(new ImageIcon("Resources/Abc-teachImage1.png").getImage(), LEFT_X, ARROW_Y, ARROW_SIZE,
                ARROW_SIZE, this);
    }
}
