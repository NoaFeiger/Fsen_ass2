package Implementation;

public class ColorDesign extends SiteDesign {

    private String color;

    public ColorDesign(Site site, String color) {
        super(site);
        this.color = color;
    }

    @Override
    public String getContent() {
        return site.getContent() + "color: " + color + "; ";
    }
}
