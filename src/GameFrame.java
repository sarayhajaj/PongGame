import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    private GamePanel panel;


    public static void main(String[] args) {
        new GameFrame();

    }
    public GameFrame() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Def.GAME_WIDTH, Def.GAME_HEIGHT);
        this.setLayout(null);
        this.setTitle("Pong Game");
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        panel = new GamePanel();
        panel.setBounds(0, 0, Def.GAME_WIDTH, Def.GAME_HEIGHT);
        this.add(panel);
        PlayerMovement playerMovement = new PlayerMovement(this.panel);
        this.addKeyListener(playerMovement);
        this.setLocationRelativeTo(null);
    }

}


