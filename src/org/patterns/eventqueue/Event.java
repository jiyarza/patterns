/**
 * Created by jiyarza on 06/02/2018.
 */
public class Event {

    final EventType type;
    final Entity source;
    final long millis;

    public Event(final EventType t, final Entity e) {
        type = t;
        source = e;
        millis = System.currentTimeMillis();
    }

    public EventType getType() {
        return type;
    }

    public Entity getSource() {
        return source;
    }

    public long getMillis() {
        return millis;
    }

}
