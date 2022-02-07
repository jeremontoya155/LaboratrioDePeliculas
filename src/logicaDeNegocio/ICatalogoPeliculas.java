
package logicaDeNegocio;


public interface ICatalogoPeliculas {
    //Definimos por defecto el nombre a utilizar
    String NOMBRE_RECURSO="peliculas.txt";
    
    void agregarPeliculas(String nombrePelicula);

    void  listarPeliculas();
    
    void  buscarPeliculas(String buscar);
    
    void iniciarCatalogoDePeliculas();
    

}
