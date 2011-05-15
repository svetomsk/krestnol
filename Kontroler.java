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
    private IPlayer pl3;
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
            pl1 =/* new HumanPlayer(w)*/ new ComputerPlayer(m,w,st,cm, "First","Second",text);
            pl2 = new HumanPlayer(w) /*new ComputerPlayer(m,w,st,cm, "Second","First",text)*/;
            w.getNames(pl1, pl2);
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
                if(m.checkField() == true)
                {
                    if(s.equals(text.getSign1()))
                    {
                        w.delListeners();
                       // w.setResultText(pl1.getName());
                        st.add(pl1.getName(), pl2.getName());
                        st.updateTo();
                        st.updateFrom();
                        try 
                        {
                            w.endWindow(text.getSign1() +  " win");
                            pl1.setReadyToHod(false);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else
                    {
                        w.delListeners();
                      //  w.setResultText(pl3.getName());
                        st.add(pl2.getName(), pl1.getName());
                        st.updateTo();
                        st.updateFrom();
                        try 
                        {
                            w.endWindow(text.getSign2() + " win");
                            pl1.setReadyToHod(false);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            if (m.isAll())
            {
                try
                {
                    w.endWindow("Drawn");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setCPtrue()
    {
        pl1.setReadyToHod(true);
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

    public void trueOne()
    {
        pl1.setTrue();
        w.delListeners();
    }

    public void newGame()
    {
        w.delListeners();
        pl1.hod();
    }
}
