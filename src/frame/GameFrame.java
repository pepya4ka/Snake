package frame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 335);
        setResizable(false);
        setLocation(400, 400);
        add(new GamePanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
    }
}
