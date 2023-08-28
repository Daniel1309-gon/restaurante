package restaurante;

public class Menu 
{
    double precio;
    String nombreComida;
    
    public Menu(String nombreComida, double precio)
    {
        this.precio = precio;
        this.nombreComida = nombreComida;
    }
    public double getPrecio()
    {
        return precio;
    }
    public String getComida()
    {
        return nombreComida;
    }
    public String getInfoTotal()
    {
        return(getComida() + " tiene un valor de: " + getPrecio());
    }
}
