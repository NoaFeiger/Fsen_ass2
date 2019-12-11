public class FontDesign extends SiteDesign {

    private String font;

    public FontDesign(Site site, String font) {
        super(site);
        this.font = font;
    }

    @Override
    public String getContent() {
        return site.getContent() + "; font: " + font + "; ";
    }
}
