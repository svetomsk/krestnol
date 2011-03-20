package krestnol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Kontroler implements IListener
{
    private GetText text;
    private Model m = new Model();
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
            w = new View(m, text, st, cm);
            w.addEventListener(this);
            pl1 = new HumanPlayer(w);
            pl3 = new HumanPlayer(w);
            w.getNames(pl1, pl3);
            pl1.setSign("Х");
            pl3.setSign("O");
           // pl2.setSign(text.sign2());
            w.show();
        } catch (IOException ex)
        {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void newModel()
    {
        m = new Model();
    }

    public void listen(int x, int y)
    {
        try
        {
            m.readField();
            if (m.checkField() != true)
            {                               
                if (m.who() == true)
                {                    
                    w.setButtonText(pl1.getSign(), x, y);
                    m.setField(x, y, pl1.getSign());  
                    
                    m.writeField();
                    String [][] a = m.getField();
                    cm.add(a);
                    cm.nowPos(a, "1");
                    
                    if (m.checkField() == true) 
                    {
                        w.setResultText(pl1.getName());
                        st.add(pl1.getName(), pl3.getName());
                        st.updateTo();
                        st.updateFrom();
                        cm.endWin("1");
                    }                    
                }
                else
                {                   
                    w.setButtonText(pl3.getSign(), x, y);
                    m.setField(x, y, pl3.getSign());
                    cm.add(m.getField());
                    cm.nowPos(m.getField(), "2");
                    m.writeField();
                    if (m.checkField() == true) 
                    {
                        w.setResultText(pl3.getName());
                        st.add(pl3.getName(), pl1.getName());
                        st.updateTo();
                        st.updateFrom();
                        cm.endWin("2");
                    }
                }                
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*public void game()
    {        
        pl1.hod();

        pl3.hod();
    }*/
}
