package krestnol;
class ComputerPlayer extends EventDispatcher implements IPlayer
{
    private String sign;
    private String name;
    private Model m;
    private View w;
    private boolean value;
    ComputerPlayer(Model m, View w)
    {
        sign = "X";
        name = "Computer";
        this.m = m;
        this.w = w;
    }

    public void setSign(String value){}

    public void setName(String value){}

    public String getSign()
    {
        return sign;
    }

    public String getName()
    {
        return name;
    }

    public void hod()
    {
        w.delListeners();
        for(int i = 0; i < 3; i++)
        {
            for(int g = 0; g < 3; g++)
            {
                if(m.getF(i, g) == true)
                {
                    w.setButtonText("O", i, g);
                }
            }
        }
    }

    public boolean notifyIP()
    {
        return value;
    }

    public void setTrue(){};
}
