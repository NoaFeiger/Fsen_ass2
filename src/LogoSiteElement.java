public class LogoSiteElement extends SiteDesign {

    private String filename;

    public LogoSiteElement(Site site, String filename) {
        super(site);
        this.filename = filename;
    }

    public String getContent() {
        return site.getContent() + "logo of file " + filename + " is displayed; ";
    }
}
