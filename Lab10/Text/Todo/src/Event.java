import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event implements Comparable<Event> {
    private LocalDateTime deadline;
    private String description;

    public Event(LocalDateTime deadline, String description){
        this.deadline = deadline;
        this.description = description;
    }

    public Event(int Y, int M, int D, int h, int m ){

    }
    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
