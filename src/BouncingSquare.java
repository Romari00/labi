import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class BouncingSquare extends JFrame {
    private List<Rectangle1> rectangles;
    private Rectangle1 selectedRectangle;
    private int offsetX, offsetY;
    int dx = 10, dy = 10;

    public BouncingSquare() {
        setTitle("Bouncing Square Animation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rectangles = new ArrayList<>();

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
                repaint();
            }
        });
        timer.start();

        BouncingBoxPanel panel = new BouncingBoxPanel();
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMousePress(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                handleMouseRelease(e);
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                handleMouseDrag(e);
            }
        });

        add(panel);
    }

    private void handleMousePress(MouseEvent e) {
        for (Rectangle1 rectangle : rectangles) {
            if (rectangle.contains(e.getPoint())) {
                selectedRectangle = rectangle;
                offsetX = e.getX() - rectangle.getX1();
                offsetY = e.getY() - rectangle.getY1();
                break;
            }
        }
    }

    private void handleMouseDrag(MouseEvent e) {
        if (selectedRectangle != null) {
            int newX = e.getX() - offsetX;
            int newY = e.getY() - offsetY;

            selectedRectangle.move(newX - selectedRectangle.getX1(), newY - selectedRectangle.getY1());

            repaint();
        }
    }

    private void handleMouseRelease(MouseEvent e) {
        selectedRectangle = null;
    }

    public void addRectangle(Rectangle1 rectangle) {
        rectangles.add(rectangle);
    }

    public void animate() {
        Rectangle bounds = getBounds();

        for (Rectangle1 rectangle : rectangles) {
            int dx = rectangle.getDx();
            int dy = rectangle.getDy();

            if ((rectangle.getX1() + dx < 0) || (rectangle.getX2() + dx > bounds.width)) rectangle.reverseDx();
            if ((rectangle.getY1() + dy < 0) || (rectangle.getY2() + dy > bounds.height)) rectangle.reverseDy();

            rectangle.move(dx, dy);
        }
    }

    private class BouncingBoxPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Рисование для каждого прямоугольника
            for (Rectangle1 rectangle : rectangles) {
                rectangle.draw(g);
            }
        }
    }
}
