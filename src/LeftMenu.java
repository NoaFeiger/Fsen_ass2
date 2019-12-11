public class LeftMenu extends SiteMenu {

    public LeftMenu(Site site) {
        super(site);
    }

    @Override
    public String getContent() {
        return site.getContent() + "; Menu is on the left side; ";
    }
}
