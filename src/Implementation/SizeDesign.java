package Implementation;

public class SizeDesign extends Tool {

    private int size;

    public SizeDesign(Site site, int size) {
        super(site);
        this.size = size;
    }

    @Override
    public String getContent(boolean authorized) {
        if (authorized) return site.getContent(authorized) + "; font size: " + size + "; ";
        return site.getContent(authorized);
    }
}
