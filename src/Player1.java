import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player1 extends Rectangle {
    int ySpeed;
    int speed = 10;

    public Player1(int x, int y, int width, int height,int id) {
        super(x,y,width,height);
    }

    public void setYDirection(int yDirection){
        ySpeed = yDirection;
    }


    public void move(int direction){
        switch (direction){
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
            case KeyEvent.VK_S:
                setYDirection(-speed);
                move(2);
                break;
            case KeyEvent.VK_W:
                setYDirection(speed);
                move(1);
                break;
        }
    }
    public void keyReleased (KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_S:
                setYDirection(0);
                break;
            case KeyEvent.VK_W:
                setYDirection(0);
                break;
        }
    }
    public void Paint(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(this.x , this.y , this.width , this.height);
    }

}
