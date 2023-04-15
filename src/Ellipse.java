import javax.swing.*;
import java.awt.*;
import java.lang.Math.*;
public class Ellipse extends Figure implements WorkWithFigure {
    Ellipse() {

    }
    Ellipse(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    Ellipse(int width, int height) {
        super(width, height);
    }

    public void constraction(Graphics g) {
        g.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    public void moveRight() {
        this.setX(this.getX() + 10);
    }
    public void moveLeft() {
        this.setX(this.getX() - 10);
    }

    public void moveUp() {
        this.setY(this.getY() - 10);
    }

    public void moveDown() {
        this.setY(this.getY() + 10);
    }
    public double getPerimeter() {
        if (this.getWidth() <= 0 || this.getHeight() <= 0) {
            return 0;
        } else {
        double perimeter = 2 * Math.PI * Math.sqrt((Math.pow(getHeight(), 2)
                + Math.pow(getWidth(), 2)) / 8);

        return perimeter;
        }
    }
    public double getSquare() {
        if(this.getWidth() <= 0 || this.getHeight() <= 0){
            return 0;
        } else {
            double square = Math.PI * ((this.getHeight() * this.getWidth()) / 4);

            return square;
        }
    }

    public void reduce() {
            this.setWidth(this.getWidth() - 10);
            this.setHeight(this.getHeight() - 10);
    }
    public void increase() {
        this.setWidth(this.getWidth() + 10);
        this.setHeight(this.getHeight() + 10);
    }
}
