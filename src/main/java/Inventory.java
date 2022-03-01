import java.util.ArrayList;
import java.util.List;

public class Inventory extends Element
{
    //nie wiem czy to ma sens, osobna klasa na przedmioty które posiada player i potem metody żeby robic z tymi rzeczami cos,
    //potrzebne pod książke
    private List<Element> elements;
    Inventory()
    {
        super("inventory", true);
        elements = new ArrayList<>();
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        return null;
    }
}
