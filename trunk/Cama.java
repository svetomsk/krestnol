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
    private ArrayList<Position> now, now1;

    Cama() throws IOException
    {
        br = new BufferedReader(new FileReader("src/krestnol/pos.txt"));
        size = Integer.valueOf(br.readLine());
        list = new ArrayList<Position>();
        now = new ArrayList<Position>();
        now1 = new ArrayList<Position>();
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

    public boolean contains(String[][]value)
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

    public Position get(String[][]value)
    {
        Position result = null;
        boolean ch;
        for(int i = 0; i < size; i++)
        {
            tmp = list.get(i).getArray();
            ch = true;
            for(int t = 0; t < width; t++)
            {
                for(int g = 0; g < height; g++)
                {
                    if(!tmp[t][g].equals(value[t][g]))
                    {
                        ch = false;
                        break;
                    }
                }
            }
            if(ch == true)
            {
                result = list.get(i);
                break;
            }
        }
        return result;
    }

    public void nowPos(String[][]value, String s)
    {
        if(s.equals("X"))
        {
            if(this.contains(value) == false)
            {
                now.add(this.get(value));
            }else
            {
                now.add(new Position(10,value));
            }
        }else
        {
            if(this.contains(value) == false)
            {
                now1.add(this.get(value));
            }else
            {
                now1.add(new Position(10,value));
            }
        }
    }

    public void endWin(String s)
    {
        if(s.equals("1"))
        {
            for(Position pos : now)
            {
                this.get(pos.getArray()).setPrioritet(pos.getPrioritet()+1);
            }
            for(Position pos : now1)
            {
                this.get(pos.getArray()).setPrioritet(pos.getPrioritet()-1);
            }
        }else
        {
            for(Position pos : now)
            {
                this.get(pos.getArray()).setPrioritet(pos.getPrioritet()-1);
            }
            for(Position pos : now1)
            {
                this.get(pos.getArray()).setPrioritet(pos.getPrioritet()+1);
            }
        }
    }
}
