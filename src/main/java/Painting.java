public class Painting extends Element
{
    private boolean isTakenDown;
    Painting()
    {
        super("painting");
        isTakenDown = false;
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        String message = "";
        isTakenDown = !isTakenDown;
        if(isTakenDown)
        {
            message = "You took down the painting. You find a note with number 8";
        } else
        {
            message = "You hang back the painting";
        }
        return message;
    }
}
