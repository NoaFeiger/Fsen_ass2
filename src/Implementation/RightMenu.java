package Implementation;

public class RightMenu extends SiteMenu {

    public RightMenu(Site site) {
        super(site);
    }

    @Override
    public String getContent(boolean authorized) {
        if (authorized) return site.getContent(authorized) + "; Menu is on the right side; ";
        return site.getContent(authorized);
    }
}
