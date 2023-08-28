package restaurante;

public class MetodoPagoPaypal extends MetodoPago
{
    protected String email;
    
    public MetodoPagoPaypal(String medio, int valorPagar, String email)
    {
        super(medio, valorPagar);
        this.email = email;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    @Override
    public String generarFactura()
    {
        return("Se pagarán " + getValorPagar() + "por el medio " + getMedio() + "\n"
                + "por la cuenta de paypal asociada al correo: " + getEmail());
    }
}
