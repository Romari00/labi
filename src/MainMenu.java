import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private BouncingSquare bouncingSquare;
    public MainMenu() {
        setTitle("Главное меню");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 1));
        bouncingSquare = new BouncingSquare();

        JButton rectangleButton = new JButton("Создать квадрат");
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle1 rectangle = new Rectangle1(50, 50, 100, 100, 10, 10);
                showAnimationWindow(rectangle);
            }
        });

        JButton coloredRectButton = new JButton("Создать квадрат закрашенный с цветной обводкой");
        coloredRectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle1 coloredRect = new ColoredRect(50, 50, 100, 100, 10, 10, Color.magenta, Color.pink);
                showAnimationWindow(coloredRect);
            }
        });

        JButton drawableRectButton = new JButton("Создать квадрат с цветной обводкой");
        drawableRectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle1 drawableRect = new DrawableRect(50, 50, 100, 100, 10, 10, Color.orange);
                showAnimationWindow(drawableRect);
            }
        });

        add(rectangleButton);
        add(coloredRectButton);
        add(drawableRectButton);
    }

    private void showAnimationWindow(Rectangle1 rectangle) {
        bouncingSquare.addRectangle(rectangle);
        bouncingSquare.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        });
    }
}
