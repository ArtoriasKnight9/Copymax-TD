package Modelo;


/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class Venta {
   int idventa,idusario,idcliente;
   String Usuario,Cliente,Items,correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   Double Subtotal, Impuesto,Descuento,Total,Recibido,Cambio;
  
   public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdusario() {
        return idusario;
    }

    public void setIdusario(int idusario) {
        this.idusario = idusario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getItems() {
        return Items;
    }

    public void setItems(String Items) {
        this.Items = Items;
    }

    public Double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public Double getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(Double Impuesto) {
        this.Impuesto = Impuesto;
    }

    public Double getDescuento() {
        return Descuento;
    }

    public void setDescuento(Double Descuento) {
        this.Descuento = Descuento;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public Double getRecibido() {
        return Recibido;
    }

    public void setRecibido(Double Recibido) {
        this.Recibido = Recibido;
    }

    public Double getCambio() {
        return Cambio;
    }

    public void setCambio(Double Cambio) {
        this.Cambio = Cambio;
        
        
    }
    
   
   
      
    
    
}
