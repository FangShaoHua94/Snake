package logic;

public class Board {

    public static final int SIZE = 10;

    private final int height;
    private final int width;

    public Board(int width, int height){
        this.width=width/SIZE;
        this.height=height/SIZE;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}
