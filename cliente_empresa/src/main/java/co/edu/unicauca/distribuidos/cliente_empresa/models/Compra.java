package co.edu.unicauca.distribuidos.cliente_empresa.models;

/*
 * Clase Compra encapsula los datos que 
 * viajan entre el cliente y servidor
 */

public class Compra {
    private int valorCompra;
    private String lugarCompra;
    private String fechaHoraCompra;

    public Compra() {
        // Constructor de la clase
    }

    public Compra(int valorCompra, String lugarCompra, String fechaHoraCompra) {
        this.valorCompra = valorCompra;
        this.lugarCompra = lugarCompra;
        this.fechaHoraCompra = fechaHoraCompra;
    }

    public int getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(int valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getLugarCompra() {
        return lugarCompra;
    }

    public void setLugarCompra(String lugarCompra) {
        this.lugarCompra = lugarCompra;
    }

    public String getFechaHoraCompra() {
        return fechaHoraCompra;
    }

    public void setFechaHoraCompra(String fechaHoraCompra) {
        this.fechaHoraCompra = fechaHoraCompra;
    }

}
