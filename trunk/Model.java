package krestnol;
import java.io.*;
class Model
{
    public boolean check = true;
    private int fieldX = 3;
    private int fieldY = 3;
    private String [][] field = new String[fieldX][fieldY];

    public Model()
    {
         newg();
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

    public String getField(int x, int y)
    {
        return field[x][y];
    }

    public void setField(int x, int y, String value)
    {
        field[x][y] = value;
    }

    public boolean who()
    {
        if(check == true)
        {
            check = false;
            return true;
        }else
        {
            check = true;
            return false;
        }
    }

    public void readField()throws IOException
    {
        BufferedReader readF = new BufferedReader(new FileReader("pole.txt"));
        for(int i = 0; i < fieldX; i++){
            String[]read = readF.readLine().split(" ");
            System.arraycopy(read, 0, field[i], 0, 3);
        }
        readF.close();
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
    }

    public boolean checkField()
    {
        boolean b=false;
        if(field[0][0].equals(field[1][1])&& field[1][1].equals(field[2][2]))
        {
            b=true;
        }
        else if(field[0][0].equals(field[1][0])&&field[1][0].equals(field[2][0]))
        {
            b=true;
        }
        else if(field[0][0].equals(field[0][1])&&field[0][1].equals(field[0][2]))
        {
            b=true;
        }
        else if(field[2][0].equals(field[2][1])&&field[2][1].equals(field[2][2]))
        {
            b=true;
        }
        else if(field[1][0].equals(field[1][1])&&field[1][1].equals(field[1][2]))
        {
            b=true;
        }
        else if(field[0][2].equals(field[1][1])&&field[1][1].equals(field[2][0]))
        {
            b=true;
        }
        else if(field[0][2].equals(field[1][2])&&field[1][2].equals(field[2][2]))
        {
            b=true;
        }
        else if(field[0][1].equals(field[1][1])&&field[1][1].equals(field[2][1]))
        {
            b=true;
        }
        return b;
    }
}
