package Implementation;

public class FontDesign extends SiteDesign {

    private String font;

    public FontDesign(Site site, String font) {
        super(site);
        this.font = font;
    }

    @Override
    public String getContent(boolean authorized) {

        if (authorized) {
            return site.getContent(authorized) + "; font: " + font + "; ";
        }
        else return site.getContent(authorized);
    }
}
