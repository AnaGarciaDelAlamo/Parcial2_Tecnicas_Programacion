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

    public static void main(String[] args) {
        try {
            Ship s1 = new Canoe(new Point(1,1), new Point(1,1));
            Ship s2 = new Canoe(new Point(3,3), new Point(3,3 ));
            ArrayList<Ship> ships = new ArrayList<>();
            ships.add(s1);
            ships.add(s2);
            User user = new User(ships);

            Point shot1 = new Point(1,1);
            Point shot2 = new Point(1,2);
            Point shot3 = new Point(3,4);

            System.out.println(user.attack(shot1, user)); // Should print "Barco tocado" and "Quedan este número de barcos en la lista: 1"
            System.out.println(user.attack(shot2, user)); // Should print "Barco tocado" and "Quedan este número de barcos en la lista: 1"
            System.out.println(user.attack(shot3, user)); // Should print "Barco tocado", "Quedan este número de barcos en la lista: 0" and "El usuario ha perdido"
        } catch (Exception e) {
            System.out.println("Ha ocurrido una excepción: " + e.getMessage());
        }
    }
}


