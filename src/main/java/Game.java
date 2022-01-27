import java.util.ArrayList;
import java.util.List;

//zasady gry bez sout bez scanner
public class Game implements GameEngine, ElementsMediator
{
    private View actualView;
    private Player player;
    private boolean isFinished;
    private Key key;
    private ViewManager viewManager;
//klasa na budowanie przestrzeni pomocnik do tej klasy ViewFactor z metodami z których kazda daje jeden z widoków
    Game()
    {
        viewManager = new ViewManager();
        actualView = viewManager.getViewById(ViewId.ROOM);
        player = new Player();
        isFinished = false;
    }


    public List<Element> getElementList()
    {
        return actualView.getElements();
    }

    public String useItem(String choice) throws GameException
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
    public void finishRoom()
    {
        List<Element> elements = addElementsOf2thRoom();
        actualView = new View(elements);
        removeElementFromPlayer(key);
    }

    @Override
    public void finishGame()
    {
        isFinished = true;
    }

    @Override
    public void removeElementFromPlayer(Element element)
    {
        player.removeFromList(key);
    }

    //nie mialam innego pomysłu na dodanie nowych przedmiotów, tzn nie mogłam znaleźć innego miejsca
    public List<Element> addElementsOf2thRoom()
    {
        List<Element> elements = new ArrayList<>();
//        elements.add(new Book());
        elements.add(new Code());
        elements.add(new Painting());
        elements.add(new Portal("Book", ViewId.BOOK));
        return elements;
    }
}
