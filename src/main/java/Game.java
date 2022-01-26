import java.util.List;

//zasady gry bez sout bez scanner
public class Game implements GameEngine, ElementsMediator
{
    private Room actualRoom;
    private Player player;
    private boolean isRoomFinished;
    private boolean isFinished;
    private Key key;

    Game()
    {
        actualRoom = new Room();
        key = new Key();
        actualRoom.addElement(key);
        actualRoom.addElement(new Door(key));
        actualRoom.addElement(new Window());
        player = new Player();
        isRoomFinished = false;
        isFinished = false;
    }


    public List<Element> getElementList()
    {
        return actualRoom.getElements();
    }

    public String useItem(String choice) throws GameException
    {
        Element foundElement = actualRoom.searchElement(choice);
        String message = foundElement.performAction(this);
        return message;
    }

    @Override
    public boolean isGameFinished()
    {
        return isFinished;
    }

    @Override
    public boolean isRoomFinished()
    {
        return isRoomFinished;
    }

    @Override
    public void removeAllElements()
    {
        actualRoom.clearElementsList();
    }

    public void removeElementFromRoom(Element element)
    {
        actualRoom.removeElement(element);
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
        isRoomFinished = true;
        removeAllElements();
        setActualRoom(actualRoom);
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

    @Override
    public void setActualRoom(Room actualRoom)
    {
        this.actualRoom = actualRoom;
        startNewRoom();
    }
        //nie mialam innego pomysłu na dodanie nowych przedmiotów, tzn nie mogłam znaleźć innego miejsca
    public void startNewRoom()
    {
        List<Element> elements = getElementList();
        elements.add(new Book());
        elements.add(new Code());
        elements.add(new Painting());
        elements.add(new Door());

    }
}
