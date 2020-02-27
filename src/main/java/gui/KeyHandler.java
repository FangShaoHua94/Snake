package gui;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import logic.Direction;
import logic.Snake;

import static java.util.Objects.requireNonNull;

public class KeyHandler implements EventHandler<KeyEvent> {

    private final Snake snake;

    public KeyHandler(Snake snake){
        requireNonNull(snake);
        this.snake=snake;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        Direction direction=snake.getDirection();
        switch (keyEvent.getCode()){
        case UP:
            if(direction!= Direction.UP && direction!= Direction.DOWN) {
                snake.updateDirection(Direction.UP);
            }
            break;
        case DOWN:
            if(direction!= Direction.UP && direction!= Direction.DOWN) {
                snake.updateDirection(Direction.DOWN);
            }
            break;
        case LEFT:
            if(direction!= Direction.RIGHT && direction!= Direction.LEFT) {
                snake.updateDirection(Direction.LEFT);
            }
            break;
        case RIGHT:
            if(direction!= Direction.RIGHT && direction!= Direction.LEFT) {
                snake.updateDirection(Direction.RIGHT);
            }
            break;
        }
    }
}
