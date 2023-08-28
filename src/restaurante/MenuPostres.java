package restaurante;


public class MenuPostres extends Menu
{
    protected String sabor;
    protected int numeroCalorias;
    
    public MenuPostres(String sabor, int numeroCalorias, String nombreComida, double precio)
    {
        super(nombreComida, precio);
        this.sabor = sabor;
        this.numeroCalorias = numeroCalorias;
    }
    public String getSabor()
    {
        return sabor;
    }
    public int getCalorias()
    {
        return numeroCalorias;
    }
    @Override
    public String getInfoTotal()
    {
        return(getComida() + " tiene un valor de: " + getPrecio() + "\n"
                + "Sabor: " + getSabor() + "\n"
                + "Numero de calorias: " + getCalorias());
    }
}
