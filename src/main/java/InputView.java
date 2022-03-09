import java.util.List;

public class InputView extends View
{
    private InputInterpreter inputInterpreter;
    InputView(InputInterpreter inputInterpreter)
    {
        this.inputInterpreter = inputInterpreter;
    }

    public InputView(List<Element> elements, InputInterpreter inputInterpreter)
    {
        super(elements);
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
