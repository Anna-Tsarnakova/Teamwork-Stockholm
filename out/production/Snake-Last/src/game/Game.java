package game;

import display.Display;
import gfx.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Game implements Runnable{
    private Display display;
    public int width, height;
    public String title;

    public static Snake snake;
    public int x = 10, y = 10;
    private int size = 5;


    private boolean isRunning;
    private Thread thread;

    private InputHandler inputHandler;
    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage img, img2;


    private Image ball;


    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

    }

    private void init(){
        display = new Display(this.width, this.height, this.title);
        snake = new Snake();
        img = ImageLoader.loadImage("/images/background.jpg", this.width, this.height);

    }



    @Override
    public void run() {
        init();
        while (isRunning) {
            tick();
            render();
            try {
                Thread.sleep(15);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void tick(){

    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            //Create 2 buffers
            display.getCanvas().createBufferStrategy(2);
            bs = display.getCanvas().getBufferStrategy();
            //returns out of the method to prevent errors
            return;
        }
        g = bs.getDrawGraphics();
       // g.clearRect(0,0,this.width,this.height);

        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        snake.drawSnake(g);
        bs.show();
        g.dispose();

    }
    public synchronized void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
