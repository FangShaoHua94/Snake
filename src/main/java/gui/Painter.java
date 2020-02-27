package gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.Board;
import logic.Game;
import logic.Point;
import logic.Snake;

import static java.util.Objects.requireNonNull;
import static logic.Board.SIZE;
import static logic.Game.HEIGHT;


public class Painter {

    private static final String SCORE_TEXT="Score : %d";

    public static void paint(Game game, GraphicsContext gc){
        requireNonNull(game);
        requireNonNull(gc);
        paintBoard(game.getBoard(),gc);
        paintFood(game.getFood(),gc);
        paintSnake(game.getSnake(), gc);
        paintScore(game.getScore(),gc);
    }

    public static void paintFlicking(Game game, GraphicsContext gc){
        requireNonNull(game);
        requireNonNull(gc);
        paintBoard(game.getBoard(),gc);
        paintFood(game.getFood(),gc);
        paintDeadSnake(game.getSnake(), gc);
        paintScore(game.getScore(),gc);
    }

    private static void paintBoard(Board board, GraphicsContext gc){
        requireNonNull(board);
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, board.getWidth()*SIZE, board.getHeight()*SIZE);
    }

    private static void paintFood(Point food, GraphicsContext gc){
        requireNonNull(food);
        gc.setFill(Color.ROSYBROWN);
        paintPoint(food,gc);
    }

    private static void paintSnake(Snake snake, GraphicsContext gc){
        requireNonNull(snake);
        gc.setFill(Color.RED);
        paintPoint(snake.getHead(),gc);
        gc.setFill(Color.GREEN);
        snake.getBody().forEach(x->paintPoint(x,gc));
    }

    private static void paintDeadSnake(Snake snake, GraphicsContext gc){
        requireNonNull(snake);
        gc.setFill(Color.WHITE);
        paintPoint(snake.getHead(),gc);
        gc.setFill(Color.WHITE);
        snake.getBody().forEach(x->paintPoint(x,gc));
    }


    private static void paintPoint(Point point, GraphicsContext gc) {
        requireNonNull(point);
        gc.fillRect(point.getX() * SIZE, point.getY() * SIZE, SIZE, SIZE);
    }

    private static void paintScore(int score, GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.fillText(String.format(SCORE_TEXT,score*100),10,HEIGHT);
    }

}
