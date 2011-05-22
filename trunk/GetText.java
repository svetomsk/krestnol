package krestnol;
import java.io.*;
import java.util.ResourceBundle;
class GetText
{
    private ResourceBundle bundle;

    GetText()throws IOException
    {
        bundle = ResourceBundle.getBundle("krestnol.krestnol");      
    }

    public String getSign1()
    {
        return bundle.getString("krestnol.sign1");
    }

    public String getSign2()
    {
        return bundle.getString("krestnol.sign2");
    }

    public String getFrameName()
    {
        return bundle.getString("krestnol.frameName");
    }

    public String getGameOver()
    {
        return bundle.getString("krestnol.gameOver");
    }

    public String getDrawn()
    {
        return bundle.getString("krestnol.drawn");
    }

    public String getXwin()
    {
        return bundle.getString("krestnol.xWin");
    }

    public String getOwin()
    {
        return bundle.getString("krestnol.oWin");
    }

    public String getStat()
    {
        return bundle.getString("krestnol.stat");
    }

    public String getNew()
    {
        return bundle.getString("krestnol.new");
    }

    public String getExit()
    {
        return bundle.getString("krestnol.exit");
    }

    public String getCpName()
    {
        return bundle.getString("krestnol.getCpName");
    }

    public String alonePlayer()
    {
        return bundle.getString("krestnol.alonePlayer");
    }

    public String twoPlayers()
    {
        return bundle.getString("krestnol.twoPlayers");
    }

    public String getWinner()
    {
        return bundle.getString("krestnol.getWinner");
    }

    public String getLoser()
    {
        return bundle.getString("krestnol.getLoser");
    }

    public String getFirstName()
    {
        return bundle.getString("krestnol.getFirstName");
    }

    public String getSecondName()
    {
        return bundle.getString("krestnol.getSecondName");
    }

    public String getPlay()
    {
        return bundle.getString("krestnol.getPlay");
    }
}