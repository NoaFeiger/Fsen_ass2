package Implementation;

public class LogoSiteElement extends SiteDesign {

    private String filename;

    public LogoSiteElement(Site site, String filename) {
        super(site);
        this.filename = filename;
    }

    public String getContent(boolean authorized) {
        if (authorized) return site.getContent(authorized) + "logo of file " + filename + " is displayed; ";
        else return site.getContent(authorized);
    }
}
