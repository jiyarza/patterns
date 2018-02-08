import java.util.*;

/**
 * Created by jiyarza on 06/02/2018.
 */
public class EventManager {

    private Deque<Event> events;
    private Set<EventListener> listeners;
    private EventManager instance = null;
    private static int count = 0;

    private EventManager() {
        listeners = new TreeSet<>();
        events = new ArrayDeque<>();
    }

    public EventManager getInstance() {
        if (count > 0) throw new IllegalStateException();
        if (instance == null) {
            instance = new EventManager();
            count = 1;
        }
        return instance;
    }

    public void throwEvent(EventType type, Entity e) {
        Event event = new Event(type, e);
        events.addLast(event);
    }

    private void update() {
        for (EventType t: EventType.values()) {
            t.notifyNextEvent();
        }
    }

}
