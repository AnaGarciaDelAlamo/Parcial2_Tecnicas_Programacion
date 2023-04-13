import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
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


        //Jugador 1
        System.out.println("Confuguración de los barcos jugador 1");
        //System.out.println("Ingrese la cantidad de barcos (3 max):");
        //int shipCount = sc.nextInt();
        int shipCount = 0;


        ArrayList<Ship> barcos_1 = new ArrayList<>();


        for(int i = 0; i < 3; i++){
            boolean ejecutar = true;
            do{
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
                        barcos_1.add(battleship);
                        shipCount++;
                        break;
                    case "Canoe":
                        Canoe canoe = new Canoe(startPoint, endPoint);
                        barcos_1.add(canoe);
                        shipCount++;
                        break;
                    case "Frigate":
                        Frigate frigate = new Frigate(startPoint, endPoint);
                        barcos_1.add(frigate);
                        shipCount++;
                        break;
                }

                if (shipCount == 3){
                    ejecutar = false;
                }

            }while(ejecutar == true);
        }

        User usuario1 = new User(barcos_1);




    }
}
