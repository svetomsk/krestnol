package krestnol;

import java.util.ArrayList;
import java.util.List;

public class EventDispatcher
{    
    List<IListener> listeners;
    public void game()
    {
        for(IListener i : listeners)
        {
            i.game();
        }
    }

    public void newGame()
    {
        for(IListener l : listeners)
        {
            l.newGame();
        }
    }

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
    
    public void setPlayerName(String s1, String s2)
    {
        for(IListener listener : listeners)
        {
            listener.setPlayerName(s1,s2);
        }
    }
        
    public void ComputerVsPlayer()
    {
        for(IListener listener : listeners)
        {
            listener.ComputerVsPlayer();
        }
    }
    
    public void PlayerVsPlayer()
    {
        for(IListener listener : listeners)
        {
            listener.PlayerVsPlayer();
        }
    }

    public void dispatchEvent(String s, int x, int y)
    {
        for(IListener listener : listeners)
        {
            listener.listen(s, x, y);
        }
    }
    
    public void setTrue(String s)
    {
        for(IListener listener : listeners)
        {
            listener.setTrue(s);
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
}