import java.util.*;

/**
 * Created by jiyarza on 06/02/2018.
 */
public enum EventType {
    Start,
    End,
    Hit,
    Miss;

    private Set<EventListener> listeners = new TreeSet<>();
    private Deque<Event> events = new ArrayDeque<>();

    public Set<EventListener> getListeners() {
        return listeners;
    }

    public void addListener(EventListener e) {
        listeners.add(e);
    }

    public boolean removeListener(EventListener e) {
        return listeners.remove(e);
    }

    public void addEvent(Event e) {
        events.addLast(e);
    }

    public Event getNextEvent() {
        return events.getFirst();
    }

    public void notifyNextEvent() {
        Event e = getNextEvent();
        for (EventListener el: listeners) {
            el.notify(e);
        }
    }
}
