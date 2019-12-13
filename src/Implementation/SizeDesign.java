package Implementation;

public class SizeDesign extends Tool {

    private int size;

    public SizeDesign(Site site, int size) {
        super(site);
        this.size = size;
    }

    @Override
    public String getContent() {
        return site.getContent() + "; font size: " + size + "; ";
    }
}
