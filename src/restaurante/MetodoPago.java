package restaurante;

public class MetodoPago 
{
    protected double valorPagar;
    protected String medio;
    
    public MetodoPago(String medio, int valorPagar)
    {
        this.medio = medio;
        this.valorPagar = valorPagar;
    }
    public String getMedio()
    {
        return medio;
    }
    public double getValorPagar()
    {
       return valorPagar;
    }
    public String generarFactura()
    {
        return("Se pagarán " + getValorPagar() + "por el medio " + getMedio());
    }
}
