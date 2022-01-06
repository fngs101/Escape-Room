public class Key extends Element
{

    Key()
    {
        super("key");
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        String message = "You took the key";
        elementsMediator.removeElementFromRoom(this);
        elementsMediator.addToPlayer(this);
        return message;
    }
}
