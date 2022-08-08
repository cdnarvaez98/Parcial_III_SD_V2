package co.edu.unicauca.distribuidos.cliente_empresa.servicios;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

import co.edu.unicauca.distribuidos.cliente_empresa.models.Compra;
import java.util.ArrayList;

public class ClienteServices {
    /**
     * La clase ClienteServices envia petiiciones con los verbos
     * GET y POST y convierte objetos java a JSON y convierte la rta
     * del servidor JSON
     * 
     * El atributo endPoint almancena la ruta al servicio web,
     * el cual escucha por un puerto
     * 
     * El atributo objClientePeticiones almacena la referencia a un objeto
     * encargado de enviar las peticiones
     */
    private String endPoint;
    private Client objClientePeticiones;

    public ClienteServices() {
        this.endPoint = "http://localhost:5000/api/compras";
        /*
         * Se crea un nuevo cliente invocando al método newCLiente()
         * Utilizando el método register() se le envia un objeto encargado
         * de hacer las conversiones a JSON
         */
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    /**
     * Método para consultar una compra
     * 
     * @param id
     * @return listaCompra
     */

    public ArrayList<Compra> consultarCompras(String idPersona) {
        ArrayList<Compra> listaCompra = null;
        /*
         * En la variable target se almacena el objetivo
         * al cual se le envian las peticiones (ruta al servicio REST)
         */
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + idPersona);
        /*
         * Contrucción de petición y definición del tipo de formato
         * aceptado como rta
         */
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        /*
         * Envio de petición con el verbo GET y se pasa como argumento los metadatos
         * de la clase que utiliza la aplicación para la conversión de la rta del
         * servidor a JSON
         */
        listaCompra = objPeticion.get(new GenericType<ArrayList<Compra>>() {});
        return listaCompra;
    }

    /**
     * Método para registrar una compra
     * 
     * @param objCompraRegistrar, id
     * @return objCompra
     */

    public Compra registrarCompra(Compra objCompraRegistrar, String idPersona) {
        Compra objCompra = null;
        /*
         * El objeto de tipo WebTarget contiene el objetivo por
         * el cual se realizan las peticiones
         */
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + idPersona);
        /*
         * El método Entity define la información que ira en el cuerpo
         * de la petición y el formato de la información
         */
        Entity<Compra> data = Entity.entity(objCompraRegistrar, MediaType.APPLICATION_JSON_TYPE);
        /*
         * Contrucción de petición y definición del tipo de formato
         * aceptado como rta
         */
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        /*
         * Envio de petición con el verbo POST y se pasa como argumento los metadatos
         * de la clase que utiliza para la conversión de la rta del servidor a JSON
         */
        objCompra = objPeticion.post(data, Compra.class);
        return objCompra;
    }
}
