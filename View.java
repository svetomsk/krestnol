package krestnol;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class View
{
     Model mod;
     public View(Model model){
        mod = model;
     }
     private JFrame pole, ask;
     private JTextField player1, player2;
     private JLabel result, nik1, nik2;
     public JButton key1, key2, key3, key4, key5, key6, key7, key8, key9, OK;
     public JButton[] keys={key1, key2, key3, key4, key5, key6, key7, key8, key9};
     private int i = 0;       
     public void show()throws IOException, InterruptedException
     {
        mod.writeField();
        result=new JLabel(" ");
        result.setForeground(Color.blue);
        result.setPreferredSize(new Dimension(70,20));
        pole=new JFrame("X vs. O");
        pole.setBackground(Color.red);
        pole.setLayout(new FlowLayout());
        pole.setBounds(400,400,210,270);
        pole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(i=0;i<9;i++)
        {
            keys[i]=new JButton(" ");
            keys[i].setBackground(Color.RED);
            keys[i].setPreferredSize(new Dimension(50,50));
            keys[i].setBackground(Color.BLUE);
        }

        JMenuBar menu=new JMenuBar();
        menu.setBackground(Color.black);

        JMenu file=new JMenu("Файл");
        file.setForeground(Color.blue);
        JMenu game=new JMenu("Игра");
        game.setForeground(Color.blue);
        JMenu help=new JMenu("Справка");
        help.setForeground(Color.blue);

        JMenuItem exit=new JMenuItem("Выход");
        exit.setBackground(Color.white);
        JMenuItem newn=new JMenuItem("Новая");
        newn.setBackground(Color.white);
        JMenuItem about=new JMenuItem("Об игре..");
        about.setBackground(Color.white);

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
                 try
                 {
                     mod = new Model();
                     mod.writeField();
                     mod.check = true;
                     for (i = 0; i < 9; i++)
                     {
                         keys[i].setEnabled(true);
                         keys[i].setText(" ");
                     }
                     result.setText("Anyone");
                 } catch (IOException ex) {
                     Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                 }
           }
        });
        about.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent t)
           {
               JFrame p=new JFrame("Справка");
               p.setBounds(400,410,130,120);
               p.setLayout(new FlowLayout());
               JLabel b=new JLabel("<html>Это пробный<br>" +
                       "вариант игры<br>" +
                       "крестики-нолики<br>");
               JScrollPane d=new JScrollPane(b);
               d.setPreferredSize(new Dimension(110,70));
               p.add(d);
               p.setVisible(true);
           }
        });
        file.add(exit);
        game.add(newn);
        help.add(about);

        menu.add(file);
        menu.add(game);
        menu.add(help);

        pole.add(menu);
        if(result.getText().equals(" "))
        {
            result.setText("Anyone");
        }
        for(i=0;i<9;i++)
        {
            pole.add(keys[i]);
        }

        pole.add(result);
        pole.setVisible(true);
       
    }

    public void addListener(final JButton jbt, final int i,final int g,
            final HumanPlayer player1, final HumanPlayer player2)throws IOException
    {
        mod.readField();
        jbt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(mod.checkField()!=true)
                {
                    if(mod.who() == true)
                    {
                        try
                        {
                            jbt.setText(player1.getSign());
                            mod.setField(i, g, player1.getSign());
                            mod.writeField();
                            jbt.setEnabled(false);
                            if (mod.checkField() == true)
                            {
                                result.setText(player1.getName() + " win");
                            }
                        } catch (IOException ex)
                        {
                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else
                    {
                        try
                        {
                            jbt.setText(player2.getSign());
                            mod.setField(i, g, player2.getSign());
                            mod.writeField();
                            jbt.setEnabled(false);
                            if (mod.checkField() == true)
                            {
                                result.setText(player2.getName()+ " win");
                            }
                        }
                        catch(IOException ex1)
                        {
                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                }
            }
       });
    }
}