package krestnol;

class HumanPlayer implements IPlayer
{
    private String sign;
    private String name;
    private View w;
    private boolean result;

    HumanPlayer(View w)
    {
        this.w = w;
        result = false;
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
        result = false;
        w.addListeners(this.getSign());        
    }

    public boolean notifyIP()
    {
        return result;
    }

    public void setTrue()
    {
        result = true;
    }
}
