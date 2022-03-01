public class Painting extends Element
{
    private boolean isTakenDown;
    Painting()
    {
        super("painting", true);
        isTakenDown = false;
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        String message = "";
        isTakenDown = !isTakenDown;
        if(isTakenDown)
        {
            message = "You took down the painting. You find a note with number 5";
        } else
        {
            message = "You hang back the painting";
        }
        return message;
    }
}
