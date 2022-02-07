
package accesos;

import Excepciones.AccesoDatosEx;
import domainPeliculas.Peliculas;
import java.util.List;


public interface IAccesosADatos {
    //Recordar usar el tthows por el caso de que me pudisese tirar un error 
    boolean existe(String nombreArchivo)throws AccesoDatosEx;
    List<Peliculas> listar(String nombre)throws AccesoDatosEx;
    void escribir(Peliculas pelicula,String nombreArchivo,boolean anexo)throws AccesoDatosEx;
    String buscar(String nombreArchivo,String buscar)throws AccesoDatosEx;
    
    
    void crear(String nombreArchivo)throws AccesoDatosEx;
    void borrar(String nombreArchivo)throws AccesoDatosEx;
    
    
    
    
}
