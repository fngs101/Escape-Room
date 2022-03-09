import java.util.ArrayList;
import java.util.List;

public class View
{
    private List<Element> elements;
    View()
    {
        elements = new ArrayList<>();
    }

    public View(List<Element> elements)
    {
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
        } throw new GameException("Element not found");
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
