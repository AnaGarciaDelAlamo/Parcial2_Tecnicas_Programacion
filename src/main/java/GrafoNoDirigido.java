import java.util.*;

class Puerto {
    String nombre;

    public Puerto(String nombre) {
        this.nombre = nombre;
    }
}

class Arista {
    Puerto origen;
    Puerto destino;
    int distancia;

    public Arista(Puerto origen, Puerto destino, int distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }
}

class GrafoNoDirigido {
    Map<Puerto, List<Arista>> grafo;

    public GrafoNoDirigido() {
        grafo = new HashMap<>();
    }

    public void agregarPuerto(Puerto puerto) {
        grafo.put(puerto, new ArrayList<>());
    }

    public void agregarArista(Puerto origen, Puerto destino, int distancia) {
        Arista arista = new Arista(origen, destino, distancia);
        grafo.get(origen).add(arista);
        grafo.get(destino).add(arista);
    }

    public void eliminarPuerto(Puerto puerto) {
        grafo.remove(puerto);
        for (Puerto p : grafo.keySet()) {
            List<Arista> aristas = grafo.get(p);
            aristas.removeIf(arista -> arista.origen == puerto || arista.destino == puerto);
        }
    }

    public void barridoEnProfundidad(Puerto puerto) {
        Set<Puerto> visitados = new HashSet<>();
        Stack<Puerto> pila = new Stack<>();
        pila.push(puerto);

        while (!pila.isEmpty()) {
            Puerto actual = pila.pop();
            if (!visitados.contains(actual)) {
                visitados.add(actual);
                System.out.println(actual.nombre);
                for (Arista arista : grafo.get(actual)) {
                    Puerto vecino = arista.origen == actual ? arista.destino : arista.origen;
                    pila.push(vecino);
                }
            }
        }
    }

    public List<Puerto> caminoMasCorto(Puerto origen, Puerto destino) {
        Map<Puerto, Integer> distancias = new HashMap<>();
        Map<Puerto, Puerto> padres = new HashMap<>();
        PriorityQueue<Puerto> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        Set<Puerto> visitados = new HashSet<>();

        for (Puerto puerto : grafo.keySet()) {
            distancias.put(puerto, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        cola.add(origen);

        while (!cola.isEmpty()) {
            Puerto actual = cola.poll();
            if (!visitados.contains(actual)) {
                visitados.add(actual);
                for (Arista arista : grafo.get(actual)) {
                    Puerto vecino = arista.origen == actual ? arista.destino : arista.origen;
                    int distancia = distancias.get(actual) + arista.distancia;
                    if (distancia < distancias.get(vecino)) {
                        distancias.put(vecino, distancia);
                        padres.put(vecino, actual);
                        cola.add(vecino);
                    }
                }
            }
        }

        List<Puerto> camino = new ArrayList<>();
        Puerto actual = destino;
        while (actual != null) {
            camino.add(actual);
            actual = padres.get(actual);
        }
        Collections.reverse(camino);
        return camino;
    }

    public Puerto puertoConMasAristas() {
        Puerto puertoMax = null;
        int maxAristas = Integer.MIN_VALUE;

        for (Puerto puerto : grafo.keySet()) {
            int numAristas = grafo.get(puerto).size();
            if (numAristas > maxAristas) {
                maxAristas = numAristas;
                puertoMax = puerto;
            }
        }

        return puertoMax;
    }

    public void eliminarPuertoConMasAristas() {
        Puerto puertoMax = puertoConMasAristas();
        eliminarPuerto(puertoMax);
        System.out.println("Se eliminó el puerto " + puertoMax.nombre);
    }


    /*public static void main(String[] args) {
        GrafoNoDirigido grafo = new GrafoNoDirigido();
        Puerto madero = new Puerto("Madero");
        Puerto rodas = new Puerto("Rodas");
        Puerto laHabana = new Puerto("La Habana");
        Puerto miami = new Puerto("Miami");
        Puerto cancun = new Puerto("Cancún");

        grafo.agregarPuerto(madero);
        grafo.agregarPuerto(rodas);
        grafo.agregarPuerto(laHabana);
        grafo.agregarPuerto(miami);
        grafo.agregarPuerto(cancun);

        grafo.agregarArista(madero, laHabana, 1000);
        grafo.agregarArista(madero, cancun, 1500);
        grafo.agregarArista(laHabana, miami, 800);
        grafo.agregarArista(miami, rodas, 500);
        grafo.agregarArista(cancun, miami, 1200);
        grafo.agregarArista(cancun, rodas, 1000);

        System.out.println("Barrido en profundidad desde " + madero.nombre + ":");
        grafo.barridoEnProfundidad(madero);

        System.out.println("Camino más corto de " + madero.nombre + " a " + rodas.nombre + ":");
        List<Puerto> camino = grafo.caminoMasCorto(madero, rodas);
        for (Puerto puerto : camino) {
            System.out.print(puerto.nombre + " -> ");
        }
        System.out.println();

        Puerto puertoMax = grafo.puertoConMasAristas();
        System.out.println("Puerto con más aristas: " + puertoMax.nombre);
        grafo.eliminarPuertoConMasAristas();
    }*/

}

