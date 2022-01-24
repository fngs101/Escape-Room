
public class Door extends Element
{
    private Key key;
    Door(Key key)
    {
        super("door");
        this.key = key;
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        String message = "";
        if(elementsMediator.hasPlayerGotElement(key))
        {
            message = "You opened the door and you find yourself in another room";
            elementsMediator.finishRoom();
//            elementsMediator.finishGame();
//            elementsMediator.removeElementFromRoom();
        } else
        {
            message = "You don't have the key";
        }
        return  message;
    }


}
