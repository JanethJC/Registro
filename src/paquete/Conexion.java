
package paquete;



import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    
    private Conexion(){
        
    }
    
    
    
    //lo primero creamos una variable en la cual vamos a guardar el estado de la conexion a nuestra BD
    private static Connection conexion;
    
    //creamos una variable para crear una sola instancia 
    private static Conexion instancia;
    
    //creamos las variables para poder conectarnos a la BD
    private static final String URL = "jdbc:mysql://localhost/bd_registro";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    //creamos el metodo para conectarnos a la base de datos
    public Connection conectar(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
           JOptionPane.showMessageDialog(null,"Conexion exitosa !!");
           
           return conexion;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error : "+e);
        }
        return conexion;
        
    }
    
    //creamos el metodo para cerrar la conexion
    public void cerrarConexion() throws SQLException{
        try {
            
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se desconecto de la base de batos . ");
            
        }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error : " +e);
                    conexion.close();
          }finally{
            conexion.close();
        }
     }
    
    //patron singleton
    public static Conexion getInstance(){
    if(instancia == null){
        instancia = new Conexion();
      }
    return instancia;
}

    }
    

