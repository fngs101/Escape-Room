import java.util.ArrayList;
import java.util.List;

public class Room
{
    private List<Element> elements;
    Room()
    {
        elements = new ArrayList<>();
    }

    public List<Element> getElements()
    {
        return elements;
    }

    public void addElement(Element element)
    {
        elements.add(element);
    }

    public Element searchElement(String choice) throws GameException
    {

        for(Element element : elements)
        {
            if(element.getName().equals(choice))
            {
                return element;
            }
        } throw new GameException("Game not found");

    }

    public void removeElement(Element element)
    {
        elements.remove(element);
    }
}
