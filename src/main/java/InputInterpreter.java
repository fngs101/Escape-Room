public abstract class InputInterpreter extends Element
{
    private String input;
    private String correctInput;
    InputInterpreter(String input, String correctInput)
    {
        super("", false);
        this.input = input;
        this.correctInput = correctInput;
    }


    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        if(input.equals(correctInput))
        {
            return performSuccessAction(elementsMediator);
        } else
        {
            return performFailureAction(elementsMediator);
        }

    }

    abstract public String performSuccessAction(ElementsMediator elementsMediator);

    abstract public String performFailureAction(ElementsMediator elementsMediator);

    public void setInput(String input)
    {
        this.input = input;
    }
}
