package krestnol;
import java.io.*;
class GetText
{
    private BufferedReader bufR;
    private int kol = 14;
    private String [] value = new String[kol];

    GetText()throws IOException
    {
       bufR = new BufferedReader(new FileReader("src/krestnol/text.txt"));
       for(int i = 0; i < kol; i++)
       {
           value[i] = bufR.readLine();
       }
    }

    public String name1()
    {
        return value[0];
    }

    public String sign1()
    {
        return value[1];
    }

    public String name2()
    {
        return value[2];
    }

    public String sign2()
    {
        return value[3];
    }

    public String frameName()
    {
        return value[4];
    }

    public String fail()
    {
        return value[5];
    }

    public String igra()
    {
        return value[6];
    }

    public String spravke()
    {
        return value[7];
    }

    public String vyxod()
    {
        return value[8];
    }

    public String novaya()
    {
        return value[9];
    }

    public String obigre()
    {
        return value[10];
    }

    public String anyone()
    {
        return value[11];
    }

    public String html()
    {
        return value[12];
    }

    public String win()
    {
        return value[13];
    }
}