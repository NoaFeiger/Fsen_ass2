package Implementation;

public class MusicSiteElement extends SiteElement {

    private String filename;

    public MusicSiteElement(Site site, String filename) {
        super(site);
        this.filename = filename;
    }

    public String getContent(boolean authorized) {
        if (authorized) return site.getContent(authorized) + "music of file " + filename + " is played; ";
        return site.getContent(authorized);
    }
}
