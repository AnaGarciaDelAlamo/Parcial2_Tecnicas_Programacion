import java.awt.*;

public class Ship {
    private int size; // tamaño del barco
    private int hits; // número de impactos recibidos
    private Point start; // punto de inicio del barco
    private Point end; // punto final del barco
    private CardinalPoints direction; // dirección del barco

    public Ship(int size, Point start, Point end) {
        this.size = size;
        this.hits = 0;
        this.start = start;
        this.end = end;
        // determina la dirección del barco en función de los puntos de inicio y fin
        if (start.getX() == end.getX()) {
            this.direction = CardinalPoints.NORTH; // vertical hacia arriba
        } else if (start.getY() == end.getY()) {
            this.direction = CardinalPoints.EAST; // horizontal hacia la derecha
        } else {
            throw new IllegalArgumentException("Los puntos no forman una línea recta");
        }
    }

    public int getSize() {
        return size;
    }

    public int getHits() {
        return hits;
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits == size;
    }

    public boolean getShot(Point shotPoint) {
        if (direction == CardinalPoints.NORTH) {
            if (shotPoint.getX() != start.getX()) {
                return false;
            }
            if (shotPoint.getY() >= start.getY() && shotPoint.getY() <= end.getY()) {
                hits++;
                return true;
            }
        } else if (direction == CardinalPoints.EAST) {
            if (shotPoint.getY() != start.getY()) {
                return false;
            }
            if (shotPoint.getX() >= start.getX() && shotPoint.getX() <= end.getX()) {
                hits++;
                return true;
            }
        }
        return false;
    }
}
