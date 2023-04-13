import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    void testConstructor() {
        Point start = new Point(1, 1);
        Point end = new Point(5, 1);
        Ship ship = new Canoe(start, end);
        assertEquals(start, ship.getStart());
        assertEquals(end, ship.getEnd());
    }


    @Test
    void testGetStart() {
        Point start = new Point(1, 1);
        Point end = new Point(5, 1);
        Ship ship = new Canoe(start, end);
        assertEquals(start, ship.getStart());
    }

    @Test
    void testGetEnd() {
        Point start = new Point(1, 1);
        Point end = new Point(5, 1);
        Ship ship = new Canoe(start, end);
        assertEquals(end, ship.getEnd());
    }

    @Test
    void testSetEnd() {
        Point start = new Point(1, 1);
        Point end = new Point(5, 1);
        Ship ship = new Canoe(start, end);
        Point newEnd = new Point(2, 1);
        ship.setEnd(newEnd);
        assertEquals(newEnd, ship.getEnd());
    }

    @Test
    void testSetHits() {
        Point start = new Point(1, 1);
        Point end = new Point(5, 1);
        Ship ship = new Canoe(start, end);
        ship.setHits(2);
        assertEquals(2, ship.getHits());
    }

    @Test
    void testGetSize() {
        Point start = new Point(1, 1);
        Point end = new Point(5, 1);
        Ship ship = new Canoe(start, end);
        assertEquals(5, ship.getSize());
    }

    @Test
    void testSetSize() {
        Point start = new Point(1, 1);
        Point end = new Point(5, 1);
        Ship ship = new Canoe(start, end);
        ship.setSize(4);
        assertEquals(4, ship.getSize());
    }

    @Test
    void testGetShot() {
        Point start = new Point(1, 1);
        Point end = new Point(5, 1);
        Ship ship = new Canoe(start, end);
        assertTrue(ship.get_shot(new Point(3, 1)));
        assertEquals(1, ship.getHits());
        assertFalse(ship.get_shot(new Point(3, 2)));
    }

    @Test
    void testIsSunk() {
        Point start = new Point(1, 1);
        Point end = new Point(5, 1);
        Ship ship = new Canoe(start, end);
        assertFalse(ship.isSunk());
        ship.setHits(5);
        assertTrue(ship.isSunk());
    }
}
