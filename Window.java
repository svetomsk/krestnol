package krestnol;
import java.awt.*;
import javax.swing.*;
public class Window extends JFrame
{
    public Window()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;       
        setLocation ((int) (screenWidth / 2.5), (int) (screenHeight / 2.5));
        Image img = kit.getImage("src/krestnol/krestik_nolik.gif");
        setIconImage(img);
    }
}
