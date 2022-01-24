
public class Door extends Element
{
    private Key key;
    private Code code;
    Door(Key key)
    {
        super("door");
        this.key = key;
        code = new Code();
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
