import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {
    Thread gameThread;
    Random random;
    private Player1 player1;
    private Player2 player2;
    private Ball ball;
    private Score score;

    public Player1 getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player1 player1) {
        this.player1 = player1;
    }

    public Player2 getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player2 player2) {
        this.player2 = player2;
    }

    public GamePanel() {
        newPlayer1();
        newPlayer2();
        newBall();
        score = new Score(Def.GAME_WIDTH,Def.GAME_HEIGHT);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        gameThread = new Thread(this);
        gameThread.start();
        mainGameLoop();
    }

    public void newBall(){
        random = new Random();
        this.ball = new Ball((Def.GAME_WIDTH/2) - (Def.PONG_START_WIDTH/2) ,
                random.nextInt(Def.GAME_HEIGHT-Def.PONG_START_WIDTH) ,
                Def.PONG_START_WIDTH, Def.PONG_START_WIDTH );
    }
    public void newPlayer1() {
        this.player1 = new Player1(0, (Def.GAME_HEIGHT / 2) - (Def.PADDLE_HEIGHT / 2),
                Def.PADDLE_WIDTH, Def.PADDLE_HEIGHT, 1);
    }
    public void newPlayer2() {
        this.player2 = new Player2(Def.GAME_WIDTH - (Def.PADDLE_WIDTH + 15),
                (Def.GAME_HEIGHT / 2) - (Def.PADDLE_HEIGHT / 2), Def.PADDLE_WIDTH, Def.PADDLE_HEIGHT, 2);
    }

    public void move(int direction){
        this.player1.move(direction);
        this.player2.move(direction);
        this.ball.move(direction);

    }
    public void checkCollision() {
        if (ball.y >= 0) {
            ball.setYDirection(-ball.YSpeed);
        }
        if (ball.y <= Def.GAME_HEIGHT - Def.PONG_START_WIDTH) {
            ball.setYDirection(-ball.YSpeed);
        }
        if (ball.intersects(player1)) {
            ball.XSpeed = Math.abs(ball.XSpeed);
            ball.XSpeed++;
            if (ball.YSpeed > 0)
                ball.YSpeed++;
            else
                ball.YSpeed--;
            ball.setXDirection(ball.XSpeed);
            ball.setYDirection(ball.YSpeed);
        }
        if (ball.intersects(player2)) {
            ball.XSpeed = Math.abs(ball.XSpeed);
            ball.XSpeed++;
            if (ball.YSpeed > 0)
                ball.YSpeed++;
            else
                ball.YSpeed--;
            ball.setXDirection(-ball.XSpeed);
            ball.setYDirection(ball.YSpeed);
        }
        if (player1.y <= 0)
            player1.y = 0;
        if (player1.y >= (Def.GAME_HEIGHT - Def.PADDLE_HEIGHT))
            player1.y = Def.GAME_HEIGHT - Def.PADDLE_HEIGHT;
        if (player2.y <= 0)
            player2.y = 0;
        if (player2.y >= (Def.GAME_HEIGHT - Def.PADDLE_HEIGHT))
            player2.y = Def.GAME_HEIGHT - Def.PADDLE_HEIGHT;
        if (ball.x <= 0) {
            score.player2++;
            newPlayer1();
            newPlayer2();
            newBall();
            System.out.println("Player 2: " + score.player2);
        }
        if (ball.x >= Def.GAME_WIDTH - Def.PONG_START_HEIGHT) {
            score.player1++;
            newPlayer1();
            newPlayer2();
            newBall();
            System.out.println("Player 1: " + score.player1);
        }
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        this.ball.Paint(graphics);
        this.player1.Paint(graphics);
        this.player2.Paint(graphics);
        this.score.Paint(graphics);

    }

    public void mainGameLoop() {
        new Thread(() -> {
            while (true) {
                move(0);
                checkCollision();
                repaint();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    @Override
    public void run() {

    }
}

