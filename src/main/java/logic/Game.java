package logic;

import gui.Painter;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable{

    public static final int HEIGHT=400;
    public static final int WIDTH=500;
    public static final long GAME_DELAY=70;
    public static final int FLICKING=10;
    public static final int FLICKING_DELAY=50;

    private Snake snake;
    private Board board;
    private Point food;
    private final GraphicsContext gc;

    public Game(GraphicsContext gc){
        this.gc=gc;
        board=new Board(WIDTH,HEIGHT);
        snake=new Snake();
        generateFood();
    }

    public Snake getSnake(){
        return snake;
    }

    public Point getFood(){
        return food;
    }

    public Board getBoard(){
        return board;
    }

    public int getScore(){
        return snake.getBody().size()-2;
    }

    @Override
    public void run(){
        while(!isEndGame()){
            Painter.paint(this,gc);
            snake.move();
            if(snake.hasAte(food)){
                snake.grow();
                generateFood();
            }
            delay(GAME_DELAY);
        }
        endGame();
    }

    public boolean isEndGame(){
        return snake.selfCollide() || snake.outOfBound(board.getWidth(),board.getHeight());
    }

    public void generateFood(){
        do{
            Random random=new Random(System.currentTimeMillis());
            food=new Point(random.nextInt(board.getWidth()),random.nextInt(board.getHeight()));
        }while(snake.collide(food));
    }

    public void delay(long delayTime){
        try{
            TimeUnit.MILLISECONDS.sleep(delayTime);
        }catch (InterruptedException ie){
            //suppress
        }
    }

    public void endGame(){
        for(int i=0;i<FLICKING;i++){
            Painter.paintFlicking(this,gc);
            delay(FLICKING_DELAY);
            Painter.paint(this,gc);
            delay(FLICKING_DELAY);
        }
    }
}
