import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BouncingSquare extends JFrame {
    private Rectangle1[] rectangles;
    private ColoredRect square;
    private BouncingBoxPanel panel;
    int dx = 10, dy = 10;

    public BouncingSquare() {
        setTitle("Bouncing Square Animation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rectangles = new Rectangle1[10];

        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new ColoredRect(10 + i * 60, 10 + i * 40, 60 + i * 60, 60 + i * 40, 10, 10,  Color.BLUE, Color.RED);
        }

        //square = new ColoredRect(10, 10, 50, 50, Color.green, Color.pink);

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
                panel.repaint();
            }
        });
        timer.start();

        panel = new BouncingBoxPanel();
        add(panel);
    }

    public void animate() {
        Rectangle bounds = getBounds();

        for (Rectangle1 rect : rectangles) {
            // Логика отскакивания для каждого прямоугольника
            if ((rect.x1 + rect.dx < 0) || (rect.x2 + rect.dx > bounds.width)) rect.dx = -rect.dx;
            if ((rect.y1 + rect.dy < 0) || (rect.y2 + rect.dy > bounds.height)) rect.dy = -rect.dy;

            rect.move(rect.dx, rect.dy);
        }

//        if ((square.x1 + dx < 0) || (square.x2 + dx > bounds.width)) dx = -dx;
//        if ((square.y1 + dy < 0) || (square.y2 + dy > bounds.height)) dy = -dy;
//
//        square.move(dx, dy);
    }




    private class BouncingBoxPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Rectangle1 square : rectangles) {
                // Рисование для каждого прямоугольника
                ((DrawableRect) square).draw(g);
            }
           // square.draw(g);
        }
    }
}