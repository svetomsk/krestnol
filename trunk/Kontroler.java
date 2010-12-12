package krestnol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Kontroler{
    final private Model m = new Model();
    HumanPlayer pl1 = new HumanPlayer();
    HumanPlayer pl2 = new HumanPlayer();
    View w = new View(m);
    Kontroler() throws InterruptedException
    {
        try
        {
            pl1.setName("Player1");
            pl1.setSign("X");
            pl2.setName("Player2");
            pl2.setSign("O");
            w.show();           
            w.addListener(w.keys[0], 0, 0, pl1, pl2);
            w.addListener(w.keys[1], 0, 1, pl1, pl2);
            w.addListener(w.keys[2], 0, 2, pl1, pl2);
            w.addListener(w.keys[3], 1, 0, pl1, pl2);
            w.addListener(w.keys[4], 1, 1, pl1, pl2);
            w.addListener(w.keys[5], 1, 2, pl1, pl2);
            w.addListener(w.keys[6], 2, 0, pl1, pl2);
            w.addListener(w.keys[7], 2, 1, pl1, pl2);
            w.addListener(w.keys[8], 2, 2, pl1, pl2);
        } catch (IOException ex)
        {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
