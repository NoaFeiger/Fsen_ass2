package Implementation;

public class TopMenu extends SiteMenu {

    public TopMenu(Site site) {
        super(site);
    }

    @Override
    public String getContent() {
        return site.getContent() + "Menu is on the top side; ";
    }
}