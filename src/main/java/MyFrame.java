import java.awt.*;
import javax.swing.JFrame;

public class MyFrame extends JFrame
{

    private static final String PATH = "C:\\Users\\jszymczak\\Desktop\\pic\\";
    private Image image;

    MyFrame(int imgNumber)
    {
        add(new MyCanvas());
        setSize(700,700);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        String fullPath = PATH + imgNumber + ".jfif";
        image = toolkit.getImage(fullPath);
    }

    public void showMyFrame()
    {
        setVisible(true);
    }


    class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g)
        {
            g.drawImage(image, 0,0,this);
        }
    }

}
