import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement extends KeyAdapter {
    private GamePanel panel;
    Player2 player2;
    Player1 player1;

    public PlayerMovement(GamePanel panel){
        this.panel = panel;
        this.player1 = panel.getPlayer1();
        this.player2 = panel.getPlayer2();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e){
        this.player1.keyPressed(e);
        this.player2.keyPressed(e);
    }
    public void keyReleased (KeyEvent e) {
        this.player1.keyReleased(e);
        this.player2.keyReleased(e);

    }
}


