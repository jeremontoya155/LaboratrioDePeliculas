/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaDeNegocio;

import Excepciones.AccesoDatosEx;
import accesos.AccesoDatosIML;
import accesos.IAccesosADatos;
import domainPeliculas.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class CatalogoPeliculas implements ICatalogoPeliculas{
    
    private final IAccesosADatos datos;

    public CatalogoPeliculas() {
        //Vemos de esta forma como tenemos hecha una implementaicon de acceso
        //a una clase que implementa ya otra interfaz
        this.datos = new AccesoDatosIML();
        
    }
    
    
    

    @Override
    public void agregarPeliculas(String nombrePelicula) {
        Peliculas pelicula = new Peliculas(nombrePelicula);
        boolean anexar=false;
        
        try {
            anexar= datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            
            var peliculas=datos.listar(NOMBRE_RECURSO);
            for (Peliculas pelicula : peliculas) {
                System.out.println("peliculas"+pelicula.toString());
                
                
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error en la excepcion");
            ex.printStackTrace();
            
        }
        
    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado= null;
        try {
            resultado=this.datos.buscar(NOMBRE_RECURSO, buscar);
                    } catch (AccesoDatosEx ex) {
                        System.out.println("Error");
                        ex.printStackTrace();
                    }
        System.out.println("Resultado:"+resultado);
    }

    @Override
    public void iniciarCatalogoDePeliculas() {
        
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
                
            }
            else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo");
            ex.printStackTrace();
        }
    }
    
}
