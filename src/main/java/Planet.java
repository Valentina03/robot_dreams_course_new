
public enum Planet {
    MERCURY(1, 0, 10, null),
    VENUS(2, 12, 50, MERCURY),
    EARTH(3, 18, 55, VENUS),
    MARS(4, 20, 40, EARTH),
    JUPITER(5, 30, 150, MARS),
    SATURN(6, 20, 130, JUPITER),
    URANUS(7, 30, 80, SATURN),
    NEPTUNE(8, 25, 70, URANUS),
    PLUTO(9, 45, 5, NEPTUNE);

    private final int number;
    private final int distanceFromPrevious;
    private final int distanceFromSun;
    private final int radius;
    final Planet previous;
    Planet next;

    public int getNumber() {
        return number;
    }

    public int getDistanceFromPrevious() {
        return distanceFromPrevious;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getRadius() {
        return radius;
    }

    public Planet getPrevious() {
        return previous;
    }

    public Planet getNext() {
        return next;
    }

    Planet(int number, int distanceFromPrevious, int radius, Planet previous) {
        this.number = number;
        this.distanceFromPrevious = distanceFromPrevious;
        this.radius = radius;
        this.previous = previous;
        if (previous != null) {
            this.distanceFromSun = previous.distanceFromSun + distanceFromPrevious + 10;
            previous.next = this;
        } else {
            this.distanceFromSun = 10;
        }
    }
}


