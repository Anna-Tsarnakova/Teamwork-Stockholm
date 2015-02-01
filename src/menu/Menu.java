package menu;

import game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame {
    private final int WIDTH_SCREEN = 250;
    private final int HEIGHT_SCREEN = 300;
    private final int WIDTH_BUTTON = 150;
    private final int HEIGHT_BUTTON = 50;

    static JButton Play;
    static JButton Exit;

    public Menu(){

        addButtons();
        addActions();

        getContentPane().setLayout(null);

        Play.setBounds(50, 30, WIDTH_BUTTON, HEIGHT_BUTTON);
        Exit.setBounds(50, 110, WIDTH_BUTTON, HEIGHT_BUTTON);

        getContentPane().add(Play);
        getContentPane().add(Exit);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(WIDTH_SCREEN, HEIGHT_SCREEN);
        setTitle("SNAKE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    private static void addButtons(){
        Play = new JButton("PLAY");
        Exit = new JButton("EXIT");

    }

    private void addActions(){

        Play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Game game = new Game("SNAKE", 700, 700);
                game.start();
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
