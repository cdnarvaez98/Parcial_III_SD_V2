package co.edu.unicauca.distribuidos.core.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.core.models.Compra;
import co.edu.unicauca.distribuidos.core.services.ICompraService;

/**
 * La anotación @RestController indica que los métodos del controlador serán
 * servicios que siguen el modelo REST.
 */
@RestController
/*
 * La anotación @RequestMapping indica que las rutas para acceder a los
 * servicios
 * que siguen el modelo REST deben tener el prefijo api.
 */
@RequestMapping("/api")
public class ClienteRestControllers {

    /*
     * La notación @Autowired hace que spring cree automáticamente un objeto de
     * la clase que implementa la interface ICompraService
     */
    @Autowired
    private ICompraService compraService;

    private final int VALOR_UMBRAL = 45000000;

    /*
     * La anotación @GetMapping asocia un método con un servicio
     * REST que recive peticiones mediante el verbo GET
     * 
     * La ruta /compras permite aceder al servicio web que retorna
     * la lista de compras
     * 
     * El método utiliza el objeto inyectado el cual
     * permite el acceso al medio de persistencia
     */
    @GetMapping("/compras/{idCompra}")
    public ArrayList<Compra> listarComprasPorId(@PathVariable String idCompra) {
        ArrayList<Compra> listaCompra = null;
        listaCompra = compraService.listarCompras(idCompra);
        return listaCompra;
    }

    /*
     * La anotación @PostMapping asocia un método con un servicio
     * REST que recive peticiones mediante el verbo POST
     * 
     * La ruta /compras permite aceder al servicio web que retorna
     * la lista de compras
     * 
     * La anotación @RequestBody asocia el parámetro de un método con los datos
     * almacenados en el cuerpo de la petición.
     * 
     * La anotación @PathVariable asocia el parámetro de un método con el
     * parámetro de la URL
     * 
     * El método utiliza el objeto inyectado (compraService) el cual
     * permite el acceso al medio de persistencia
     */
    @PostMapping("/compras/{idCompra}")
    public Compra registrarCompra(@RequestBody Compra objCompra, @PathVariable String idCompra) {
        Compra compra = null;

        int sumaCompras = 0;

        compra = compraService.registrarCompra(idCompra, objCompra);
        ArrayList<Compra> listCompras = compraService.listarCompras(idCompra);

        for (Compra compraRegistrada : listCompras) {
            sumaCompras += compraRegistrada.getValorCompra();

        }
        // validar si las compras del cliente superan los 45 millones
        // si es el caso
        if (sumaCompras > VALOR_UMBRAL) {
            // obtener la referencia remota
            // invocar el método remoto

            System.out.println("Valor mayor a 45 millones");
        } else {
            System.out.println("No es mayor a 45 millones");
        }

        return compra;
    }
}
