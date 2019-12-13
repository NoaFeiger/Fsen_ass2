package Implementation;

public class BackgroundDesign extends SiteDesign {

    private String filename;

    public BackgroundDesign(Site site, String filename) {
        super(site);
        this.filename = filename;
    }

    @Override
    public String getContent() {
        return site.getContent() + "; background file: " + filename + "; ";
    }
}
