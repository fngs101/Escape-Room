
public class Portal extends Element
{
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
            elementsMediator.changeView(id);
            if(id.equals(ViewId.SAFE))
            {
                message = "You moved to " + id + ". Insert numeric code";

            } else
            {
                message = "You moved to " + id;
            }

        }
        else if(elementsMediator.hasPlayerGotElement(key))
        {
            message = "You moved to " + id;
            elementsMediator.changeView(id);


        } else if(key.getName().equals("code"))
        {
            message = "You see a padlock that can be opened with a code";
        }
        else
        {
            message = "You don't have the needed item";
        }
        return  message;
    }


}
