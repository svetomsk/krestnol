package krestnol;
class Position 
{
    private String [][] position;
    private int prioritet;
    private int width = 3;
    private int height = 3;
    Position(int pr, String [][] value)
    {
        prioritet = pr;
        position = new String[width][height];
        for(int i = 0; i < width; i++)
        {
            System.arraycopy(value[i], 0, position[i], 0, height);
        }
    }

    public String[][] getArray()
    {
        return position;
    }

    public void setPrioritet(int a)
    {
        prioritet = a;
    }

    public int getPrioritet()
    {
        return prioritet;
    }
}
