import java.awt.*;

public class Battleship extends Ship {
    private boolean[] isolatedHits;

    public Battleship(Point start, Point end) {
        super(5, start, end);
        isolatedHits = new boolean[3];
    }

    @Override
    public boolean getShot(Point shotPoint) {
        boolean hit = super.getShot(shotPoint);
        if (hit) {
            int hitIndex = getIsolatedHitIndex(shotPoint);
            if (hitIndex != -1) {
                isolatedHits[hitIndex] = true;
                if (areIsolatedHitsSunk()) {
                    hits = size;
                }
            }
        }
        return hit;
    }

    private int getIsolatedHitIndex(Point shotPoint) {
        if (direction == CardinalPoints.NORTH) {
            if (shotPoint.getX() != start.getX()) {
                return -1;
            }
            int y = (int) shotPoint.getY();
            if (y == start.y + 1) {
                return 0;
            } else if (y == start.y + 3) {
                return 1;
            } else if (y == start.y + 4) {
                return 2;
            }
        } else if (direction == CardinalPoints.EAST) {
            if (shotPoint.getY() != start.getY()) {
                return -1;
            }
            int x = (int) shotPoint.getX();
            if (x == start.x + 1) {
                return 0;
            } else if (x == start.x + 3) {
                return 1;
            } else if (x == start.x + 4) {
                return 2;
            }
        }
        return -1;
    }

    private boolean areIsolatedHitsSunk() {
        for (boolean isolatedHit : isolatedHits) {
            if (!isolatedHit) {
                return false;
            }
        }
        return true;
    }
}


