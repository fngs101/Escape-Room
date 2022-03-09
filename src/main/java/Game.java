import java.util.List;


public class Game implements GameEngine, ElementsMediator
{
    private View actualView;
    private Player player;
    private boolean isFinished;
    private ViewManager viewManager;

    Game()
    {
        viewManager = new ViewManager();
        actualView = viewManager.getViewById(ViewId.ROOM1);
        player = new Player();
        isFinished = false;

    }

    public List<Element> getElementList()
    {
        return actualView.getElements();
    }

    public String executeChoice(String choice) throws GameException
    {
        Element foundElement = actualView.searchElement(choice);
        String message = foundElement.performAction(this);
        return message;
    }

    @Override
    public boolean isGameFinished()
    {
        return isFinished;
    }

    public void removeElementFromRoom(Element element)
    {
        actualView.removeElement(element);
    }

    public void addToPlayer(Element element)
    {
        player.addToList(element);
    }

    @Override
    public boolean hasPlayerGotElement(Element element)
    {
        return player.hasElement(element);

    }

    @Override
    public void changeView(ViewId id)
    {
        actualView = viewManager.getViewById(id);
    }

    @Override
    public void finishGame()
    {
        isFinished = true;
    }

    @Override
    public void removeElementFromPlayer(Element element)
    {
        player.removeFromList(element);
    }

}

