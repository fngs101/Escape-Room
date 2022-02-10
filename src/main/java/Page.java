public class Page extends Element
{
    private int pageNumber;

    Page(int pageNr)
    {
        super("Page " + pageNr);
        this.pageNumber = pageNr;
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        MyFrame myFrame = new MyFrame(1);
        myFrame.showMyFrame();
        return "Showing page";
    }
}
