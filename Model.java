package krestnol;
import java.io.*;
class Model
{
    private boolean check = true;
    private int fieldX = 3;
    private int fieldY = 3;
    private String [][] field = new String[fieldX][fieldY];
    private String [] checkF = new String[fieldX*fieldY];
    public Model()
    {
        check = true;
        newg();
    }   

    public void newcheck()
    {
        check = true;        
    }
    private void newg()
    {
        int number = 1;

        for(int i = 0; i < fieldX; i++){
            for(int g = 0; g < fieldY; g++){
                field[i][g] = Integer.toString(number);
                number++;
            }
        }
    }  

    public void setField(int x, int y, String value)
    {
        field[x][y] = value;
    }

    public boolean who()
    {       
        boolean result = false;
        if(check == true)
        {           
            check = false;
            result = true;
        }else if(check == false)
        {          
            check = true;
            result = false;
        }
        return result;
    }
    public void readField()throws IOException
    {
        BufferedReader readF = new BufferedReader(new FileReader("pole.txt"));
        for(int i = 0; i < fieldX; i++){
            String[]read = readF.readLine().split(" ");
            System.arraycopy(read, 0, field[i], 0, 3);
        }
        readF.close();
        int t = 0;
        for(int i = 0; i < fieldX; i++)
        {
            for(int g = 0; g < fieldY; g++)
            {
                checkF[t] = field[i][g];
                t++;
            }
        }
    }

    public void writeField()throws IOException
    {
        BufferedWriter writeF = new BufferedWriter(new FileWriter("pole.txt"));
        for(int i = 0; i < fieldX; i++){
            for(int g = 0; g < fieldY; g++){
                writeF.write(field[i][g]+" ");
            }
            writeF.write("\r\n");
        }
        writeF.close();        
        int t = 0;
        for(int i = 0; i < fieldX; i++)
        {
            for(int g = 0; g < fieldY; g++)
            {
                checkF[t] = field[i][g];
                t++;
            }
        }
    }

    public boolean checkField()
    {
        boolean result = false;        
        for(int i = 0; i <= fieldX%3;i++)
        {
            for(int g = i; g <= fieldY%3;g++)
            {
                if(checkF[g].equals(checkF[g+4])&&checkF[g+4].equals(checkF[g+8]))
                {
                    result = true;
                }
                if(checkF[g+2].equals(checkF[g+4])&&checkF[g+4].equals(checkF[g+6]))
                {
                    result = true;
                }
            }
            for(int h = i; h < fieldY; h++)
            {
                if(checkF[h].equals(checkF[h+3])&&checkF[h+3].equals(checkF[h+6]))
                {
                    result = true;
                }
            }
            for(int h = i; h < fieldY*fieldX; h+=3)
            {
                if(checkF[h].equals(checkF[h+1])&&checkF[h+1].equals(checkF[h+2]))
                {
                    result = true;
                }
            }
        }
        return result;
    }
}
