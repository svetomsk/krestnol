package krestnol;

import java.util.ArrayList;
import java.util.List;

public class EventDispatcher
{
    List<IListener> listeners;

    public EventDispatcher()
    {
        listeners = new ArrayList<IListener>();
    }

    public void addEventListener(IListener listener)
    {
        listeners.add(listener);
    }

    public void dispatchEvent(int x, int y)
    {
        for(IListener listener : listeners)
        {
            listener.listen(x, y);
        }
    }
}
