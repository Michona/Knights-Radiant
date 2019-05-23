package player;

public enum Location {
    CURRENT(0, 0);

    public int x;
    public int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void updateLocation(int deltaX, int deltaY) {

        if (x + deltaX >= 0) {
            x += deltaX;
        }

        if (y + deltaY >= 0) {
            y += deltaY;
        }
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
