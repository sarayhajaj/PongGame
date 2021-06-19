import java.awt.*;
import javax.swing.*;

public class Score extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void Paint (Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("pong", Font.BOLD,60));
        graphics.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10),
                (GAME_WIDTH / 2) - 70, 50);
        graphics.drawString(String.valueOf(player2 / 10) + String.valueOf(player2 % 10), (GAME_WIDTH / 2) + 20, 50);
    }
}
