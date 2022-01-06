import java.util.ArrayList;
import java.util.List;

public class Player
{
    private List<Element> elements;

    Player()
    {
        elements = new ArrayList<>();
    }

    public void addToList(Element element)
    {
        elements.add(element);
    }

    public boolean hasElement(Element element)
    {
        return elements.contains(element);
    }
}
