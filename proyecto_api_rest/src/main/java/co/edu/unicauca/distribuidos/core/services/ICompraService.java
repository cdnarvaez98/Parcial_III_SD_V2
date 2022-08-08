package co.edu.unicauca.distribuidos.core.services;

import java.util.ArrayList;

import co.edu.unicauca.distribuidos.core.models.Compra;

/*
 * Interface donde se definen los servicios que
 * pueden ser consumidos por el controlador
 */

public interface ICompraService {
    public Compra registrarCompra(String idCompra, Compra objRegistrarCompra);

    public ArrayList<Compra> listarCompras(String id);
}
