package krestnol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Kontroler implements IListener
{
    private GetText text;
    private Model m ;
    private View w;
    private Cama cm;
    private Stat st;
    private IPlayer pl1;
    private IPlayer pl2;
    boolean temp;
    Kontroler() throws InterruptedException
    {
        try
        {
            cm = new Cama();
            st = new Stat();
            st.updateFrom();
            text = new GetText();
            m = new Model(text);
            w = new View(m, text, st, cm);
            w.addEventListener(this);
            w.getNames();
            pl1.setSign(text.getSign1());
            pl2.setSign(text.getSign2());
            w.show();
        } catch (IOException ex)
        {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void newModel()
    {
        m = new Model(text);
    }

    public void listen(String s,int x, int y)
    {
        temp = false;
        try
        {
            m.readField();
            if (m.checkField() != true)
            {
                w.setButtonText(s, x, y);
                m.setField(x, y, s);
                m.writeField();
                cm.add(m.getField());
                cm.nowPos(m.getField(),s);
                inListen(s);
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }        
        if(temp == false)
        {
            try
            {
                if (m.isAll())
                {
                    try
                    {
                        w.endWindow(text.getDrawn());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void inListen(String s) throws IOException
    {
        if(m.checkField() == true)
        {
            temp = true;
            if(s.equals(text.getSign1()))
            {
                w.delListeners();
                st.add(pl1.getName(), pl2.getName());
                st.updateTo();
                st.updateFrom();
                try 
                {
                    w.endWindow(text.getXwin());
                    pl2.setReadyToHod(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else
            {
                w.delListeners();
                st.add(pl2.getName(), pl1.getName());
                st.updateTo();
                st.updateFrom();
                try 
                {
                    w.endWindow(text.getOwin());
                    pl1.setReadyToHod(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void setTrue(String s)
    {
        if(s.equals("1"))
        {
            pl1.setReadyToHod(true);
        }
        else
        {
            pl2.setReadyToHod(true);
        }
    }

    public void game()
    {
        pl1.hod();
    }

    public void goOne()
    {
        pl1.hod();        
    }

    public void goTwo()
    {
        pl2.hod();
    }

    public void newGame()
    {
        w.delListeners();
        pl1.hod();
    }
    
    public void PlayerVsPlayer()
    {
        pl1 = new HumanPlayer(w);
        pl2 = new HumanPlayer(w);
    }
    
    public void ComputerVsPlayer()
    {        
        pl2 = new HumanPlayer(w);
        pl1 = new ComputerPlayer(m,w,st,cm,pl2.getName(),text);
        pl1.setName(text.getCpName());
    }
    
    public void setPlayerName(String s1, String s2)
    {
        if(s1.equals("1"))
        {
            pl1.setName(s2);
        }else
        {
            pl2.setName(s2);
        }
    }
}
