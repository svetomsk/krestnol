package krestnol;

import java.util.logging.Level;
import java.util.logging.Logger;

class Main{
    static public void main(String[]args){
        try {
            Kontroler kntr = new Kontroler();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

