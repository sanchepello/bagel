import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//в наш главный класс наследуем сразу окно, что позволяет не создавать объект
//frame а сразу писать методы по типу setTitle()

//а также используем интерфейс KeyListener для отcлеживания нажатий кнопок
public class Bagel extends JFrame implements KeyListener {
    //создаем 2 эллипса, то есть бублик
    Ellipse OvalBig = new Ellipse(150, 150, 300, 400);
    Ellipse OvalSmall = new Ellipse(200, 200, 200, 300);

    //main точка входа в программу поэтому просто запускаем окно
    public static void main(String[] args) {
        new Bagel();
    }

    // это главный конструктор, где задаем значения для формы
    public Bagel(){
        //название
        setTitle("Бублик");
        //размер
        setSize(600, 600);
        //окно фиксированного размера
        setResizable(true);
        //делаем его видимым
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);
    }

    //это отрисовка изображения, вызывается автоматически
    @Override
    public void paint(Graphics g) {
        //очищаем фрейм
        super.paint(g);

        //вычисляем значения периметров и площадь
        double temp = OvalBig.getSquare() - OvalSmall.getSquare();
        temp /= 100;
        String square =  String.format("%.2f", temp);

        temp = OvalBig.getPerimeter() / 10;
        String bigPerimeter = String.format("%.2f", temp);

        temp = OvalSmall.getPerimeter() / 10;
        String smallPerimeter = String.format("%.2f", temp);

        //выводим
        g.drawString("Периметр внешней границы бублика: "
                + bigPerimeter + "см", 10, 50);
        g.drawString("Периметр дырки от бублика: "
                + smallPerimeter + "см", 10, 80);
        g.drawString("Площадь: " + square + "cм2", 10, 110);

        //это нужно для перемещения с новыми данными рисуются
        g.drawOval(OvalBig.getX(), OvalBig.getY(), 4, 4);
        g.fillOval(OvalBig.getX(), OvalBig.getY(), 4, 4);

        g.drawOval(OvalSmall.getX(), OvalSmall.getY(), 4, 4);
        g.fillOval(OvalSmall.getX(), OvalSmall.getY(), 4, 4);

        //чисто чтобы нарисовать линии и чтобы они не шли дальше
        if(OvalBig.getPerimeter() > 0) {
            g.drawLine(OvalBig.getX(), OvalBig.getY(),
                    OvalBig.getX() + OvalBig.getWidth(), OvalBig.getY());

            g.drawLine(OvalBig.getX(), OvalBig.getY(), OvalBig.getX(),
                    OvalBig.getY() + OvalBig.getHeight());
        }

        if(OvalSmall.getPerimeter() > 0) {
            g.drawLine(OvalSmall.getX(), OvalSmall.getY(),
                    OvalSmall.getX() + OvalSmall.getWidth(), OvalSmall.getY());

            g.drawLine(OvalSmall.getX(), OvalSmall.getY(), OvalSmall.getX(),
                    OvalSmall.getY() + OvalSmall.getHeight());
        }

        //а это первая отрисовка кругов
        OvalBig.constraction(g);
        OvalSmall.constraction(g);
    }

    //функция чекает кнопки и в соответствии с ними вызывает перемещения
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode();

        Graphics g = this.getGraphics();
        switch (KeyCode) {
            case KeyEvent.VK_RIGHT:
                //двигаем и обновляем фрейм
                OvalBig.moveRight();
                OvalSmall.moveRight();
                paintAll(g);
                break;

            case KeyEvent.VK_LEFT:
                OvalBig.moveLeft();
                OvalSmall.moveLeft();
                paintAll(g);
                break;

            case KeyEvent.VK_UP:
                OvalBig.moveUp();
                OvalSmall.moveUp();
                paintAll(g);
                break;

            case KeyEvent.VK_DOWN:
                OvalBig.moveDown();
                OvalSmall.moveDown();
                paintAll(g);
                break;
            case KeyEvent.VK_MINUS:
                OvalBig.reduce();
                OvalSmall.reduce();
                paintAll(g);
                break;
            case KeyEvent.VK_EQUALS:
                OvalBig.increase();
                OvalSmall.increase();
                paintAll(g);
                break;
        }
    }

    //эти 2 функции пустые потому что они нам не нужны но мы должны их написать
    //это требует интерфейс KeyListener
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}