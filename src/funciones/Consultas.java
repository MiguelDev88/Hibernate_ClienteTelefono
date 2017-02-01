
package funciones;
import POJOS.*;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import clientetelefonomiguel.HibernateUtil;
import org.hibernate.Session;


// @author Miguel

public class Consultas {
    
    public static void consulta (BufferedReader leer) throws IOException {
        
        byte op=1;
        
        while(op!=0)
            {
                op=Menu.menuConsultas(leer);
                switch (op){
                    case 1:
                        verClientes();
                        break;
                    case 2:
                        datosCliente(leer);
                        break;
                }
            }
    }
    
    public static void verClientes () throws IOException {
        
        Session sesion=HibernateUtil.getSession();
        C_Cliente cliente;
        
        try{
            List<C_Cliente> listaClientes = sesion.createCriteria(C_Cliente.class).list();
            Iterator clientes=listaClientes.iterator();
            
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("|    DNI    |   NOMBRE   | SALARIO | DIRECCION |   TELEFONO  |  COMPAÑIA  |");
            
            while(clientes.hasNext())
            {
                cliente=(C_Cliente)clientes.next();
                System.out.printf("| %9s |%10s  | %7s |  %6s   | %10s  | %10s |%n",cliente.getDni(),cliente.getNombre(),
                        cliente.getSalario(),cliente.getDireccion(),cliente.getTelefono().getNumero(),cliente.getTelefono().getCompañia());
            }
            
            System.out.println("---------------------------------------------------------------------------");                   
         
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        
    }

    public static void datosCliente (BufferedReader leer) throws IOException {
        
        String dni;
        Session sesion;
        C_Cliente cliente;
        
        try{
            sesion=HibernateUtil.getSession();
            System.out.println("Introduzca Dni del cliente a buscar:");
            dni=leer.readLine();
            
            cliente=(C_Cliente)sesion.get(C_Cliente.class, dni);

            if(cliente !=null)
            {
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("|    DNI    |   NOMBRE   | SALARIO | DIRECCION |   TELEFONO  |  COMPAÑIA  |");
                System.out.printf("| %5s |%10s  | %7s |  %6s   | %10s  | %10s |%n",cliente.getDni(),cliente.getNombre(),
                        cliente.getSalario(),cliente.getDireccion(),cliente.getTelefono().getNumero(),cliente.getTelefono().getCompañia());
                System.out.println("---------------------------------------------------------------------------");         
            }else
                System.out.println("\n No se ha encontrado el cliente \n");
         
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        } 
    }
}
