package POJOS;
import java.io.Serializable;


// @author Miguel

public class C_Telefono implements Serializable {
    
    private String dni;
    private int numero;
    private String compañia;
    
    public C_Telefono (){}
    
    public C_Telefono (String dni, int numero, String compañia) {
        
        this.dni=dni;
        this.numero=numero;
        this.compañia=compañia;
        
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

}
