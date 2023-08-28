package restaurante;

public class MetodoPagoTarjeta extends MetodoPago
{
    protected int numeroTarjeta;
    protected String titularTarjeta;
    
    public MetodoPagoTarjeta(String medio, int valorPagar, int numeroTarjeta, String titularTarjeta)
    {
        super(medio, valorPagar);
        this.numeroTarjeta = numeroTarjeta;
        this.titularTarjeta = titularTarjeta;
    }
    
    public int getNumero()
    {
        return numeroTarjeta;
    }
    
    public String getTitular()
    {
        return titularTarjeta;
    }
    
    @Override
    public String generarFactura()
    {
        return("Se pagarán " + getValorPagar() + "por el medio " + getMedio() + "\n"
                + "Numero de tarjeta: " + getNumero() + "\n"
                + "Titular de la tarejta: " + getTitular());
    }
}
