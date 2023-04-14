import java.awt.*;
import java.util.ArrayList;

public class User {
    private ArrayList<Ship> ships;
    private boolean isAlive;

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
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void die(){
        this.isAlive = false;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }
    /*Para ships no sería necesario un setter porque ya comprobamos
    que no sea nulo en el constructor
     */

    public boolean attack(Point shotPoint, User user) throws Exception{
        if(shotPoint == null){
            throw new Exception("El punto de disparo no puede ser nulo");
        }
        if(user == null){
            throw new Exception("El usuario no puede ser nulo");
        }

        for(Ship ship : user.getShips()){
            if (ship.get_shot(shotPoint)) {
                System.out.println("Barco tocado");
                if(ship.isSunk())
                user.getShips().remove(ship);
                System.out.println("Quedan este número de barcos en la lista: " + user.getShips().size());
                return true;
            }
        }
        return false;
    }

    public void removeShip(Ship ship){
        this.ships.remove(ship);
    }
}


