package funciones;
import POJOS.*;
import clientetelefonomiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;


//@author Miguel
 
public class Altas {
    
    public static void altas (BufferedReader leer) throws IOException {
        
        Session sesion;
        C_Cliente cliente;
        
        while(Menu.menuAltas(leer)!=0)
            try{
                sesion=HibernateUtil.getSession();
                cliente=nuevoCliente(leer);
                sesion.beginTransaction();
                sesion.save(cliente);
                sesion.getTransaction().commit();
                sesion.close();

            }catch(HibernateException e){

                System.out.println("Error en el alta");
            }
    }
    
    public static C_Cliente nuevoCliente (BufferedReader leer) throws IOException {
        
        String dni, nombre, direccion;
        int salario;
        C_Telefono telefono;
        C_Cliente cliente;
        
        
        System.out.println("Introducir DNI:");
        dni=leer.readLine();
        System.out.println("Introducir nombre:");
        nombre=leer.readLine();
        System.out.println("Introducir salario");
        salario=Integer.parseInt(leer.readLine());
        System.out.println("Introducir dirección:");
        direccion=leer.readLine();
        
        telefono=nuevoTelefono(leer,dni);
        
        cliente=new C_Cliente(dni,nombre,salario,direccion,telefono);
        
        return cliente;
        

    }
    
    public static C_Telefono nuevoTelefono (BufferedReader leer, String dni) throws IOException {
        
        int tlf;
        String comp;
        C_Telefono telefono;
        
        System.out.println("Introducir número de teléfono:");
        tlf=Integer.parseInt(leer.readLine());
        System.out.println("Introducir compañia:");
        comp=leer.readLine();
        
        telefono=new C_Telefono(dni, tlf,comp);
        
        return telefono;

    }
}
