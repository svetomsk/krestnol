package krestnol;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;
class Kontroler{
    final Model m = new Model();
    HumanPlayer pl1 = new HumanPlayer("Player1","X");
    HumanPlayer pl2 = new HumanPlayer("Player2","O");
    View w = new View();
    Kontroler(){
        w.show();
        for(int i = 0; i < 3; i++){
            for(int g =0; g < 3;g++){
                try {
                    if(m.who()==true){
                        w.addListener(w.keys[g], i, g, pl1);
                    }else{
                        w.addListener(w.keys[g], i, g, pl2);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    /*public void button(final JButton jbt, final int i,final int g){
       jbt.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          jbt.setText("X");
                          n[i][g]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }
                      else{
                          jbt.setText("0");
                          n[i][g]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                      jbt.setEnabled(false);
                      x+=1;
                  }
              }
           }); 
    }
    JLabel result;

    JButton key1, key2, key3, key4, key5, key6, key7, key8, key9;
    JButton[] keys={key1, key2, key3, key4, key5, key6, key7, key8, key9};

    int i = 0,  x = 1, y = 3;
    int[][]n= new int[3][3];
    View w = new View();

   
    Kontroler(){
       w.show();
       for (int i=0;i<3;i++){
           for(int g=0;g<3;g++){
               n[i][g]=y;
               y++;
           }
       }
       
       /*result=new JLabel(" ");
       result.setForeground(Color.blue);
       result.setPreferredSize(new Dimension(50,20));
       JFrame pole=new JFrame("X vs. O");
       pole.setBackground(Color.red);
       pole.setLayout(new FlowLayout());
       pole.setBounds(400,400,220,270);
       pole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       for(i=0;i<9;i++){
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

       exit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent y){
               System.exit(1);
           }
       });
       newn.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent t){
              int h=3;
              for (int i=0;i<3;i++)
                  for(int g=0;g<3;g++){
                      n[i][g]=h;
                      h++;
                  }
              for(i=0;i<9;i++){
                  keys[i].setEnabled(true);
                  keys[i].setText(" ");
              }
              result.setText("Anyone");
          }
       });
       about.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent t){
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
      keys[0].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          keys[0].setText("X");
                          n[0][0]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }
                      else{
                          keys[0].setText("0");
                          n[0][0]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                      keys[0].setEnabled(false);
                      x+=1;
                  }
              }
           });
           keys[1].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          keys[1].setText("X");
                          n[0][1]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }
                      else{
                          keys[1].setText("0");
                          n[0][1]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                      keys[1].setEnabled(false);
                      x+=1;
                  }
              }
           });
           keys[2].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          keys[2].setText("X");
                          n[0][2]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }
                      else{
                          keys[2].setText("0");
                          n[0][2]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                      keys[2].setEnabled(false);
                      x+=1;
                  }
              }
           });
           keys[3].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          keys[3].setText("X");
                          n[1][0]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }
                      else{
                          keys[3].setText("0");
                          n[1][0]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                      keys[3].setEnabled(false);
                      x+=1;
                  }
              }
           });
           keys[4].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          keys[4].setText("X");
                          n[1][1]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }

                      else{
                          keys[4].setText("0");
                          n[1][1]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                      keys[4].setEnabled(false);
                      x+=1;
                  }
              }
           });
           keys[5].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          keys[5].setText("X");
                          n[1][2]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }
                      else{
                           keys[5].setText("0");
                          n[1][2]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                       keys[5].setEnabled(false);
                      x+=1;
                  }
              }
           });
           keys[6].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          keys[6].setText("X");
                          n[2][0]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }
                      else{
                          keys[6].setText("0");
                          n[2][0]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                      keys[6].setEnabled(false);
                      x+=1;
                  }
              }
           });
           keys[7].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          keys[7].setText("X");
                          n[2][1]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }
                      else{
                          keys[7].setText("0");
                          n[2][1]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                      keys[7].setEnabled(false);
                      x+=1;
                  }
              }
           });
           keys[8].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(m.mg(n)!=true)
                  {
                      if (x%2!=0){
                          keys[8].setText("X");
                          n[2][2]=1;
                          if(m.mg(n)==true){
                              result.setText("X win");
                          }
                      }
                      else{
                          keys[8].setText("0");
                          n[2][2]=0;
                          if(m.mg(n)==true){
                              result.setText("O win");
                          }
                      }
                      keys[8].setEnabled(false);
                      x+=1;
                  }
              }
           });

       if(result.getText().equals(" ")){
           result.setText("Anyone");
       }
       for(i=0;i<9;i++){
           pole.add(keys[i]);
       }

       pole.add(result);
       pole.setVisible(true);
    }*/

}
