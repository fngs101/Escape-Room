import java.util.HashMap;
import java.util.Map;

public class Book extends Element
{
    private static final String PATH = "C:\\Users\\jszymczak\\Desktop\\pic\\";
    private Map<Integer, String> pagesImages = new HashMap();

    Book()
    {
        super("book");
        pagesImages.put(1, PATH + "1.jfif");
        pagesImages.put(2, PATH + "2.jfif");
        pagesImages.put(3, PATH + "3.jfif");
        pagesImages.put(4, PATH + "4.jfif");
        pagesImages.put(5, PATH + "5.jfif");
        pagesImages.put(6, PATH + "6.jfif");
        pagesImages.put(7, PATH + "7.jfif");
        pagesImages.put(8, PATH + "8.jfif");
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        //tutaj musi byc jakas interakcja z userem bo chciałam żeby pytał sie którą strone otworzyć
        //ostatecznie bierze ja player
        String message = "You took the book";
        elementsMediator.removeElementFromRoom(this);
        elementsMediator.addToPlayer(this);
        return message;
    }


    public String getImageFromPage(int page)
    {
        return pagesImages.get(page);
    }

}
