public abstract class Element
{
    private String name;

    Element(String name)
    {
        this.name = name;
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

    public abstract String performAction(ElementsMediator elementsMediator);

}
