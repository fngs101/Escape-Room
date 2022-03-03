import java.util.List;

//zasady gry bez sout bez scanner
public class Game implements GameEngine, ElementsMediator
{
    private View actualView;
    private Player player;
    private boolean isFinished;
    private ViewManager viewManager;

//klasa na budowanie przestrzeni pomocnik do tej klasy ViewFactor z metodami z których kazda daje jeden z widoków
    Game()
    {
        viewManager = new ViewManager();
        actualView = viewManager.getViewById(ViewId.room1);
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
        System.out.println(actualView.getWelcomeMessage()); //todo wymyślić jak wywalić to do controllera
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
//widok podrzuca komunikat i ew. opcje
//uzytkownik wprowadza input
//input jest interpretowany w sposob zalezny od rodzaju widoku

//rodzaje widokow:
//wybor opcji
//wprowadzanie kodu

//ew. sekwencje


