
package funciones;
import POJOS.*;
import java.io.BufferedReader;
import java.io.IOException;
import clientetelefonomiguel.HibernateUtil;
import org.hibernate.Session;


// @author Miguel

public class Modificar {
    
    
    public static void modificar (BufferedReader leer) throws IOException {
        
        Session sesion;
        String dni,compañia;
        int salario, numero;
        C_Cliente cliente;
        byte op;
        
        
        try{
            sesion=HibernateUtil.getSession();
            Consultas.verClientes();
            
            System.out.println("Introducir DNI del cliente a modificar:");
            dni=leer.readLine();

            cliente=(C_Cliente)sesion.get(C_Cliente.class, dni);
            
            if(cliente!=null)
            {
                op=Menu.menuModificar(leer);

                switch(op) {
                    case 1:
                        System.out.println("Introducir nuevo salario:");
                        salario=Integer.parseInt(leer.readLine());
                        cliente.setSalario(salario);
                        System.out.println(" - Salario actualizado -");
                        break;
                    case 2:
                        System.out.println("Introducir nuevo teléfono:");
                        numero=Integer.parseInt(leer.readLine());
                        cliente.getTelefono().setNumero(numero);
                        System.out.println(" - Teléfono actualizado -");
                        break;
                    case 3:
                        System.out.println("Introducir nueva compañía telefónica:");
                        compañia=leer.readLine();
                        cliente.getTelefono().setCompañia(compañia);
                        System.out.println(" - Compañia actualizada -");
                        break;
                }
                sesion.flush();
                sesion.close();
                
            }else
                System.out.println("\n No se ha encontrado el cliente \n");
                
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }  
    }
}
