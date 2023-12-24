import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingSquare extends JFrame {
    private ColoredRect square;

    public BouncingSquare() {
        setTitle("Bouncing Square Animation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        square = new ColoredRect(50, 50, 100, 100, Color.red, Color.blue);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
                repaint();
            }
        });
        timer.start();
    }
    public void animate() {
        Rectangle bounds = getBounds();
        int dx = 5;
        int dy = 5;

        if (square.x1 + dx < 0 || square.x2 + dx > bounds.width) {
            dx = -dx;
        }
        if (square.y1 + dy < 0 || square.y2 + dy > bounds.height) {
            dy = -dy;
        }
        square.move(dx, dy);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        square.draw(g);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BouncingSquare().setVisible(true);
            }
        });
    }
}
