
package accesos;


import Excepciones.*;
import domainPeliculas.*;
import java.io.*;
import java.util.*;


public class AccesoDatosIML implements IAccesosADatos{

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {

            File  archivo=new File(nombreArchivo);
            return archivo.exists();
    }

    @Override
    public List<Peliculas> listar(String nombreRes) throws AccesoDatosEx {
    
        var archivo= new File(nombreRes);
        List<Peliculas> peliculas = new ArrayList<>();
        try {
            //Con esto leemos la entrada
            BufferedReader entrada= new BufferedReader(new FileReader(archivo));
            String linea= null;
            linea=entrada.readLine();
            while (linea!=null){
            
                var pelicula = new Peliculas(linea);
                peliculas.add(pelicula);
                linea=entrada.readLine();
                
            }
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            //Esto nos devuelve nuestro tipo de excepcion 
            throw new LecturaEx("Excepcion al listar peliculas"+ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            //Esto nos devuelve nuestro tipo de excepcion 
            throw new LecturaEx("Excepcion al listar peliculas"+ex.getMessage());
        }
        
        return peliculas;
        
        
    }

    @Override
    public void escribir(Peliculas pelicula, String nombreArchivo, boolean anexo) throws AccesoDatosEx {

        var archivo = new File(nombreArchivo);
        try {
            var salida= new PrintWriter(new FileWriter(archivo,anexo));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se agrego la pelicula al archivo:"+pelicula.toString());
            
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraEx("Excepcion al listar peliculas"+ex.getMessage());
            
            
        }
        
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        String resultado=null;
        
        try {
            var entrada= new BufferedReader(new FileReader(archivo));
            String linea =null;
             linea=entrada.readLine();
             int indice=1;
             
             while(linea!=null){
                 
                 if (buscar!=null &&  buscar.equalsIgnoreCase(linea)) {
                     resultado=linea+" en indice("+indice+")";
                     break;
                     
                 } 
                 linea= entrada.readLine();
                 indice++;
  
                 
                  
             }entrada.close();
        
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaEx("Excepcion al buscar peliculas"+ex.getMessage());

            
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaEx("Excepcion al buscar peliculas"+ex.getMessage());        }
        
        return resultado;
        
        
        
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        
        var archivo= new File(nombreArchivo);
        try {
            var salida= new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
            
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraEx("Excepcion al crear archivo "+ex.getMessage());

            
        }
        
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        
        var archivo= new File(nombreArchivo);
        if(archivo.exists()){
        
        
            archivo.delete();
        }
        
        System.out.println("Se elemino el archivo");
        
        
        
    }
    
}
