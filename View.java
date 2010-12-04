package krestnol;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class View{
    Model mod = new Model();      
    private JFrame pole, ask;
    private JTextField player1, player2;
    private JLabel result, nik1, nik2;
    public JButton key1, key2, key3, key4, key5, key6, key7, key8, key9, OK;
    public JButton[] keys={key1, key2, key3, key4, key5, key6, key7, key8, key9};
    private int i = 0;
    String [][] mas = new String[3][3];
   /* public void getNames(final HumanPlayer hp1,final HumanPlayer hp2){
        ask = new JFrame("Имена игроков");
        ask.setBounds(200,200,100,100);
        ask.setLayout(new FlowLayout());
        ask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nik1 = new JLabel("1-st name: ");
        nik2 = new JLabel("2-nd name: ");
        player1 = new JTextField(7);
        player2 = new JTextField(7);
        OK = new JButton("OK");
        OK.setPreferredSize(new Dimension(20,30));
        OK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent df){
                hp1.name = player1.getText();
                hp2.name = player2.getText();
                ask.setVisible(false);
            }
        });
        ask.add(nik1);
        ask.add(player1);
        ask.add(nik2);
        ask.add(player2);
        ask.add(OK);
        ask.setVisible(true);
    }*/
    public void show(){
       result=new JLabel(" ");
       result.setForeground(Color.blue);
       result.setPreferredSize(new Dimension(50,20));
       pole=new JFrame("X vs. O");
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
              mod.newg();
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
       if(result.getText().equals(" ")){
           result.setText("Anyone");
       }
       for(i=0;i<9;i++){
           pole.add(keys[i]);
       }

       pole.add(result);
       pole.setVisible(true);
       keys[0].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                try {                    
                    mod.readField(mas);                    
                    if (mod.mg(mas) != true) {                        
                        if (mod.who() == true) {                            
                            keys[0].setText("X");
                            mas[0][0] = "1";
                            if (mod.mg(mas) == true) {
                                result.setText("X win");
                            }
                        } else {
                            keys[0].setText("0");
                            mas[0][0] = "0";
                            if (mod.mg(mas) == true) {
                                result.setText("O win");
                            }
                        }
                        keys[0].setEnabled(false);
                    }
                    mod.writeField(mas);
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           });
           keys[1].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  try {
                    mod.readField(mas);
                    if (mod.mg(mas) != true) {
                        if (mod.who() == true) {
                            keys[1].setText("X");
                            mas[0][1] = "1";
                            if (mod.mg(mas) == true) {
                                result.setText("X win");
                            }
                        } else {
                            keys[1].setText("0");
                            mas[0][1] = "0";
                            if (mod.mg(mas) == true) {
                                result.setText("O win");
                            }
                        }
                        keys[1].setEnabled(false);
                    }
                    mod.writeField(mas);
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           });
           keys[2].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  try {
                    mod.readField(mas);
                    if (mod.mg(mas) != true) {
                        if (mod.who() == true) {
                            keys[2].setText("X");
                            mas[0][2] = "1";
                            if (mod.mg(mas) == true) {
                                result.setText("X win");
                            }
                        } else {
                            keys[2].setText("0");
                            mas[0][2] = "0";
                            if (mod.mg(mas) == true) {
                                result.setText("O win");
                            }
                        }
                        keys[2].setEnabled(false);
                    }
                    mod.writeField(mas);
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           });
           keys[3].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  try {
                    mod.readField(mas);
                    if (mod.mg(mas) != true) {
                        if (mod.who() == true) {
                            keys[3].setText("X");
                            mas[1][0] = "1";
                            if (mod.mg(mas) == true) {
                                result.setText("X win");
                            }
                        } else {
                            keys[3].setText("0");
                            mas[1][0] = "0";
                            if (mod.mg(mas) == true) {
                                result.setText("O win");
                            }
                        }
                        keys[3].setEnabled(false);
                    }
                    mod.writeField(mas);
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           });
           keys[4].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  try {
                    mod.readField(mas);
                    if (mod.mg(mas) != true) {
                        if (mod.who() == true) {
                            keys[4].setText("X");
                            mas[1][1] = "1";
                            if (mod.mg(mas) == true) {
                                result.setText("X win");
                            }
                        } else {
                            keys[4].setText("0");
                            mas[1][1] = "0";
                            if (mod.mg(mas) == true) {
                                result.setText("O win");
                            }
                        }
                        keys[4].setEnabled(false);
                    }
                    mod.writeField(mas);
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           });
           keys[5].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  try {
                    mod.readField(mas);
                    if (mod.mg(mas) != true) {
                        if (mod.who() == true) {
                            keys[5].setText("X");
                            mas[1][2] = "1";
                            if (mod.mg(mas) == true) {
                                result.setText("X win");
                            }
                        } else {
                            keys[0].setText("0");
                            mas[1][2] = "0";
                            if (mod.mg(mas) == true) {
                                result.setText("O win");
                            }
                        }
                        keys[5].setEnabled(false);
                    }
                    mod.writeField(mas);
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           });
           keys[6].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  try {
                    mod.readField(mas);
                    if (mod.mg(mas) != true) {
                        if (mod.who() == true) {
                            keys[6].setText("X");
                            mas[2][0] = "1";
                            if (mod.mg(mas) == true) {
                                result.setText("X win");
                            }
                        } else {
                            keys[6].setText("0");
                            mas[2][0] = "0";
                            if (mod.mg(mas) == true) {
                                result.setText("O win");
                            }
                        }
                        keys[6].setEnabled(false);
                    }
                    mod.writeField(mas);
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           });
           keys[7].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  try {
                    mod.readField(mas);
                    if (mod.mg(mas) != true) {
                        if (mod.who() == true) {
                            keys[7].setText("X");
                            mas[2][1] = "1";
                            if (mod.mg(mas) == true) {
                                result.setText("X win");
                            }
                        } else {
                            keys[7].setText("0");
                            mas[2][1] = "0";
                            if (mod.mg(mas) == true) {
                                result.setText("O win");
                            }
                        }
                        keys[7].setEnabled(false);
                    }
                    mod.writeField(mas);
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           });
           keys[8].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  try {
                    mod.readField(mas);
                    if (mod.mg(mas) != true) {
                        if (mod.who() == true) {
                            keys[8].setText("X");
                            mas[2][2] = "1";
                            if (mod.mg(mas) == true) {
                                result.setText("X win");
                            }
                        } else {
                            keys[8].setText("0");
                            mas[2][2] = "0";
                            if (mod.mg(mas) == true) {
                                result.setText("O win");
                            }
                        }
                        keys[8].setEnabled(false);
                    }
                    mod.writeField(mas);
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           });
   }
   /* public void addListener(final JButton jbt, final int i,final int g)throws IOException{
       mod.readField(mas);
       if(mod.who() == true){
           jbt.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent t){
                   if(mod.mg(mas)!=true){
                       jbt.setText("X");
                      mas[i][g] = "1";
                      try {
                        mod.writeField(mas);
                      } catch (IOException ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      if(mod.mg(mas)==true){
                            result.setText("X win");
                        }                      
                      jbt.setEnabled(false);   
                   }
               }
           });
           
       }else if(mod.who()==false){
           jbt.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent s){
                    jbt.setText("O");
                      mas[i][g] = "0";
                      try {
                        mod.writeField(mas);
                      } catch (IOException ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      if(mod.mg(mas)==true){
                            result.setText("O win");
                        }                      
                      jbt.setEnabled(false); 
               }
           });
        }
    }*/
}
