public abstract class Element implements Colors
{
    private String name;
    private boolean isInteractable;

    Element(String name, boolean isInteractable)
    {
        this.name = name;
        this.isInteractable = isInteractable;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public String getName()
    {
        return name;
    }

    public boolean isInteractable()
    {
        return isInteractable;
    }

    public abstract String performAction(ElementsMediator elementsMediator);

}
