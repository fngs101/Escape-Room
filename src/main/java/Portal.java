
public class Portal extends Element
{
    //portal to jest jednoczesnie książka i drzwi, któe do czegos prowadzą tzn do View (pokój i ksiazka)
    private Key key;
    private Code code; //do ujednolicenia z kluczem
    private ViewId id;

    Portal(Key key, ViewId id)
    {
        super("door");
        this.key = key;
        code = new Code();
        this.id = id;
    }

    Portal(String name, ViewId id)
    {
        super(name);
        this.id = id;
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        String message = "";
        if(elementsMediator.hasPlayerGotElement(key))
        {
            message = "You opened the door and you find yourself in another room";
            elementsMediator.finishRoom();

        } else if(elementsMediator.hasPlayerGotElement(code))
        {
            elementsMediator.finishGame();
        }
        else
        {
            message = "You don't have the key or code";
        }
        return  message;
    }


}
