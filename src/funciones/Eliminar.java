
package funciones;
import POJOS.*;
import java.io.BufferedReader;
import java.io.IOException;
import clientetelefonomiguel.HibernateUtil;
import org.hibernate.Session;


// @author Miguel

public class Eliminar {
       
    
    public static void eliminar (BufferedReader leer) throws IOException {
        
        Session sesion;
        C_Cliente cliente;
        String dni;
        
        try{
            sesion=HibernateUtil.getSession();
            Consultas.verClientes();
            System.out.println("Introduzca Dni del cliente a eliminar:");
            dni=leer.readLine();

            cliente=(C_Cliente)sesion.get(C_Cliente.class, dni);

            if(cliente !=null)
            {
                if(Menu.menuConfirmar(leer)==1){
                    sesion.beginTransaction();
                    sesion.delete(cliente);
                    sesion.getTransaction().commit();
                    System.out.println("\n - Cliente Eliminado - \n");
                }
            }else
                System.out.println("\n No se ha encontrado el cliente \n");
            
            sesion.close();
            
        }catch(Exception e){
            
            System.out.println("Error al borrar");
        }            
    }
}
