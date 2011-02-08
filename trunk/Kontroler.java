package krestnol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Kontroler implements IListener
{
    private GetText text;
    private Model m = new Model();
    private View w;
    private Stat st;
    private final HumanPlayer pl1 = new HumanPlayer();
    private final HumanPlayer pl2 = new HumanPlayer();
    Kontroler() throws InterruptedException
    {
        try
        {
            st = new Stat();
            st.updateFrom();
            text = new GetText();
            w = new View(m, text, st);
            w.addEventListener(this);
            w.getNames(pl1, pl2);            
            pl1.setSign(text.sign1());          
            pl2.setSign(text.sign2());
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
                    if (m.checkField() == true) 
                    {
                        w.setResultText(pl1.getName());
                        st.add(pl1.getName(), pl2.getName());
                        st.updateTo();
                        st.updateFrom();
                    }                    
                }
                else
                {                   
                    w.setButtonText(pl2.getSign(), x, y);
                    m.setField(x, y, pl2.getSign());
                    m.writeField();
                    if (m.checkField() == true) 
                    {
                        w.setResultText(pl2.getName());
                        st.add(pl2.getName(), pl1.getName());
                    st.updateTo();
                    st.updateFrom();
                    }
                }                
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
