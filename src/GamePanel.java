import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int origTileSize = 16; // 16x16 tile
    final int scale = 3;

    final int tileSize = origTileSize * scale; // 48x48 tile
    final int maxScreenCol = 18;
    final int maxScreenRow = 15;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 768 pixels

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.orange);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // will call run method automatically
    }

    @Override
    public void run() {
        while (gameThread != null) {
            // UPDATE: update information such as stone position
            update();
            // DRAW: draw the screen with updated information
            repaint();
        }
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.black);
        g2.fillOval(100, 100, tileSize, tileSize);
        g2.dispose();
    }
}
