import java.util.List;
import java.util.Scanner;

public class GameController
{
    private GameEngine game;
    GameController()
    {
        game = new Game();
    }

    public void play()
    {

        //dodac dwa nowe przedmioty z nowym dzialaniem i dodatkowy pokój
        do
        {
            showElements();
            String choice = choose();
            useElement(choice);
            game.setActualRoom(new Room());

        }
        while (!game.isGameFinished());

    }

    public void showElements()
    {
        List<Element> list = game.getElementList();
        System.out.println("Choose one of these objects: " + list);


    }

    public String choose()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void useElement(String choice)
    {
        System.out.println("You chose " + choice);
        try
        {
            String message = game.useItem(choice);
            System.out.println("Found object");
            System.out.println(message);
        } catch (GameException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
