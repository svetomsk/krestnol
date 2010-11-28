package krestnol;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class View{
    Model mod = new Model();      
    private JFrame pole;
    private JLabel result;
    public JButton key1, key2, key3, key4, key5, key6, key7, key8, key9;
    public JButton[] keys={key1, key2, key3, key4, key5, key6, key7, key8, key9};
    private int i = 0;
    int [][] mas = new int[3][3];    
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
   }  
    public void addListener(final JButton jbt, final int i,final int g, final HumanPlayer pl)throws IOException{
       mod.readField(mas);
       jbt.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent t){
                  if(mod.mg(mas)!=true)
                  {
                      if (pl.sign.equals("X")){
                        jbt.setText("X");
                        mas[i][g]=1;
                        try {
                            mod.writeField(mas);
                        } catch (IOException ex) {
                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(mod.mg(mas)==true){
                            result.setText("X win");
                        }
                      }
                      else{
                        jbt.setText("0");
                        mas[i][g]=0;
                        try {
                            mod.writeField(mas);
                        } catch (IOException ex) {
                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(mod.mg(mas)==true){
                            result.setText("O win");
                        }
                      }
                      jbt.setEnabled(false);                      
                  }
              }
           }); 
    }
}
