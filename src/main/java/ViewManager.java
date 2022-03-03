import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//tak jak tu są rooms i book tak zrobic view keycode i w nim wyswietlic elementy tj cyferki?
public class ViewManager
{
    private Map<ViewId, View> views = new HashMap<>();
    ViewManager()
    {
        View room1 = createRoom();
        View room2 = createRoom2();
        View book = createBook();
        View outside = createExit();
        views.put(ViewId.room1, room1);
        views.put(ViewId.room2, room2);
        views.put(ViewId.book, book);
        views.put(ViewId.outside, outside);

    }


    private View createRoom()
    {
        List<Element> elements = new ArrayList<>();
        Key key = new Key();
        elements.add(key);
        elements.add(new Portal(key, ViewId.room2));
        elements.add(new Window());
        View actualView = new View("You entered first room", elements);
        return actualView;
    }
    private View createRoom2()
    {
        List<Element> elements = new ArrayList<>();
        Key key = new Key("1881");
        elements.add(new Painting());
        elements.add(new Portal("book", ViewId.book, true));
        elements.add(new Portal("room1", ViewId.room1, false));
        elements.add(new Portal(key, ViewId.outside));
        View view = new View("You are in the second room", elements);
        return view;
    }
    private View createBook()
    {
        List<Element> elements = new ArrayList<>();
        elements.add(new Portal("exit", ViewId.room2, false));
        elements.add(new Page(1));
        elements.add(new Page(2));
        elements.add(new Page(3));
        elements.add(new Page(4));
        elements.add(new Page(5));
        View view = new View("You open the book", elements);
        return view;
    }

    private View createExit()
    {
        View view = new View("You have escaped the room, congrats");
        return view;
    }

    public View getViewById(ViewId id)
    {
       return views.get(id);
    }
}
