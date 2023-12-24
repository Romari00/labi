import java.awt.*;

public class DrawableRect extends Rectangle {
    private Color outColor;

    public DrawableRect(int x1, int y1, int x2, int y2, Color outColor) {
        super(x1, y1, x2, y2);
        this.outColor = outColor;
    }

    public void draw(Graphics g) {
        g.setColor(outColor);
        g.drawRect(super.x1, super.y1, super.x2 - super.x1, super.y2 - super.y1);
    }

}