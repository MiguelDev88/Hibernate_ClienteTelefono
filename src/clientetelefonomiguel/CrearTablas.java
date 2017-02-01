package clientetelefonomiguel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


//@author Miguel
 
public class CrearTablas {
    
    public static void crearTablas () {
        
        
        try{
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();
            
            sentencia.execute("CREATE DATABASE IF NOT EXISTS CLIENTE_TELEFONO_MIGUEL;");
            sentencia.execute("USE CLIENTE_TELEFONO_MIGUEL;");

            
            sentencia.execute("CREATE TABLE IF NOT EXISTS CLIENTES"+ 
                              "(dni CHAR(9) NOT NULL, "+
                              "nombre VARCHAR(30) NOT NULL, "+
                              "salario INT NOT NULL, "+
                              "direccion VARCHAR(30) NOT NULL, "+
                              "PRIMARY KEY (dni)) " +
                              "ENGINE INNODB;");
            
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS TELEFONOS "+
                              "(dni CHAR(9) NOT NULL, "+
                              "numero INT NOT NULL, "+
                              "compañia VARCHAR(30) NOT NULL, "+
                              "PRIMARY KEY (dni)," +
                              "FOREIGN KEY (dni) REFERENCES CLIENTES(dni) " +
                                " ON DELETE CASCADE " +
                                " ON UPDATE CASCADE )" +
                              "ENGINE INNODB;");

            
            conexion.close();
            
            System.out.println("-- BASE DE DATOS LISTA --");

        }catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
}
