import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int maxShipCount;
       /* Canoe canoa_1 = new Canoe(new Point(1,1), new Point(1,1));
        Canoe canoa_2 = new Canoe(new Point(1,1), new Point(1,1));

        ArrayList<Ship> barcos_1 = new ArrayList<>();
        barcos_1.add(canoa_1);

        ArrayList<Ship> barcos_2 = new ArrayList<>();
        barcos_2.add(canoa_2);


        User usuario1 = new User(barcos_1);
        User usuario2 = new User(barcos_2);

        usuario1.attack(new Point(1,1), usuario2);*/
        //System.out.println(barcos_1.size());


        do {
            System.out.println("Configuración de los barcos jugador 1");
            System.out.println("Ingrese la cantidad de barcos (3 max):");
            maxShipCount = sc.nextInt();
        } while (maxShipCount >= 3);


        int shipCount = 0;
        ArrayList<Ship> barcos_1 = new ArrayList<>();

        while (shipCount < maxShipCount) {
            System.out.println("Ingrese el tipo de barco (Battleship, Canoe o Frigate)");
            String shipType = sc.next();

            System.out.println("Ingrese las coordenadas de inicio (x, y):");
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            Point startPoint = new Point(startX, startY);

            System.out.println("Ingrese las coordenadas de fin (x, y):");
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            Point endPoint = new Point(endX, endY);

            switch (shipType){
                case "Battleship":
                    Battleship battleship = new Battleship(startPoint, endPoint);
                    if(battleship.isStraight(startPoint, endPoint)){
                        barcos_1.add(battleship);
                        System.out.println("Battleship añadido");
                        shipCount++;
                    }else{
                        System.out.println("Las coordenadas no forman una linea recta.");
                    }
                    break;
                case "Canoe":
                    Canoe canoe = new Canoe(startPoint, endPoint);
                    if (canoe.isStraight(startPoint, endPoint) == true){
                    barcos_1.add(canoe);
                    System.out.println("Canoe añadido");
                    shipCount++;
                } else {
                        System.out.println("Las coordenadas no forman una linea recta.");
                    }
                    break;
                case "Frigate":
                    Frigate frigate = new Frigate(startPoint, endPoint);
                    if (frigate.isStraight(startPoint, endPoint) == true){
                        barcos_1.add(frigate);
                        System.out.println("Frigate añadido");
                        shipCount++;
                        break;
                    }else{
                        System.out.println("Las coordenadas no forman una linea recta.");
                    }

                default:
                    System.out.println("Tipo de barco no válido.");
            }

            if (shipCount == maxShipCount){
                break;
            }
        }




        User usuario1 = new User(barcos_1);

        //Jugador 2
        System.out.println("Confuguración de los barcos jugador 2");
        System.out.println("Ingrese la cantidad de barcos (3 max):");
        int maxShipCount2 = sc.nextInt();
        int shipCount2 = 0;

        ArrayList<Ship> barcos_2 = new ArrayList<>();

        while (shipCount2 < maxShipCount2) {
            System.out.println("Ingrese el tipo de barco (Battleship, Canoe o Frigate)");
            String shipType2 = sc.next();

            System.out.println("Ingrese las coordenadas de inicio (x, y):");
            int startX2 = sc.nextInt();
            int startY2 = sc.nextInt();
            Point startPoint2 = new Point(startX2, startY2);

            System.out.println("Ingrese las coordenadas de fin (x, y):");
            int endX2 = sc.nextInt();
            int endY2 = sc.nextInt();
            Point endPoint2 = new Point(endX2, endY2);

            switch (shipType2){
                case "Battleship":
                    Battleship battleship2 = new Battleship(startPoint2, endPoint2);
                    barcos_2.add(battleship2);
                    System.out.println("Battleship añadido");
                    shipCount2++;
                    break;
                case "Canoe":
                    Canoe canoe2 = new Canoe(startPoint2, endPoint2);
                    barcos_2.add(canoe2);
                    System.out.println("Canoe añadido");
                    shipCount2++;
                    break;
                case "Frigate":
                    Frigate frigate2 = new Frigate(startPoint2, endPoint2);
                    barcos_2.add(frigate2);
                    System.out.println("Frigate añadido");
                    shipCount2++;
                    break;
                default:
                    System.out.println("Tipo de barco no válido.");
            }

            if (shipCount2 == maxShipCount2){
                break;
            }
        }
        User usuario2 = new User(barcos_2);



        while (usuario1.getShips().size() > 0 && usuario2.getShips().size() > 0) {
            //Juego jugador 1
            System.out.println("Jugador 1 ataca");
            System.out.println("Ingrese las coordenadas de ataque (x, y):");
            int attackX = sc.nextInt();
            int attackY = sc.nextInt();
            Point attackPoint = new Point(attackX, attackY);
            usuario1.attack(attackPoint, usuario2);


            //Verificar si jugador 2 perdió
            if (usuario2.getShips().size()== 0) {
                System.out.println("Jugador 1 ha ganado el juego!");
                break;
            }

            //Juego jugador 2
            System.out.println("Jugador 2 ataca");
            System.out.println("Ingrese las coordenadas de ataque (x, y):");
            int attackX2 = sc.nextInt();
            int attackY2 = sc.nextInt();
            Point attackPoint2 = new Point(attackX2, attackY2);
            usuario2.attack(attackPoint2, usuario1);


            //Verificar si jugador 1 perdió
            if (usuario1.getShips().size() == 0) {
                System.out.println("Jugador 2 ha ganado el juego!");
                break;
            }
        }



    }
}
