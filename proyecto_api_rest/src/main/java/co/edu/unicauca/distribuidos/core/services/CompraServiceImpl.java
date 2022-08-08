package co.edu.unicauca.distribuidos.core.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.models.Compra;
import co.edu.unicauca.distribuidos.core.repositories.CompraRepository;

/*
 * Clase CompraServiseImpl que implemnta la interface ICompraService
 * Se implementan los métodos registrar compra y listas compras
 */

/*
 * @Service permite que spring cree automaticamente objetos
 * de una clase
 */
@Service
public class CompraServiceImpl implements ICompraService {

    /*
     * La notación @Autowired hace que spring cree automáticamente un objeto de
     * la clase compraRepository
     */
    @Autowired
    private CompraRepository servicioAccesoDatos;

    @Override
    public Compra registrarCompra(String idCompra, Compra objRegistrarCompra) {
        return this.servicioAccesoDatos.registrarCompra(idCompra, objRegistrarCompra);
    }

    @Override
    public ArrayList<Compra> listarCompras(String id) {
        return this.servicioAccesoDatos.listarComprasPorId(id);
    }

}
