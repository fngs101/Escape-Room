import java.util.List;

public interface GameEngine
{
    List<Element> getElementList();

    String useItem(String choice) throws GameException;

    boolean isGameFinished();

    boolean isRoomFinished();

    void removeAllElements();

    void setActualRoom(Room actualRoom);
}