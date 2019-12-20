package Implementation;

public class BackgroundDesign extends SiteDesign {

    private String filename;

    public BackgroundDesign(Site site, String filename) {
        super(site);
        this.filename = filename;
    }

    @Override
    public String getContent(boolean authorized) {

        if (authorized) {
            return site.getContent(authorized) + "; background file: " + filename + "; ";
        }
        return site.getContent(authorized);


    }
}
