package krestnol;

import java.util.logging.Level;
import java.util.logging.Logger;

class HumanPlayer implements IPlayer
{
    private String sign;
    private String name;
    private View w;
    private boolean result;

    HumanPlayer(View w)
    {
        this.w = w;
    }

    public void setName(String nik)
    {
        name = nik;
    }

    public String getName()
    {
        return name;
    }

    public void setSign(String XorO)
    {
        sign = XorO;
    }

    public String getSign()
    {
        return sign;
    }

    public void hod()
    {
        w.addListeners();
    }

    public boolean notifyIP()
    {
        return result;
    }
}
