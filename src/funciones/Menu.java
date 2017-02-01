package funciones;
import java.io.BufferedReader;
import java.io.IOException;


//@author Miguel
 
public class Menu {
    
    public static byte menuInicio (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("Seleccione opción:"
                + "\n1.Creación de Tablas y BD"
                + "\n2.Inserción"
                + "\n3.Borrado"
                + "\n4.Modificaciones"
                + "\n5.Consultas"
                + "\n0.Salir");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    public static byte menuAltas (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Qué desea dar de alta?"
                + "\n1.Nuevo Cliente"
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }

    public static byte menuModificar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Qué desea modificar?"
                + "\n1.Salario"
                + "\n2.Teléfono"
                + "\n3.Compañía telefónica"
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Qué desea consultar?"
                + "\n1.Listado de Clientes"
                + "\n2.Datos de un Cliente"
                + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
    public static byte menuConfirmar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Seguro que desea eliminar este registro?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
}
