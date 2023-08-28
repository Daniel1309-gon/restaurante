package restaurante;

public class MetodoPagoEfectivo extends MetodoPago
{
    protected double dineroEntregado, vueltas;
    public MetodoPagoEfectivo(String medio, int valorPagar, double dineroEntregado, double vueltas)
    {
        super(medio, valorPagar);
        this.dineroEntregado = dineroEntregado;
        this.vueltas = dineroEntregado-valorPagar;
    }
    public double getVueltas()
    {
        return vueltas;
    }
    @Override
    public String generarFactura()
    {
        return("Se pagarán " + getValorPagar() + "por el medio " + getMedio() + "\n"
                + "y se devolveran: " + getVueltas() + "al cliente.");
    }
}
