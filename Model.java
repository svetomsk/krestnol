package krestnol;
import java.io.*;
class Model{
    public boolean check = true;
    public int [][] n = new int[3][3];
    public void newg(){
        for(int i = 0; i < 3; i++){
            for(int g = 0; g < 3; g++){
                n[i][g] = 3;
            }
        }
    }
    public boolean who(){
        if(check == true){
            return true;
        }else return false;
    }
    public void readField(int n[][])throws IOException{
        BufferedReader readF = new BufferedReader(new FileReader("pole.txt"));
        for(int i = 0; i < 3; i++){
            String[]read = readF.readLine().split(" ");
            for(int g = 0; g < 3; g++){
                n[i][g] = Integer.valueOf(read[g]);
            }
        }
        readF.close();
    }
    public void writeField(int n[][])throws IOException{
        BufferedWriter writeF = new BufferedWriter(new FileWriter("pole.txt"));
        for(int i = 0; i < 3; i++){
            for(int g = 0; g < 3; g++){
                writeF.write(Integer.toString(n[i][g])+" ");
            }
            writeF.write("\r\n");
        }
        writeF.close();
    }
    public int getN(int i, int g){
        return n[i][g];
    }
    public boolean mg(int n[][]){
        boolean b=false;
        if(n[0][0]==n[1][1]&& n[1][1]==n[2][2]){
            b=true;
        }
        else if(n[0][0]==n[1][0]&&n[1][0]==n[2][0]){
            b=true;
        }
        else if(n[0][0]==n[0][1]&&n[0][1]==n[0][2]){
            b=true;
        }
        else if(n[2][0]==n[2][1]&&n[2][1]==n[2][2]){
            b=true;
        }
        else if(n[1][0]==n[1][1]&&n[1][1]==n[1][2]){
            b=true;
        }
        else if(n[0][2]==n[1][1]&&n[1][1]==n[2][0]){
            b=true;
        }
        else if(n[0][2]==n[1][2]&&n[1][2]==n[2][2]){
            b=true;
        }
        else if(n[0][1]==n[1][1]&&n[1][1]==n[2][1]){
            b=true;
        }
        return b;
    }
}
