package krestnol;

class HumanPlayer implements IPlayer
{
    private String sign;
    private String name;
    private View w;
    private boolean isReadyToHod = true;

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
        if(isReadyToHod == true)
        {
            w.addListeners(this.getSign());     
        }
    }
    
    public void setReadyToHod(boolean value)
    {    
        isReadyToHod = value;
    }
}