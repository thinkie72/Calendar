public class Calendar {
    // Instance Variables
    private CalendarView window;

    // Constructor
    public Calendar() {
        window = new CalendarView(this);
    }

    // Getters and Setters

    // Other Methods
    public static void main(String[] args) {
        Calendar c = new Calendar();
    }
}
