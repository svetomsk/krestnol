package krestnol;
import java.io.*;
import java.util.ArrayList;
class Cama
{
    private BufferedReader br;
    private BufferedWriter wr;
    private String [][] tmp;
    private int size;
    private int width = 3;
    private int height = 3;
    private ArrayList<Position> list;

    Cama() throws IOException
    {
        br = new BufferedReader(new FileReader("src/krestnol/pos.txt"));
        size = Integer.valueOf(br.readLine());
        list = new ArrayList<Position>();
        for(int i = 0; i < size; i++)
        {
            tmp = new String[width][height];
            int pr = Integer.valueOf(br.readLine());
            for(int g = 0; g < width; g++)
            {
                String [] read = br.readLine().split(" ");
                for(int m = 0; m < height; m++)
                {
                    tmp[g][m] = read[m];
                }
            }
            list.add(new Position(pr, tmp));
        }
        br.close();
    }
  
    public void add(String[][] value)
    {
        boolean check = true;
        if(contains(value) == false)
        {
            check = false;
        }
        if(check == true)
        {
            Position pos = new Position(10,value);
            list.add(pos);
            size++;
        }
    }

    public void upTo() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/krestnol/pos.txt"));
        bw.write(Integer.toString(size)+"\r\n");
        for(Position pos : list)
        {            
            tmp = pos.getArray();
            bw.write(Integer.toString(pos.getPrioritet())+"\r\n");
            for(int i = 0; i < width; i++)
            {
                for(int g = 0; g < height; g++)
                {
                    bw.write(tmp[i][g]+" ");
                }
                bw.write("\r\n");
            }
        }
        bw.close();
    }

    private boolean contains(String[][]value)
    {
        boolean result = true;
        boolean [] check = new boolean[size];
        for(int i = 0; i < size; i++)
        {
            tmp = list.get(i).getArray();
            check[i] = true;
            for(int g = 0; g < width; g++)
            {
                for(int m = 0; m < height; m++)
                {
                    if(!tmp[g][m].equals(value[g][m]))
                    {
                        check[i] = false;                        
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < size; i++)
        {
            if(check[i] == true)
            {
                result = false;               
            }
        }
        return result;
    }
}
