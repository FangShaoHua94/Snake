package logic;

import java.util.ArrayDeque;

import static java.util.Objects.requireNonNull;

public class Snake {

    private Point head;
    private ArrayDeque<Point> body = new ArrayDeque<>();
    private Direction direction;

    /**
     * Initiates a snake object.
     */
    public Snake() {
        head = new Point(3, 2);
        body.add(new Point(2, 2));
        body.add(new Point(1, 2));
        direction = Direction.RIGHT;
    }

    public Point getHead() {
        return head;
    }

    public ArrayDeque<Point> getBody() {
        return body;
    }

    public boolean selfCollide() {
        return bodyCollide(head);
    }

    public boolean bodyCollide(Point point) {
        requireNonNull(point);
        return body.stream().anyMatch(x -> x.equals(point));
    }

    public boolean collide(Point point) {
        requireNonNull(point);
        return head.equals(point) || bodyCollide(point);
    }

    /**
     * Check if the snake collide with the wall.
     * @param width is the x coordinate of the head.
     * @param height is the y coordinate of the head.
     * @return if the snake collide with the wall.
     */
    public boolean outOfBound(int width, int height) {
        int x = head.getCoordinateX();
        int y = head.getCoordinateY();
        return x < 0 || x >= width || y < 0 || y >= height;
    }

    public void updateDirection(Direction direction) {
        requireNonNull(direction);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean hasAte(Point food) {
        requireNonNull(food);
        return head.equals(food);
    }

    public void grow() {
        body.addLast(body.getLast());
    }

    /**
     * Updates the location of the head and body of the snake.
     */
    public void move() {
        body.removeLast();
        body.addFirst(head);
        switch (direction) {
        case UP:
            head = new Point(head, 0, -1);
            break;
        case DOWN:
            head = new Point(head, 0, 1);
            break;
        case LEFT:
            head = new Point(head, -1, 0);
            break;
        case RIGHT:
            head = new Point(head, 1, 0);
            break;
        default:
            break;
        }
    }

}
