import java.util.List;

public interface GameEngine
{
    List<Element> getElementList();

    String executeChoice(String choice) throws GameException;

    boolean isGameFinished();
}
