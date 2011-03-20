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

    public void newModel()
    {
        for(IListener listener : listeners)
        {
            listener.newModel();
        }
    }

    public void dispatchEvent(String s, int x, int y)
    {
        for(IListener listener : listeners)
        {
            listener.listen(s, x, y);
        }
    }

    public void goOne()
    {
        for(IListener listener : listeners)
        {
            listener.goOne();
        }
    }

    public void goTwo()
    {
        for(IListener listener : listeners)
        {
            listener.goTwo();
        }
    }

    public void trueOne()
    {
        for(IListener listner : listeners)
        {
            listner.trueOne();
        }
    }
}