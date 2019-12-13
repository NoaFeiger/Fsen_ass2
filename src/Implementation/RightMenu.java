package Implementation;

public class RightMenu extends SiteMenu {

    public RightMenu(Site site) {
        super(site);
    }

    @Override
    public String getContent() {
        return site.getContent() + "; Menu is on the right side; ";
    }
}
