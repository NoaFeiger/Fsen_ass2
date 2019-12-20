package Implementation;

public class LeftMenu extends SiteMenu {

    public LeftMenu(Site site) {
        super(site);
    }

    @Override
    public String getContent(boolean authorized) {
        if (authorized) return site.getContent(authorized) + "; Menu is on the left side; ";
        return site.getContent(authorized);
    }
}
