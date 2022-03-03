import java.util.List;

public class InputView extends View
{
    private InputInterpreter inputInterpreter;
    InputView(String welcomeMessage, InputInterpreter inputInterpreter)
    {
        super(welcomeMessage);
        this.inputInterpreter = inputInterpreter;
    }

    public InputView(String welcomeMessage, List<Element> elements, InputInterpreter inputInterpreter)
    {
        super(welcomeMessage, elements);
        this.inputInterpreter = inputInterpreter;
    }

    @Override
    public Element searchElement(String choice) throws GameException
    {
        try
        {
            return super.searchElement(choice);
        } catch (GameException e)
        {
            inputInterpreter.setInput(choice);
            return inputInterpreter;
        }

    }
}
