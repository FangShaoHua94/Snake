package gui;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import logic.Direction;
import logic.Game;
import logic.Snake;

import static java.util.Objects.requireNonNull;

public class KeyHandler implements EventHandler<KeyEvent> {

    private Game game;
    private GraphicsContext gc;

    public KeyHandler(Game game, GraphicsContext gc) {
        this.game=game;
        this.gc=gc;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        Snake snake = game.getSnake();
        Direction direction = snake.getDirection();
        switch (keyEvent.getCode()) {
        case UP:
            if (direction != Direction.UP && direction != Direction.DOWN) {
                snake.updateDirection(Direction.UP);
            }
            break;
        case DOWN:
            if (direction != Direction.UP && direction != Direction.DOWN) {
                snake.updateDirection(Direction.DOWN);
            }
            break;
        case LEFT:
            if (direction != Direction.RIGHT && direction != Direction.LEFT) {
                snake.updateDirection(Direction.LEFT);
            }
            break;
        case RIGHT:
            if (direction != Direction.RIGHT && direction != Direction.LEFT) {
                snake.updateDirection(Direction.RIGHT);
            }
            break;
        case ENTER:
            game.terminateGame();
            game = new Game(gc);
            (new Thread(game)).start();
            break;
        default:
            break;
        }
    }
}
