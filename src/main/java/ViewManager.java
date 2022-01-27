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
        View actualView = new View("You entered first room");
        Key key = new Key();
        actualView.addElement(key);
        actualView.addElement(new Portal(key, ViewId.ROOM2));
        actualView.addElement(new Window());
        return actualView;
    }
    private View createRoom2()
    {
        List<Element> elements = new ArrayList<>();
        elements.add(new Code());
        elements.add(new Painting());
        elements.add(new Portal("Book", ViewId.BOOK));
        View view = new View(elements);
        return view;
    }
    private View createBook()
    {
        return new View(new ArrayList<>());
    }

    public View getViewById(ViewId id)
    {
       return views.get(id);
    }
}
