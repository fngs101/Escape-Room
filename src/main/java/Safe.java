public class Safe extends InputInterpreter
{
    Safe(String input, String correctInput)
    {
        super(input, correctInput);
    }

    @Override
    public String performSuccessAction(ElementsMediator elementsMediator)
    {

        elementsMediator.finishGame();
        return "You have managed to escape.";
    }

    @Override
    public String performFailureAction(ElementsMediator elementsMediator)
    {
        return "Wrong input";
    }
}
