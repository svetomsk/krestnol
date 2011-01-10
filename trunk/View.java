package krestnol;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class View extends EventDispatcher
{
     private GetText text;
     private Model mod;
     private JFrame pole;     
     private JLabel result;
     private JButton key1, key2, key3, key4, key5, key6, key7, key8, key9, OK;
     private JButton[] keys={key1, key2, key3, key4, key5, key6, key7, key8, key9};
     private JMenuItem about, newn, exit;
     private JMenuBar menu;
     private JMenu file, game, help;
     private int i = 0;
     private int width = 3;
     private int height = 3;
     private int length = width*height; 
     
     public View(final Model model, final GetText txt/*, Kontroler knt*/)throws IOException, InterruptedException
     {        
         this.text = txt;
         mod = model;         
         createLabel();
         createFrame();
         createMenu();
         addMenuListeners();
         show();
     }
     
     private void createLabel()
     {         
         result=new JLabel(" ");
         result.setForeground(Color.blue);
         result.setPreferredSize(new Dimension(70,20));
     }
     
     private void createFrame()
     {
         pole=new JFrame(text.frameName());
         pole.setBackground(Color.red);
         pole.setLayout(new FlowLayout());
         pole.setBounds(400,400,210,270);
         pole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         pole.setResizable(false);
     }
     
     private void createMenu()
     {
         menu=new JMenuBar();
         menu.setBackground(Color.black);

         file=new JMenu(text.fail());
         file.setForeground(Color.blue);
         game=new JMenu(text.igra());
         game.setForeground(Color.blue);
         help=new JMenu(text.spravke());
         help.setForeground(Color.blue);

         exit=new JMenuItem(text.vyxod());
         exit.setBackground(Color.white);
         newn=new JMenuItem(text.novaya());
         newn.setBackground(Color.white);
         about=new JMenuItem(text.obigre());
         about.setBackground(Color.white);
     }
     
     private void addMenuListeners()
     {
         exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent y)
            {
                System.exit(0);
            }
        });
        newn.addActionListener(new ActionListener()
        {

           public void actionPerformed(ActionEvent t)
           {
               mod = new Model();           
               newModel();
               mod.newcheck();
                 try
                 {                                
                     mod.writeField();                     
                     for (i = 0; i < 9; i++)
                     {
                         keys[i].setEnabled(true);
                         keys[i].setText(" ");
                     }
                     result.setText(text.anyone());
                 } catch (IOException ex) {
                     Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                 }
           }
        });
        about.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent t)
           {
               JFrame p=new JFrame(text.spravke());
               p.setBounds(400,410,130,120);
               p.setLayout(new FlowLayout());
               JLabel b=new JLabel(text.html());
               JScrollPane d=new JScrollPane(b);
               d.setPreferredSize(new Dimension(110,70));
               p.add(d);
               p.setVisible(true);
           }
        });
     }
     
     private void show()throws IOException, InterruptedException
     {
        mod.writeField();               
        for(i=0;i<9;i++)
        {
            keys[i]=new JButton(" ");
            keys[i].setBackground(Color.RED);
            keys[i].setPreferredSize(new Dimension(50,50));
            keys[i].setBackground(Color.BLUE);
        }
        menu=new JMenuBar();
        menu.setBackground(Color.black);          
        file.add(exit);
        game.add(newn);
        help.add(about);
        menu.add(file);
        menu.add(game);
        menu.add(help);
        pole.add(menu);
        for(i = 0; i <9; i++)
        {
            addButton(keys[i]);
        }

        if(result.getText().equals(" "))
        {
            result.setText(text.anyone());
        }
        for(i=0;i<9;i++)
        {
            pole.add(keys[i]);
        }
        pole.add(result);
        pole.setVisible(true);

    }
    public void setResultText(String ResultText)
    {
        result.setText(ResultText + " " + text.win());
    }
    public void setButtonText(String ButtonText, int x, int y)
    {
        keys[x*width+y].setText(ButtonText);
        keys[x*width+y].setEnabled(false);
    }
    private void addButton(final JButton jbt)
    {
        jbt.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               dispatchEvent(getPos(jbt)[0], getPos(jbt)[1]);               
           }
        });
    }
    private int[] getPos(final JButton btn)
    {
        int [] results = new int[2];
        width = 3;
        height = 3;
        length = width*height;
        for(i = 0; i < length; i++)
        {
            if(btn.equals(keys[i]))                            
            {
                results[0] = i / width;
                results[1] = i % width;
            }
        }        
        return results;
    }    
}
