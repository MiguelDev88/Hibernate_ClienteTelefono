package POJOS;
import java.io.Serializable;


// @author Miguel

public class C_Cliente implements Serializable {
    
    private String dni;
    private String nombre;
    private int salario;
    private String direccion;
    private C_Telefono telefono;
    
    public C_Cliente () {}
    
    public C_Cliente (String dni, String nombre, int salario, String direccion, C_Telefono telefono ) {
        
        this.dni=dni;
        this.nombre=nombre;
        this.salario=salario;
        this.direccion=direccion;
        this.telefono=telefono;
        
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public C_Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(C_Telefono telefono) {
        this.telefono = telefono;
    }

}
