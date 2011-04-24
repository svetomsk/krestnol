package krestnol;

import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class ComputerPlayer extends EventDispatcher implements IPlayer
{
    private String sign, sign1;
    private String name;
    private Stat st;
    private Cama cm;
    private Model m;
    private View w;
    private String name1, name2;
    private boolean value;
    private GetText txt;
    ComputerPlayer(Model m, View w, Stat st, Cama cm, String s1, String s2, GetText txt, String sign, String sign1)
    {
        this.txt = txt;
        this.sign = sign;
        this.sign1 = sign1;
        name = "Computer";
        this.m = m;
        this.w = w;
        this.st = st;
        this.cm = cm;
        name1 = s1;
        name2 = s2;
    }

    public void setSign(String value){}

    public void setName(String value){}

    public String getSign()
    {
        return sign;
    }

    public String getName()
    {
        return name;
    }

    public void hod()
    {
        boolean temp1 = false;
        try {
            System.out.println(m.isAll());
        } catch (IOException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        w.delListeners();
        boolean end = false;
        try {
            if (m.isAll() == true) {
                end = true;
                try {
                    w.endWindow("Drawn");
                    temp1= true;
                } catch (InterruptedException ex) {
                    Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(end == false && temp1 == false)
        {
            boolean temp = false;
            Random r = new Random();
            int x = 0;
            int y = 0;
            try {
                m.readField();
            } catch (IOException ex) {
                Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(m.getF(x, y) == false)
            {
                x = 0 + r.nextInt(3);
                y = 0 + r.nextInt(3);
            }
            w.setButtonText(sign,x,y);
            m.setField(x,y,sign);
            try {
                m.writeField();
            } catch (IOException ex) {
                Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                m.writeField();
            } catch (IOException ex) {
                Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(m.checkField() == true)
            {
                end = true;
               /* if(this.getSign().equals(sign))
                {*/
                    try {
                        w.delListeners();
                        w.setResultText(sign);
                        st.add(name1, name2);
                        st.updateTo();
                        st.updateFrom();
                        cm.endWin("1");
                        try {
                            System.out.println("HERE 3");
                            w.endWindow(txt.sign1()+ " win");
                            temp1 = true;
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
               /* }else
                {
                    try {
                        w.delListeners();
                        w.setResultText(name1);
                        st.add(name1, name2);
                        st.updateTo();
                        st.updateFrom();
                        cm.endWin("2");
                        try {
                            w.endWindow("O win");
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
            }
            try {
                if (m.isAll() == true && temp1 == false)
                {
                    try
                    {
                        w.endWindow("Drawn");
                    } catch (InterruptedException ex)
                    {
                        Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    temp1 = true;
                    end = true;
                }
            } catch (IOException ex) {
                Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(end == false && temp1 == false)
            {
                if(sign.equals("X"))
                {
                    w.goTwo();
                }else
                {
                    w.goOne();
                }
            }
        }
        try {
            System.out.println(m.isAll());
        } catch (IOException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean notifyIP()
    {
        return value;
    }

    public void setTrue(){};
}
