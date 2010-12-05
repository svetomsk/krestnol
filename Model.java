package krestnol;
import java.io.*;
class Model{
    public boolean check = true;
    private int fieldX = 3;
    private int fieldY = 3;
    public String [][] field = new String[fieldX][fieldY];
    public void newg(String [][] n){
        int number = 1;
        for(int i = 0; i < fieldX; i++){
            for(int g = 0; g < fieldY; g++){
                n[i][g] = Integer.toString(number);
                number++;
            }
        }
    }
    public boolean who(){
        if(check == true){
            check = false;
            return true;
        }else {
            check = true;
            return false;
        }
    }
    public void readField(String n[][])throws IOException{
        BufferedReader readF = new BufferedReader(new FileReader("pole.txt"));
        for(int i = 0; i < fieldX; i++){
            String[]read = readF.readLine().split(" ");
            System.arraycopy(read, 0, n[i], 0, 3);
        }
        readF.close();
    }
    public void writeField(String n[][])throws IOException{
        BufferedWriter writeF = new BufferedWriter(new FileWriter("pole.txt"));
        for(int i = 0; i < fieldX; i++){
            for(int g = 0; g < fieldY; g++){
                writeF.write(n[i][g]+" ");
            }
            writeF.write("\r\n");
        }
        writeF.close();
    }    
    public boolean checkField(String n[][]){
        boolean b=false;
        if(n[0][0].equals(n[1][1])&& n[1][1].equals(n[2][2])){
            b=true;
        }
        else if(n[0][0].equals(n[1][0])&&n[1][0].equals(n[2][0])){
            b=true;
        }
        else if(n[0][0].equals(n[0][1])&&n[0][1].equals(n[0][2])){
            b=true;
        }
        else if(n[2][0].equals(n[2][1])&&n[2][1].equals(n[2][2])){
            b=true;
        }
        else if(n[1][0].equals(n[1][1])&&n[1][1].equals(n[1][2])){
            b=true;
        }
        else if(n[0][2].equals(n[1][1])&&n[1][1].equals(n[2][0])){
            b=true;
        }
        else if(n[0][2].equals(n[1][2])&&n[1][2].equals(n[2][2])){
            b=true;
        }
        else if(n[0][1].equals(n[1][1])&&n[1][1].equals(n[2][1])){
            b=true;
        }
        return b;
    }
}
