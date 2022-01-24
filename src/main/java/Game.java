import java.util.List;

//zasady gry bez sout bez scanner
public class Game implements GameEngine, ElementsMediator
{
    private Room actualRoom;
    private Player player;
    private boolean isFinished;

    Game()
    {
        actualRoom = new Room();
        Key key = new Key();
        actualRoom.addElement(key);
        actualRoom.addElement(new Door(key));
        actualRoom.addElement(new Window());
        actualRoom.ad
        player = new Player();
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
        //tutaj pewność że został znaleziony elemeent, inaczej by zostało przerwane
        return message;
    }

    @Override
    public boolean isGameFinished()
    {
        return isFinished;
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
    public void finishGame()
    {
        isFinished = true;
    }

    @Override
    public void setActualRoom(Room actualRoom)
    {
        this.actualRoom = actualRoom;
    }
}
