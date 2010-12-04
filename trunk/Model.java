package krestnol;
import java.io.*;
class Model{
    public boolean check = true;
    public String [][] n = new String[3][3];
    public void newg(){
        for(int i = 0; i < 3; i++){
            for(int g = 0; g < 3; g++){
                n[i][g] = "3";
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
        for(int i = 0; i < 3; i++){
            String[]read = readF.readLine().split(" ");
            System.arraycopy(read, 0, n[i], 0, 3);
        }
        readF.close();
    }
    public void writeField(String n[][])throws IOException{
        BufferedWriter writeF = new BufferedWriter(new FileWriter("pole.txt"));
        for(int i = 0; i < 3; i++){
            for(int g = 0; g < 3; g++){
                writeF.write(n[i][g]+" ");
            }
            writeF.write("\r\n");
        }
        writeF.close();
    }    
    public boolean mg(String n[][]){
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
