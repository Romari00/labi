import java.awt.*;
public class Rectangle {
    public int x1;
    public int y1;
    public int x2;
    public int y2;


    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle(int width, int height) {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = x1 + width;
        this.y2 = y1 + height;
    }


    public Rectangle() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    public void move(int dx, int dy) {
        this.x1 += dx;
        this.y1 += dy;
        this.x2 += dx;
        this.y2 += dy;
    }

    public Rectangle union(Rectangle rect2) {
        return new Rectangle(
                x1 > rect2.x1 ? rect2.x1 : x1,
                y1 > rect2.y1 ? y1 : rect2.y1,
                x2 > rect2.x2 ? x2 : rect2.x2,
                y2 > rect2.y2 ? rect2.y2 : y2
        );
    }

    public void rect_print() {
        System.out.println("x1 =" + x1 + " y1 =" + y1 + " x2 =" + x2 + " y2 =" + y2 + "\n");
    }


}