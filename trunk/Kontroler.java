package krestnol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Kontroler implements IListener
{
    final private Model m = new Model();
    View w;
    HumanPlayer pl1;
    HumanPlayer pl2;
    Kontroler() throws InterruptedException
    {
        try
        {
            w = new View(m);
            w.addEventListener(this);
            pl1 = new HumanPlayer();
            pl2 = new HumanPlayer();
            pl1.setName("Player1");
            pl1.setSign("X");
            pl2.setName("Player2");
            pl2.setSign("O");           
        } catch (IOException ex)
        {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    if (m.checkField() == true) {
                        w.setResultText(pl1.getName());
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
                    }
                }
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
