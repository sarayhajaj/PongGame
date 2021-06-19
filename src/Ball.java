import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle  {
    Random random;
    int XSpeed;
    int YSpeed;
    int initialSpeed = 2;

    public Ball(int x, int y, int width, int height) {
        super(x , y , width ,height);
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection * initialSpeed);
        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection * initialSpeed);
    }


    public void Paint(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(this.x , this.y , this.width , this.height);
    }


    public void move(int direction) {
        x += XSpeed;
        y += YSpeed;

    }

    public void setXDirection(int randomXDirection){
        XSpeed = randomXDirection;

    }
    public void setYDirection(int randomYDirection){
        YSpeed = randomYDirection;

    }
}
