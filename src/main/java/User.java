import java.awt.*;
import java.util.ArrayList;

public class User {
    private ArrayList<Ship> ships;
    private boolean is_alive;

    public User(ArrayList<Ship> ships) throws Exception {
        if (ships == null || ships.size() == 0) {
            throw new Exception("Debe haber al menos un barco");
        }
        for (Ship ship : ships) {
            if (ship == null) {
                throw new Exception("No se permite barcos nulos");
            }
        }
        this.ships = ships;
        this.is_alive = true;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public boolean isAlive() {
        return is_alive;
    }

    public void die() {
        this.is_alive = false;
    }

    public boolean attack(Point shot_point, User user) throws Exception {
        if (shot_point == null || user == null) {
            throw new Exception("Los parámetros no pueden ser nulos");
        }

        boolean hit = false;
        for (Ship ship : user.getShips()) {
            if (ship.getShot(shot_point)) {
                hit = true;
                if (ship.isSunk()) {
                    System.out.println("¡Barco hundido!");
                }
                break;
            }
        }

        return hit;
    }

    public void getShot(Point shot_point) {
        for (Ship ship : ships) {
            ship.getShot(shot_point);
        }
    }
}

