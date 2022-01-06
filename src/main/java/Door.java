
public class Door extends Element
{
    private Key key;
    Door(Key key)
    {
        super("door");
        this.key = key;
    }

//    @Override
//    public String performAction(ElementsMediator game)
//    {
//
//        return null;
//    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        String message = "";
        if(elementsMediator.hasPlayerGotElement(key))
        {
            message = "You opened the door";
            elementsMediator.finishGame();
        } else
        {
            message = "You don't have the key";
        }
        return  message;
    }


}
