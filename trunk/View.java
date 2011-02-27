package krestnol;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.Border;
class View extends EventDispatcher
{
    private GetText text;
    private Model mod;
    private Cama cama;
    private Window pole, ask, statistica;
    private JLabel result, hum1, hum2;
    private JTextField pl1, pl2;
    private JButton key1, key2, key3, key4, key5, key6, key7, key8, key9, OK, newGame, exit, stat;
    private JButton[] keys={key1, key2, key3, key4, key5, key6, key7, key8, key9};
    private int i = 0;
    private int width = 3;
    private Stat s1;
    private int height = 3;
    private int length = width*height;
    private boolean ready = false;

    public View(final Model model, final GetText txt, final Stat st, Cama cm)throws IOException, InterruptedException
    {
        this.text = txt;
        s1 = st;
        mod = model;
        cama = cm;
        createLabel();
        createFrame();
        addNewGame();
        addStat();
        addExit();
    }

    private void createLabel()
    {
        result=new JLabel(" ");
        result.setPreferredSize(new Dimension(150,20));
    }

    private void createFrame()
    {
        pole=new Window();
        pole.setLayout(new FlowLayout());
        pole.setSize(new Dimension(200,270));
        pole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pole.setResizable(false);
    }

    private void addNewGame()
    {
        newGame = new JButton(text.novaya());
        newGame.setPreferredSize(new Dimension(77,20));
        Border border = BorderFactory.createLineBorder(Color.decode("#90C0FF"), 2);
        newGame.setBorder(border);
        newGame.setBackground(Color.decode("#20B0FF"));
        newGame.addActionListener(new ActionListener(){
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
    }

    private void addStat()
    {
        stat = new JButton("Statistica");
        stat.setPreferredSize(new Dimension(80,20));
        Border border = BorderFactory.createLineBorder(Color.decode("#90C0FF"), 2);
        stat.setBorder(border);
        stat.setBackground(Color.decode("#20B0FF"));
        stat.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent t)
            {
               createTable(s1.getArray());
           }
        });       
    }

    private void createTable(String [][] objects)
    {
        String [] head = { "Winer","Loser" };
        JTable table = new JTable(objects,head);
        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        statistica = new Window();
        statistica.setSize(new Dimension(200,200));
        statistica.setResizable(false);
        statistica.add(scroll);
        statistica.setVisible(true);
    }

    private void addExit()
    {
        Border bord = BorderFactory.createLineBorder(Color.decode("#90C0FF"), 2);
        exit = new JButton(text.vyxod());
        exit.setBorder(bord);
        exit.setBackground(Color.decode("#20B0FF"));
        exit.setPreferredSize(new Dimension(77,20));
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent t)
            {
                try
                {
                    cama.upTo();
                }catch(IOException exs)
                {
                    System.out.println("See in addExit()");
                }
                System.exit(0);
            }
        });
    }

    synchronized void getNames(final HumanPlayer p1, final HumanPlayer p2)
    {
        ready = false;
        ask = new Window();
        ask.setLayout(new FlowLayout());
        ask.setResizable(false);
        ask.setSize(new Dimension(200,150));
        ask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hum1 = new JLabel("1st name: ");
        hum2 = new JLabel("2nd name: ");
        pl1 = new JTextField(7);
        pl2 = new JTextField(7);
        OK = new JButton("PLAY");
        OK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent t)
            {
                if(!pl1.getText().equals("")&&!pl1.getText().equals(""))
                {
                    p1.setName(pl1.getText());
                    p2.setName(pl2.getText());
                    ask.setVisible(false);
                }
            }
        });
        ask.add(hum1);
        ask.add(pl1);
        ask.add(hum2);
        ask.add(pl2);
        ask.add(OK);
        ask.setVisible(true);
        while(ask.isVisible() == true)
        {
            ready = false;
        }
        ready = true;
        notify();
    }

    synchronized void show()throws IOException, InterruptedException
    {
        while(ready != true) wait();
        mod.writeField();
        for(i=0;i<9;i++)
        {
            keys[i]=new JButton(" ");
            Border br = BorderFactory.createLineBorder(Color.decode("#20B0FF"), 2);
            keys[i].setBorder(br);
            keys[i].setPreferredSize(new Dimension(50,50));
            keys[i].setBackground(Color.BLUE);
        }
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
        pole.add(newGame);
        pole.add(exit);
        pole.add(stat);
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
