
package labofinal;

import java.util.Scanner;
import logicaDeNegocio.CatalogoPeliculas;
import logicaDeNegocio.ICatalogoPeliculas;


public class LaboFinal {

    public static void main(String[] args) {
        
        var opcion=-1;
        Scanner sn = new Scanner(System.in);
        ICatalogoPeliculas catalogo= new CatalogoPeliculas();
        
        while(opcion!=0){
            
            System.out.println("Elige una opcion\n"
                    + "(1)Iniciar\n"
                    + "(2)Agregar pelicula\n"
                    + "(3)Listar peliculas\n"
                    + "(4)Buscar pelicula\n"
                    + "(0)Salir");
            opcion= Integer.parseInt(sn.nextLine());
            
            switch(opcion){
            
                case 1:
                    catalogo.iniciarCatalogoDePeliculas();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la pelicula");
                    var nombrePelicula=sn.nextLine();
                    catalogo.agregarPeliculas(nombrePelicula);
                    break;
                    
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce pelicula a buscar:");
                    var buscar=sn.nextLine();
                    catalogo.buscarPeliculas(buscar);
                    break;
                    
                case 0:
                    System.out.println("Muchas gracias por usar nuestro programa");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    
                    
            }
            
        
            
        }
        

    }
    
}
