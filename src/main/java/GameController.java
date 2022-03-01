import java.util.List;
import java.util.Scanner;

public class GameController implements Colors
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
                "To get out you will need to find out his/her year of birth.\nText written in " +
                ANSI_RED + "red " + ANSI_RESET + "is used to mark moving from one place to another.\nColor " + ANSI_PURPLE +
                "purple " + ANSI_RESET + "is used to mark objects that you can interact with.");
    }

    public void showElements()
    {
        List<Element> list = game.getElementList();
        System.out.println("Choose one of these objects: ");
        for(Element element : list)
        {
           if(element.isInteractable())
            {
                System.out.println(ANSI_PURPLE + element.getName() + ANSI_RESET);
            } else
            {
                System.out.println(ANSI_RED + element.getName() + ANSI_RESET);
            }

        }

    }

    public String choose()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void useElement(String choice)
    {
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
