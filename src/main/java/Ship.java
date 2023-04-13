import java.awt.*;

public abstract class Ship {
    protected Point start;
    protected Point end;
    protected int hits;
    protected int size;

    public Ship(Point start, Point end) {

        if (!isStraight(start, end))
            throw new IllegalArgumentException("Las coordenadas indicadas no forman una linea recta.");
        this.start = start;
        this.end = end;
        this.size = calculateSize()+1;
        this.hits = 0;
    }

    private boolean isStraight(Point start, Point end){
        return start.getX() == end.getX() || start.getY() == end.getY();
    }

    /**
     * Calcula el tamaño del barco dada su posición de inicio y fin.
     * */
    private int calculateSize(){
        int size = (int) (start.getX() - end.getX());
        if (size != 0)
            return Math.abs(size);
        return Math.abs((int)(start.getY() - end.getY()));
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean get_shot(Point shot_point) {
        if (shot_point.getX() < start.getX() || shot_point.getX() > end.getX() ||
                shot_point.getY() < start.getY() || shot_point.getY() > end.getY()) {
            return false; // el disparo está fuera del rango del barco
        }

        hits++;
        return true;
    }

    public boolean isSunk() {
        System.out.println("Barco hundidio");
        return hits == size;
    }


    public boolean equals(Ship ship) {
        if (this.start.getX() == ship.getStart().getX() && this.start.getY() == ship.getStart().getY() &&
                this.end.getX() == ship.getEnd().getX() && this.end.getY() == ship.getEnd().getY()){
            return true;
        }
        return false;
    }

}
