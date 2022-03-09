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
        View safe = createSafeView();
        views.put(ViewId.ROOM1, room1);
        views.put(ViewId.ROOM2, room2);
        views.put(ViewId.BOOK, book);
        views.put(ViewId.SAFE, safe);

    }


    private View createRoom()
    {
        List<Element> elements = new ArrayList<>();
        Key key = new Key();
        elements.add(key);
        elements.add(new Portal(key, ViewId.ROOM2));
        elements.add(new Window());
        View actualView = new View(elements);
        return actualView;
    }

    private View createRoom2()
    {
        List<Element> elements = new ArrayList<>();
        elements.add(new Painting());
        elements.add(new Portal("book", ViewId.BOOK, true));
        elements.add(new Portal("room1", ViewId.ROOM1, false));
        elements.add(new Portal("safe", ViewId.SAFE, true));
        View view = new View(elements);
        return view;
    }

    private View createBook()
    {
        List<Element> elements = new ArrayList<>();
        elements.add(new Portal("exit", ViewId.ROOM2, false));
        elements.add(new Page(1));
        elements.add(new Page(2));
        elements.add(new Page(3));
        elements.add(new Page(4));
        elements.add(new Page(5));
        View view = new View(elements);
        return view;
    }

    private View createSafeView()
    {
        List<Element> elements = new ArrayList<>();
        elements.add(new Portal("exit", ViewId.ROOM2, false));
        InputView view = new InputView(elements, new Safe("", "1881"));
        return view;

    }

    public View getViewById(ViewId id)
    {
        return views.get(id);
    }
}
