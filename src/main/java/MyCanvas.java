import java.awt.*;
import java.util.Map;
import javax.swing.JFrame;

public class MyCanvas extends Canvas
{
    private Book book;

    MyCanvas()
    {
        book = new Book();
    }
    public void paint(Graphics g)
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = getImage(toolkit);
        g.drawImage(image, 0,0,this);

    }

    public Image getImage(Toolkit toolkit)
    {
        return toolkit.getImage(book.getImageFromPage(7));
    }

    public void showImage()
    {
        MyCanvas myCanvas = new MyCanvas();
        JFrame frame = new JFrame();
        frame.add(myCanvas);
        frame.setSize(700,700);
        frame.setVisible(true);
    }

}
