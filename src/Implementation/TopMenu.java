package Implementation;

public class TopMenu extends SiteMenu {

    public TopMenu(Site site) {
        super(site);
    }

    @Override
    public String getContent(boolean authorized) {
        if (authorized) return site.getContent(authorized) + "Menu is on the top side; ";
        return site.getContent(authorized);
    }
}