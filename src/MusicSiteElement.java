public class MusicSiteElement extends SiteElement {

    private String filename;

    public MusicSiteElement(Site site, String filename) {
        super(site);
        this.filename = filename;
    }

    public String getContent() {
        return site.getContent() + "music of file " + filename + " is played; ";
    }
}
