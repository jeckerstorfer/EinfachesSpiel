package view;

import javax.swing.*;

/**
 * @author Julius Eckerstorfer
 * @version 2026-09-25
 * Das Frame des Spieles
 */
public class GewinnFrame extends JFrame {
    public GewinnFrame(GewinnPanel panel) {
        super("Zahlen-Gewinnspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
