package frame;

import object.Apple;
import object.Snake;
import enums.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {

    private boolean inGame = true;
    private Timer timer;
    private Snake snake;
    Apple apple;

    public GamePanel() {
        //setOpaque(true);
        setBackground(Color.DARK_GRAY);
        snake = new Snake();
        initGame();
        addKeyListener(new KeyboardListener());
        setFocusable(true);
    }

    public void initGame() {
        snake.setSizeSnake(3);
        int[] x = snake.getSnakeX();
        int[] y = snake.getSnakeY();
        for (int i = 0; i < snake.getSizeSnake(); i++) {
            x[i] = 48 - i * Constants.OBJECT_SIZE.getNumber();
            y[i] = 48;
        }
        snake.setSnakeX(x);
        snake.setSnakeY(y);
        timer = new Timer(250, this);
        timer.start();
        apple = new Apple();
        creatApple();
    }

    public void creatApple() {
        apple.setAppleX(new Random().nextInt(20) * Constants.OBJECT_SIZE.getNumber());
        apple.setAppleY(new Random().nextInt(20) * Constants.OBJECT_SIZE.getNumber());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(apple.getApple(), apple.getAppleX(), apple.getAppleY(), this);
            for (int i = 0; i < snake.getSizeSnake(); i++) {
                g.drawImage(snake.getSnake(), snake.getSnakeX()[i], snake.getSnakeY()[i], this);
            }
        }
    }

    public void move() {
        int[] x = snake.getSnakeX();
        int[] y = snake.getSnakeY();
        for (int i = snake.getSizeSnake(); i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (snake.isLeft())
            x[0] -= Constants.OBJECT_SIZE.getNumber();
        if (snake.isRight())
            x[0] += Constants.OBJECT_SIZE.getNumber();
        if (snake.isUp())
            y[0] -= Constants.OBJECT_SIZE.getNumber();
        if (snake.isDown())
            y[0] += Constants.OBJECT_SIZE.getNumber();
        snake.setSnakeX(x);
        snake.setSnakeY(y);
    }

    public void checkApple() {
        if (snake.getSnakeX()[0] == apple.getAppleX() && snake.getSnakeY()[0] == apple.getAppleY()) {
            snake.setSizeSnake(snake.getSizeSnake() + 1);
            creatApple();
        }
    }

    public void checkCollisions() {
        for (int i = snake.getSizeSnake(); i > 0; i--) {
            if (i >= 4 && snake.getSnakeX()[i] == snake.getSnakeX()[0] && snake.getSnakeY()[i] == snake.getSnakeY()[0]) {
                inGame = false;
            }
        }

        int tempX = snake.getSnakeX()[0];
        int tempY = snake.getSnakeY()[0];
        if (tempX > Constants.SIZE.getNumber() || tempX < 0 || tempY > Constants.SIZE.getNumber() || tempY < 0) {
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollisions();
            move();
        }
        repaint();
    }

    class KeyboardListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    if (!snake.isRight()) {
                        snake.setLeft(true);
                        snake.setDown(false);
                        snake.setUp(false);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (!snake.isLeft()) {
                        snake.setRight(true);
                        snake.setDown(false);
                        snake.setUp(false);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (!snake.isDown()) {
                        snake.setUp(true);
                        snake.setLeft(false);
                        snake.setRight(false);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (!snake.isUp()) {
                        snake.setDown(true);
                        snake.setLeft(false);
                        snake.setRight(false);
                    }
                    break;
            }
        }
    }
}
