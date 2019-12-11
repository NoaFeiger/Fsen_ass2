public class LinkSiteElement extends SiteElement {

    private String url;

    public LinkSiteElement(Site site, String url) {
        super(site);
        this.url = url;
    }

    public String getContent() {
        return site.getContent() + "link to site " + url + " is displayed; ";
    }
}
