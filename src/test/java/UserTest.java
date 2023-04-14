import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void isAlive() throws Exception {
        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(new Canoe(new Point(0, 0), new Point(0, 0)));
        User user = new User(ships);
        assertTrue(user.isAlive());
        user.die();
        assertFalse(user.isAlive());
    }

    @Test
    void setAlive() throws Exception {
        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(new Canoe(new Point(0, 0), new Point(0, 0)));
        User user = new User(ships);
        user.setAlive(false);
        assertFalse(user.isAlive());
        user.setAlive(true);
        assertTrue(user.isAlive());
    }

    @Test
    void die() throws Exception {
        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(new Canoe(new Point(0, 0), new Point(0 ,0)));
        User user = new User(ships);
        assertTrue(user.isAlive());
        user.die();
        assertFalse(user.isAlive());
    }

    @Test
    void getShips() throws Exception {
        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(new Canoe(new Point(0, 0), new Point(0, 0)));
        User user = new User(ships);
        assertEquals(user.getShips(), ships);
    }

    @Test
    void attack() throws Exception {
        // Test attacking a ship
        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(new Canoe(new Point(0, 0), new Point(0, 0)));
        User user = new User(ships);
        Point shotPoint = new Point(0, 0);
        assertTrue(user.attack(shotPoint, user));
        assertEquals(user.getShips().size(), 0);

    }
}
