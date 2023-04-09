import java.util.HashMap;

public class TablaBarcos {
    private HashMap<String, HashMap<Integer, HashMap<String, Barco>>> tablas;

    public TablaBarcos() {
        tablas = new HashMap<String, HashMap<Integer, HashMap<String, Barco>>>();
    }

    public void cargarBarco(Barco barco) {
        // Verificar si existe la tabla hash para el tipo de barco
        String tipo = barco.getTipo();
        HashMap<Integer, HashMap<String, Barco>> tablaNumeros = null;
        HashMap<String, Barco> tablaNombres = null;

        if (tablas.containsKey(tipo)) {
            tablaNumeros = tablas.get(tipo);
        } else {
            tablaNumeros = new HashMap<Integer, HashMap<String, Barco>>();
            tablas.put(tipo, tablaNumeros);
        }

        // Verificar si existe la tabla hash para el número de barco
        int numero = barco.getNumero();

        if (tablaNumeros.containsKey(numero)) {
            tablaNombres = tablaNumeros.get(numero);
        } else {
            tablaNombres = new HashMap<String, Barco>();
            tablaNumeros.put(numero, tablaNombres);
        }

        // Agregar el barco a la tabla hash por nombre
        String nombre = barco.getNombre();
        tablaNombres.put(nombre, barco);
    }

    public Barco buscarBarcoPorNumero(String tipo, int numero) {
        if (tablas.containsKey(tipo)) {
            HashMap<Integer, HashMap<String, Barco>> tablaNumeros = tablas.get(tipo);
            if (tablaNumeros.containsKey(numero)) {
                HashMap<String, Barco> tablaNombres = tablaNumeros.get(numero);
                // En este caso, asumimos que el nombre del barco es único
                return tablaNombres.values().iterator().next();
            }
        }
        return null;
    }

    public Barco buscarBarcoPorNombre(String tipo, String nombre) {
        if (tablas.containsKey(tipo)) {
            HashMap<Integer, HashMap<String, Barco>> tablaNumeros = tablas.get(tipo);
            for (HashMap<String, Barco> tablaNombres : tablaNumeros.values()) {
                if (tablaNombres.containsKey(nombre)) {
                    return tablaNombres.get(nombre);
                }
            }
        }
        return null;
    }
}
