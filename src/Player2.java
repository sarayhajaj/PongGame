import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player2 extends Rectangle {
    int ySpeed2;
    int speed = 10;

    public Player2(int x, int y, int width, int height, int id) {
        super(x,y,width,height);
    }

    public void setYDirection(int yDirection){
        ySpeed2 = yDirection;
    }


    public void move(int direction){
        switch (direction) {
            case 1:
                this.y--;
                break;
            case 2:
                this.y++;
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_DOWN:
                setYDirection(-speed);
                move(2);
                break;
            case KeyEvent.VK_UP:
                setYDirection(speed);
                move(1);
                break;
        }
    }

    public void keyReleased (KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_DOWN:
                setYDirection(0);
                break;
            case KeyEvent.VK_UP:
                setYDirection(0);
                break;
        }
    }
    public void Paint(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(this.x , this.y , this.width , this.height);
    }
}
