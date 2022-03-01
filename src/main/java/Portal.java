
public class Portal extends Element
{
    //portal to jest jednoczesnie książka i drzwi, któe do czegos prowadzą tzn do View (pokój i ksiazka)
    private Key key;
    private ViewId id;

    Portal(Key key, ViewId id)
    {
        super("door", false);
        this.key = key;
        this.id = id;
    }

    Portal(String name, ViewId id, boolean isInteractable)
    {
        super(name, isInteractable);
        this.id = id;
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        String message = "";
        if(key == null)
        {
            message = "You moved to " + id;
            elementsMediator.changeView(id);
        }
        else if(elementsMediator.hasPlayerGotElement(key))
        {
            message = "You have the the needed item: " + key.getName() + ". You moved to " + id;
            elementsMediator.changeView(id);

        }
        else
        {
            message = "You don't have the needed item";
        }
        return  message;
    }


}
