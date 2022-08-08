package co.edu.unicauca.distribuidos.core.repositories;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.models.Compra;
/*
 * El signo @ indica al compilador que lo que sigue
 * es una anotación
 */

/*
 * @Service permite que spring cree automaticamente objetos
 * de una clase
 */
@Service

/*
 * En la clase CompraRepository se crean los métodos:
 * para registrar una compra y para listar las mismas de un cliente en
 * particular.
 */
public class CompraRepository {

    private HashMap<String, ArrayList<Compra>> mapaCompra;
    private ArrayList<Compra> listaCompraTemp = null;

    public CompraRepository() {
        this.mapaCompra = new HashMap<>();
    }

    public Compra registrarCompra(String idCompra, Compra objRegistrarCompra) {
        Compra objCompra = null;
        if (this.mapaCompra.get(idCompra) != null) {
            if (this.mapaCompra.get(idCompra).add(objRegistrarCompra)) {
                System.out.println("Nueva compra registrada");
                objCompra = objRegistrarCompra;
            }
        } else {
            listaCompraTemp = new ArrayList<>();
            listaCompraTemp.add(objRegistrarCompra);
            if (mapaCompra.put(idCompra, listaCompraTemp) == null) {
                System.out.println("Nueva compra registrada");
                objCompra = objRegistrarCompra;
            }
        }
        return objCompra;
    }

    public ArrayList<Compra> listarComprasPorId(String id) {
        if (this.mapaCompra.get(id) != null) {
            return mapaCompra.get(id);
        }
        return null;
    }
}
