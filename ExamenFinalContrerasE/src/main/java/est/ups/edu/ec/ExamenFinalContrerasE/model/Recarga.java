package est.ups.edu.ec.ExamenFinalContrerasE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recarga {
    // Atributos
    @Id
    private int id;
    private String numeroTelefono;
    private String operador;
    private double monto;

    // Constructor
    public Recarga(String numeroTelefono, String operador, double monto) {
        this.numeroTelefono = numeroTelefono;
        this.operador = operador;
        this.monto = monto;
    }

    // Métodos para acceder a los atributos (getters y setters)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Método para imprimir la información de la recarga
    public void imprimirInformacion() {
        System.out.println("Recarga realizada:");
        System.out.println("ID: " + id);
        System.out.println("Número de teléfono: " + numeroTelefono);
        System.out.println("Operador: " + operador);
        System.out.println("Monto: " + monto);
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Ejemplo de uso
        Recarga recarga = new Recarga("1234567890", "Movistar", 100.0);
        recarga.setId(1); // Estableciendo un ID para probar la funcionalidad
        recarga.imprimirInformacion();
    }
}
