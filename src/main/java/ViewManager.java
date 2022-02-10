import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewManager
{
    private Map<ViewId, View> views = new HashMap<>();
    ViewManager()
    {
        View room1 = createRoom();
        View room2 = createRoom2();
        View book = createBook();
        views.put(ViewId.ROOM, room1);
        views.put(ViewId.ROOM2, room2);
        views.put(ViewId.BOOK, book);

    }

    private View createRoom()
    {
        List<Element> elements = new ArrayList<>();
        Key key = new Key();
        elements.add(key);
        elements.add(new Portal(key, ViewId.ROOM2));
        elements.add(new Window());
        View actualView = new View("You entered first room", elements);
        return actualView;
    }
    private View createRoom2()
    {
        List<Element> elements = new ArrayList<>();
        elements.add(new Code());
        elements.add(new Painting());
        elements.add(new Portal("Book", ViewId.BOOK));
        elements.add(new Portal("Room", ViewId.ROOM));
        View view = new View("You are in the second room", elements);
        return view;
    }
    private View createBook()
    {
        List<Element> elements = new ArrayList<>();
        elements.add(new Portal("exit", ViewId.ROOM2));
        elements.add(new Page(1));
        View view = new View("You open the book", elements);
        return view;
    }

    public View getViewById(ViewId id)
    {
       return views.get(id);
    }
}
