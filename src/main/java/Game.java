import java.util.List;

//zasady gry bez sout bez scanner
public class Game implements GameEngine, ElementsMediator
{
    private Room firstRoom;
    private Room secondRoom;
    private Player player;
    private boolean isFinished;

    Game()
    {
        firstRoom = new Room();
        secondRoom = new Room();
        Key firstRoomKey = new Key();
        firstRoom.addElement(firstRoomKey);
        firstRoom.addElement(new Door(firstRoomKey));
        firstRoom.addElement(new Window());
        player = new Player();
        isFinished = false;
    }

    public List<Element> getElementList()
    {
        return firstRoom.getElements();
    }

    public String useItem(String choice) throws GameException
    {
        Element foundElement = firstRoom.searchElement(choice);
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
        firstRoom.removeElement(element);
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

}
