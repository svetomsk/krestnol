package krestnol;

import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class ComputerPlayer extends EventDispatcher implements IPlayer
{
    private String sign;
    private int width = 3, height = 3;
    private Stat st;
    private Cama cm;
    private Model m;
    private View w;
    private String name1, name2;
    private boolean isReadyToHod = true;
    private GetText txt;
    ComputerPlayer(Model m, View w, Stat st, Cama cm, String s1, GetText txt)
    {
        this.txt = txt;
        this.sign = txt.getSign1();
        this.m = m;
        this.w = w;
        this.st = st;
        this.cm = cm;
        name2 = s1;
    }
    
    public void setReadyToHod(boolean value)
    {
        isReadyToHod = value;
    }

    public void setSign(String value){}

    public void setName(String value)
    {
        name1 = value;
    }

    public String getSign()
    {
        return sign;
    }

    public String getName()
    {
        return name1;
    }

    public void hod()
    {
        if(isReadyToHod == true)
        {   
            boolean temp1 = false;
            w.delListeners();
            boolean end = false;
            try 
            {
                if (m.isAll() == true) {
                    end = true;
                    try 
                    {
                        w.endWindow("Drawn");
                        temp1= true;
                    } catch (InterruptedException ex) 
                    {
                        Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (IOException ex) 
            {
                Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(end == false && temp1 == false)
            {
                String [][] t = m.getField();
                boolean c = false;
                int curX = 0, curY = 0, curPrior = 0;
                for(int i = 0; i < width; i++)
                {
                    for(int g = 0; g < height; g++)
                    {
                        if(m.getF(i,g))
                        {
                            String f = m.getFieldMean(i, g);
                            m.setField(i, g, sign);
                            if(cm.contains(t) == false)
                            {
                                if(cm.get(t).getPrioritet() > curPrior)
                                {
                                    curX = i; curY = g;
                                    curPrior = cm.get(t).getPrioritet();
                                    c = true;
                                }
                            }
                            m.setField(i, g, f);
                        }
                    }
                }
                if(c == false)
                {
                    Random r = new Random();
                    try {
                        m.readField();
                    } catch (IOException ex) {
                        Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    while(m.getF(curX, curY) == false)
                    {
                        curX = 0 + r.nextInt(3);
                        curY= 0 + r.nextInt(3);
                    }
                }
                w.setButtonText(sign,curX,curY);                
                m.setField(curX,curY,sign);
                cm.add(m.getField());
                cm.nowPos(t, sign);
                try {
                    m.writeField();
                } catch (IOException ex) {
                    Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    m.readField();
                } catch (IOException ex) {
                    Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(m.checkField() == true)
                {
                    end = true;
                    if(sign.equals(txt.getSign1()))
                    {
                        try {
                            w.delListeners();
                            st.add(name1, name2);
                            st.updateTo();
                            st.updateFrom();
                            cm.endWin("1");
                            try {
                                w.endWindow(txt.getSign1()+ " win");
                                temp1 = true;
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else
                    {
                        try {
                            w.delListeners();
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
                    }
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
        }        
    }
}
