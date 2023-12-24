import java.awt.*;



public class Main {

    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle(1, 2, 5, 7);
        Rectangle myRectangle1 = new Rectangle();
        Rectangle myRectangle2 = new Rectangle(5, 10);
        myRectangle.rect_print();
        myRectangle1.rect_print();
        myRectangle2.rect_print();
        Rectangle unionRect = myRectangle.union(myRectangle2);
        unionRect.rect_print();
        myRectangle1.move(5, 2);
        myRectangle1.rect_print();
        DrawableRect drawableRect = new DrawableRect(10, 20, 30, 40, Color.BLUE);
        BouncingSquare bouncingSquare = new BouncingSquare();
        bouncingSquare.setVisible(true);

        // Добавляем вывод координат квадрата в консоль
        for (int i = 0; i < 10; i++) {
            bouncingSquare.animate();
            try {
                Thread.sleep(100); // Даем немного времени для визуализации
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}