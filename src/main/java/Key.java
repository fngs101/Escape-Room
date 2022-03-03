public class Key extends Element
{
    private String code;
    Key()
    {
        super("key", true);
    }

    Key(String code)
    {
        super("code", true);
        this.code = code;
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
