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
        enterEscapeRoom();

        do
        {

            showElements();
            String choice = choose();
            useElement(choice);

        }
        while (!game.isGameFinished());

    }

    public void enterEscapeRoom()
    {
        System.out.println("Throughout your adventure here you will find many clues about a famous person.\n" +
                "To get out you will need to find out his/her name and birthday.");
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
            System.out.println(message);

        } catch (GameException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
