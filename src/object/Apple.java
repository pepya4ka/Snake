package object;

import javax.swing.*;
import java.awt.*;

public class Apple {

    private Image apple;
    private int appleX;
    private int appleY;

    public Apple() {
        loadImage();
    }

    public void loadImage() {
        ImageIcon imageIcon = new ImageIcon("apple.png");
        apple = imageIcon.getImage();
    }

    public int getAppleX() {
        return appleX;
    }

    public void setAppleX(int appleX) {
        this.appleX = appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public void setAppleY(int appleY) {
        this.appleY = appleY;
    }

    public Image getApple() {
        return apple;
    }
}
