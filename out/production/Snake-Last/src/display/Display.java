package display;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas{
    private JFrame frame;
    private Canvas canvas;

    private int width;
    private int height;
    private String title;

    public Display(int width, int height, String title){
        this.width = width;
        this.height = height;
        this.title = title;

        createFrame();
    }

    private void createFrame(){
        //Create a new Frame
        frame = new JFrame(this.title);
        frame.setSize(this.width, this.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setFocusable(true);

        //Initializing Canvas in the window
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();
    }

    //Create a getter to access the Canvas object from other classes
    public Canvas getCanvas() {
        return this.canvas;
    }

}
