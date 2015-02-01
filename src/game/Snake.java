package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Collections;

public class Snake {
    public static LinkedList<SnakePart> body;
    public SnakePart head;

    private int velX, velY; //velocity

    public Snake(){
        body = new LinkedList<>();
        Collections.addAll(body,
                new SnakePart(1, 2),
                new SnakePart(2, 2),
                new SnakePart(3, 2));

        head = body.peekLast();
        velX = 1;
        velY = 0;
    }

    public void drawSnake(Graphics g){
        for (SnakePart snakePart : body) {

            //Draw the body of the snake
            g.setColor(Color.black);
            g.fillRect(snakePart.x*snakePart.BOX_SIZE, snakePart.y*snakePart.BOX_SIZE, snakePart.BOX_SIZE, snakePart.BOX_SIZE);

            //Draws the border of each box
            g.setColor(Color.black);
            g.drawRect(snakePart.x*snakePart.BOX_SIZE, snakePart.y*snakePart.BOX_SIZE, snakePart.BOX_SIZE, snakePart.BOX_SIZE);
        }
    }

}
