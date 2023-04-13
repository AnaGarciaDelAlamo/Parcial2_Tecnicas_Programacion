import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[][] tablero1 = new int[10][10];
        int[][] tablero2 = new int[10][10];

        // Pintar tablero1
        System.out.println("Tablero 1:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero1[i][j] + " ");
            }
            System.out.println();
        }

        // Pintar tablero2
        System.out.println("Tablero 2:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero2[i][j] + " ");
            }
            System.out.println();
        }


        // Configuración de los barcos
        System.out.println("Configuración de los barcos");
        System.out.println("Ingrese la cantidad de barcos (3 max):");
        int shipCount = scanner.nextInt();

        ArrayList<Ship> player1Ships = new ArrayList<>();
        ArrayList<Ship> player2Ships = new ArrayList<>();

        // Configuración de los barcos para el jugador 1
        System.out.println("Jugador 1 - Configuración de los barcos:");
        for (int i = 0; i < shipCount; i++) {
            do {
                System.out.println("Ingrese el tipo de barco (Battleship, Canoe o Frigate):");
                String shipType = scanner.next();

                System.out.println("Ingrese las coordenadas de inicio (x, y):");
                int startX = scanner.nextInt();
                int startY = scanner.nextInt();
                Point startPoint = new Point(startX, startY);

                System.out.println("Ingrese las coordenadas de fin (x, y):");
                int endX = scanner.nextInt();
                int endY = scanner.nextInt();
                Point endPoint = new Point(endX, endY);

                Ship ship = null;
                switch (shipType) {
                    case "Battleship":

                        ship = new Battleship(startPoint, endPoint);
                        break;
                    case "Canoe":

                        ship = new Canoe(startPoint, endPoint);
                        break;
                    case "Frigate":
                        ship = new Frigate(startPoint, endPoint);
                        break;
                    default:
                        System.out.println("Tipo de barco inválido, se saltará este barco.");
                }

                if (ship != null) {
                    player1Ships.add(ship);
                }
            }while (shipCount <= 3);
        }

        // Configuración de los barcos para el jugador 2
        System.out.println("Jugador 2 - Configuración de los barcos");
        for (int i = 0; i < shipCount; i++) {
            System.out.println("Ingrese el tipo de barco (Battleship, Canoe o Frigate):");
            String shipType = scanner.next();

            System.out.println("Ingrese las coordenadas de inicio (x, y):");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            Point startPoint = new Point(startX, startY);

            System.out.println("Ingrese las coordenadas de fin (x, y):");
            int endX = scanner.nextInt();
            int endY = scanner.nextInt();
            Point endPoint = new Point(endX, endY);

            Ship ship = null;
            switch (shipType) {
                case "Battleship":
                    ship = new Battleship(startPoint, endPoint);
                    break;
                case "Canoe":
                    ship = new Canoe(startPoint, endPoint);
                    break;
                case "Frigate":
                    ship = new Frigate(startPoint, endPoint);
                    break;
                default:
                    System.out.println("Tipo de barco inválido, se saltará este barco.");
            }

            if (ship != null) {
                player2Ships.add(ship);
            }
        }

        // Creación de los usuarios
        User player1;
        User player2;
        try {
            player1 = new User(player1Ships);
            player2 = new User(player2Ships);
        } catch (Exception e) {
            System.out.println("Error al crear los usuarios: " + e.getMessage());
            return;
        }

        // Inicio del juego
       /* while (true) {
            // Turno del jugador 1
            if (player1.isAlive() == true && player2.die()) {
                System.out.println("¡Felicidades " + player1 + ", has ganado el juego!");
                break;
            }

            // Turno del jugador 2
            if (player2.hasWon()) {
                System.out.println("¡Felicidades " + player2. + ", has ganado el juego!");
                break;
            }
        }*/


    }
}


