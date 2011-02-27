package krestnol;
import java.io.*;
class Position 
{
    private String [][] position;
    private int prioritet;
    private int width = 3;
    private int height = 3;
    Position(int pr, String [][] value)
    {
        prioritet = pr;
        position = new String[width][height];
        for(int i = 0; i < width; i++)
        {
            for(int g = 0; g < height; g++)
            {
                position[i][g] = value[i][g];
            }
        }
    }

    public String[][] getArray()
    {
        return position;
    }

    public void setPrioritet(int a)
    {
        prioritet = a;
    }

    public int getPrioritet()
    {
        return prioritet;
    }
}
