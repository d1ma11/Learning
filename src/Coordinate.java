public class Coordinate {
    private double xCoord;
    private double yCoord;

    private Coordinate(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    public static final Coordinate fromXY(double x, double y) {
        return new Coordinate(x,y);
    }

    public static final Coordinate fromPolar(double dist, double angle) {
        return new Coordinate(dist*Math.cos(angle), dist*Math.sin(angle));
    }
}