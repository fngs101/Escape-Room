public class Window extends Element
{
    private boolean isOpen;
    Window()
    {
        super("window", true);
        isOpen = false;
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        isOpen = !isOpen;

        return isOpen? "You opened the window": "You closed the window";
    }

}
