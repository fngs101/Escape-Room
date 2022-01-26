public interface ElementsMediator
{
    void removeElementFromRoom(Element element);

    void addToPlayer(Element element);

    boolean hasPlayerGotElement(Element element);

    void finishRoom();

    void finishGame();

    void removeElementFromPlayer(Element element);

}
