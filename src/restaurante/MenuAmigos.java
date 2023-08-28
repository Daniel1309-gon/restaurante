package restaurante;

public class MenuAmigos extends Menu
{
    protected int cantidadPersonas;
    
    public MenuAmigos(String nombreComida, double precio, int cantidadPersonas)
    {
        super(nombreComida, precio);
        this.cantidadPersonas = cantidadPersonas;
    }
    public int getCantidadPersonas()
    {
        return cantidadPersonas;
    }
     @Override
     public String getInfoTotal()
    {
        return(getComida() + " tiene un valor de: " + getPrecio() + "\n"
                + "Y es para: " + getCantidadPersonas() + "personas");
    }
}
