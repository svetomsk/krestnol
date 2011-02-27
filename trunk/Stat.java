package krestnol;
import java.io.*;
import java.util.Formatter;
class Stat
{
    private BufferedReader br;
    private BufferedWriter bw;
    private int n;
    private String [][] games, save;
    private String [] read;
    private String e;

    public String[][] getArray()
    {
        return games;
    }
    public void updateFrom() throws IOException
    {
        File f = new File("src/krestnol/stat.txt");
        br = new BufferedReader(new FileReader(f));
        n = Integer.valueOf(br.readLine());
        br.readLine();
        games = new String[n][2];
        save = new String[n][2];
        for(int i = 0; i < n; i++)
        {
            e = br.readLine();
            e = e.trim();
            read = e.split(" ");
            games[i][0] = read[0];
            save[i][0] = read[0];
            games[i][1] = read[read.length-1];
            save[i][1] = read[read.length-1];
        }
    }

    public void add(String winer, String loser) throws IOException
    {
        games = new String[n+1][2];
        for(int i = 0; i < n; i++)
        {
            games[i][0] = save[i][0];
            games[i][1] = save[i][1];
        }
        games[n][0] = winer;
        games[n][1] = loser;
        save = new String[n+1][2];
        for(int i = 0; i <= n;i++)
        {
            save[i][0] = games[i][0];
            save[i][1] = games[i][1];
        }
        n++;
    }

    public void updateTo() throws IOException
    {
        bw = new BufferedWriter(new FileWriter("src/krestnol/stat.txt"));
        bw.write(Integer.toString(n)+"\r\n");
        Formatter fm = new Formatter();        
        fm.format("%-10s %10s\r\n", "Winer", "Loser");
        bw.write(fm.toString());
        for(int i = 0; i < n; i++)
        {
            Formatter fs = new Formatter();              
            fs.format("%-10s %10s\r\n", games[i][0], games[i][1]);
            bw.write(fs.toString());
        }
        bw.flush();
        bw.close();
    }
}
