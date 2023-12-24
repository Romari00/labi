import java.awt.*;

public class ColoredRect extends DrawableRect {
    private Color inColor;

    public ColoredRect(int x1, int y1, int x2, int y2, Color outColor, Color inColor) {
        super(x1, y1, x2, y2, outColor);
        this.inColor = inColor;
    }
    

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.cyan);
        g.drawRect(super.x1, super.y1, super.x2 - super.x1, super.y2 - super.y1);

        g.setColor(inColor);
        g.fillRect(super.x1 + 1, super.y1 + 1, super.x2 - super.x1 - 1, super.y2 - super.y1 - 1);
    }
}
