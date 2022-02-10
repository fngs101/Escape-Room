import java.util.ArrayList;
import java.util.List;

public class View
{
    private List<Element> elements;
    private String welcomeMessage;
    View(String welcomeMessage)
    {
        elements = new ArrayList<>();
        this.welcomeMessage = welcomeMessage;
    }

    public View(String welcomeMessage, List<Element> elements)
    {
        this.welcomeMessage = welcomeMessage;
        this.elements = elements;
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

    public void clearElementsList()
    {
        elements.clear();
    }
}
