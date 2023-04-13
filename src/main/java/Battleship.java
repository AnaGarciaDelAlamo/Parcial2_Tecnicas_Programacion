import java.awt.*;

public class Battleship extends Ship {
    private int SIZE = 5;
    private boolean[] isolatedHits;
    private boolean hasIsolatedHits;
    private boolean isSunk;

    public Battleship(Point start, Point end) {
        super(start, end);
        isolatedHits = new boolean[3];
        hasIsolatedHits = false;
        isSunk = false;
    }



    @Override
    public boolean get_shot(Point hitPoint) {
        boolean isHit = super.get_shot(hitPoint);
        if (isHit && !isSunk) {
            if (isIsolated(hitPoint)) {
                int index = getIsolatedHitIndex(hitPoint);
                isolatedHits[index] = true;
                if (checkIsolatedHits()) {
                    isSunk = true;
                    return true;
                }
            } else {
                hasIsolatedHits = true;
            }
        }
        return isHit;
    }

    private boolean isIsolated(Point hitPoint) {
        int hitX = (int) hitPoint.getX();
        int hitY = (int) hitPoint.getY();
        int startX = (int) start.getX();
        int endX = (int) end.getX();
        int startY = (int) start.getY();
        int endY = (int) end.getY();

        if (hitX == startX && hitY == startY - 1) {
            return true;
        } else if (hitX == startX && hitY == endY + 1) {
            return true;
        } else if (hitX == endX && hitY == startY - 1) {
            return true;
        } else if (hitX == endX && hitY == endY + 1) {
            return true;
        } else if (hitY == startY && hitX == startX - 1) {
            return true;
        } else if (hitY == startY && hitX == endX + 1) {
            return true;
        } else if (hitY == endY && hitX == startX - 1) {
            return true;
        } else if (hitY == endY && hitX == endX + 1) {
            return true;
        }
        return false;
    }


    private int getIsolatedHitIndex(Point hitPoint) {
        int hitX = (int) hitPoint.getX();
        int hitY = (int) hitPoint.getY();
        int startX = (int) start.getX();
        int endX = (int) end.getX();
        int startY = (int) start.getY();
        int endY = (int) end.getY();

        if (hitX == startX && hitY == startY - 1) {
            return 0;
        } else if (hitX == startX && hitY == endY + 1) {
            return 1;
        } else if (hitX == endX && hitY == startY - 1) {
            return 2;
        } else if (hitX == endX && hitY == endY + 1) {
            return 3;
        } else if (hitY == startY && hitX == startX - 1) {
            return 4;
        } else if (hitY == startY && hitX == endX + 1) {
            return 5;
        } else if (hitY == endY && hitX == startX - 1) {
            return 6;
        } else { // hitY == endY && hitX == endX + 1
            return 7;
        }
    }

    private boolean checkIsolatedHits() {
        for (boolean hit : isolatedHits) {
            if (!hit) {
                return false;
            }
        }
        return true;
    }

}


