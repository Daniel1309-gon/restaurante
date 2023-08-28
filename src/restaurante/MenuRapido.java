package restaurante;


public class MenuRapido extends Menu
{
    protected String tipo;
    protected String salsas;
    protected boolean enCombo;
    
    public MenuRapido(String nombreComida, double precio, String tipo, String salsas, boolean enCombo)
    {
        super(nombreComida, precio);
        this.tipo = tipo;
        this.salsas = salsas;
        this.enCombo = enCombo;
    }
    
    public String getTipo()
    {
        return tipo;
    }
    
    public String getSalsas()
    {
        return salsas;
    }
    
    public boolean getEnCombo()
    {
        return enCombo;
    }
    
    @Override
    public String getInfoTotal()
    {
        return(getComida() + " tiene un valor de: " + getPrecio() + "\n"
                + "Es de tipo: " + getTipo() + "\n"
                + "Tiene las salsas: " + getSalsas() + "\n"
                + "En combo? " + getEnCombo());
    }
}
