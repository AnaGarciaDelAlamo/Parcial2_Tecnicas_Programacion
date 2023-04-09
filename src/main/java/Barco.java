import java.util.HashMap;

public class Barco {
    private String nombre;
    private String tipo;
    private int nivel;
    private int numero;

    public Barco(String nombre, String tipo, int nivel, int numero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getNumero() {
        return numero;
    }
}

