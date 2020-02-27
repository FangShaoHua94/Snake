
import gui.KeyHandler;
import gui.Painter;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Game;

import static logic.Game.HEIGHT;
import static logic.Game.WIDTH;

public class Main extends Application {

    @Override
    public void start(Stage stage){
        Pane root = new Pane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Game game = new Game(gc);
        Painter.paint(game, gc);
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(new KeyHandler(game.getSnake()));
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Snake");
        stage.show();
        (new Thread(game)).start();
    }

}
