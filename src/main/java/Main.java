import java.awt.Point;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear los barcos del usuario
        ArrayList<Ship> userShips = new ArrayList<>();
        userShips.add(new Frigate(new Point(0, 0), new Point(2, 0)));
        userShips.add(new Canoe(new Point(4, 0), new Point(4, 0)));
        userShips.add(new Battleship(new Point(6, 0), new Point(10, 0)));

        // Crear el usuario
        User user = null;
        try {
            user = new User(userShips);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        // Crear los barcos del oponente
        ArrayList<Ship> opponentShips = new ArrayList<>();
        opponentShips.add(new Frigate(new Point(0, 2), new Point(2, 2)));
        opponentShips.add(new Canoe(new Point(4, 4), new Point(4, 4)));
        opponentShips.add(new Battleship(new Point(6, 6), new Point(10, 6)));

        // Crear el oponente
        User opponent = null;
        try {
            opponent = new User(opponentShips);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        // Simular un juego
        Point shotPoint = new Point(4, 4);
        try {
            boolean hit = user.attack(shotPoint, opponent);
            if (hit) {
                System.out.println("¡Has dado en el blanco!");
            } else {
                System.out.println("Has fallado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}