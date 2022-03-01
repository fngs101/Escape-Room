public class Page extends Element
{
    private int pageNumber;

    Page(int pageNr)
    {
        super("Page " + pageNr, true);
        this.pageNumber = pageNr;
    }

    @Override
    public String performAction(ElementsMediator elementsMediator)
    {
        MyFrame myFrame = new MyFrame(pageNumber);
        myFrame.showMyFrame();
        return "Showing page";
    }
}
