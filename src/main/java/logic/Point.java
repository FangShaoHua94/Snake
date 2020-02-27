package logic;

import java.util.Objects;

public class Point {

    private final int coordinateX;
    private final int coordinateY;

    public Point(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Point(Point point, int coordinateX, int coordinateY) {
        this.coordinateX = point.getCoordinateX() + coordinateX;
        this.coordinateY = point.getCoordinateY() + coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return coordinateX == point.coordinateX && coordinateY == point.coordinateY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }
}
