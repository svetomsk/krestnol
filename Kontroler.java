package krestnol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Kontroler{
    final Model m = new Model();
    HumanPlayer pl1 = new HumanPlayer("X");
    HumanPlayer pl2 = new HumanPlayer("O");
    View w = new View();
    Kontroler() throws InterruptedException{
        try {                                    
            w.show();            
            w.addListener(w.keys[0], 0, 0, pl1.name, pl2.name);
            w.addListener(w.keys[1], 0, 1, pl1.name, pl2.name);
            w.addListener(w.keys[2], 0, 2, pl1.name, pl2.name);
            w.addListener(w.keys[3], 1, 0, pl1.name, pl2.name);
            w.addListener(w.keys[4], 1, 1, pl1.name, pl2.name);
            w.addListener(w.keys[5], 1, 2, pl1.name, pl2.name);
            w.addListener(w.keys[6], 2, 0, pl1.name, pl2.name);
            w.addListener(w.keys[7], 2, 1, pl1.name, pl2.name);
            w.addListener(w.keys[8], 2, 2, pl1.name, pl2.name);
        } catch (IOException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
