package Implementation;

public class LinkSiteElement extends SiteElement {

    private String url;

    public LinkSiteElement(Site site, String url) {
        super(site);
        this.url = url;
    }

    public String getContent(boolean authorized) {
        if (authorized) return site.getContent(authorized) + "link to site " + url + " is displayed; ";
        return site.getContent(authorized);
    }
}
