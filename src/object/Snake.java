package object;

import enums.Constants;

import javax.swing.*;
import java.awt.*;

public class Snake {
    private Image snake;
    private int[] snakeX = new int[Constants.ALL_AMOUNT_OBJECT.getNumber()];
    private int[] snakeY = new int[Constants.ALL_AMOUNT_OBJECT.getNumber()];
    private int sizeSnake;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    public Snake() {
        loadImage();
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int[] getSnakeX() {
        return snakeX;
    }

    public void setSnakeX(int[] snakeX) {
        this.snakeX = snakeX;
    }

    public int[] getSnakeY() {
        return snakeY;
    }

    public void setSnakeY(int[] snakeY) {
        this.snakeY = snakeY;
    }

    public void loadImage() {
        ImageIcon imageIcon = new ImageIcon("dot.png");
        snake = imageIcon.getImage();
    }

    public int getSizeSnake() {
        return sizeSnake;
    }

    public void setSizeSnake(int sizeSnake) {
        this.sizeSnake = sizeSnake;
    }

    public Image getSnake() {
        return snake;
    }
}
