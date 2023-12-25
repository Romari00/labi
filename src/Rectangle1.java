import java.awt.*;

public class Rectangle1 {
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int dx;
    public int dy;

    public Rectangle1(int x1, int y1, int x2, int y2, int dx, int dy) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void reverseDx() {
        dx = -dx;
    }

    public void reverseDy() {
        dy = -dy;
    }



    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public Rectangle1(int width, int height) {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = x1 + width;
        this.y2 = y1 + height;
    }


    public Rectangle1() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    public void move(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;
    }

//    public Rectangle1 union(Rectangle1 rect2) {
//        return new Rectangle1(
//                x1 > rect2.x1 ? rect2.x1 : x1,
//                y1 > rect2.y1 ? y1 : rect2.y1,
//                x2 > rect2.x2 ? x2 : rect2.x2,
//                y2 > rect2.y2 ? rect2.y2 : y2
//        );
//    }

    public void draw(Graphics g) {
        // реализация отрисовки
        g.setColor(Color.black);
        g.drawRect(x1, y1, x2 - x1, y2 - y1);
    }

    public boolean contains(Point point) {
        return point.x >= x1 && point.x <= x2 && point.y >= y1 && point.y <= y2;
    }

    public void rect_print() {
        System.out.println("x1 =" + x1 + " y1 =" + y1 + " x2 =" + x2 + " y2 =" + y2 + "\n");
    }


}