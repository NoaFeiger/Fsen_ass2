package Implementation;

public class ColorDesign extends SiteDesign {

    private String color;

    public ColorDesign(Site site, String color) {
        super(site);
        this.color = color;
    }

    @Override
    public String getContent(boolean authorized) {

        if (authorized) {
            return site.getContent(authorized) + "color: " + color + "; ";
        }
        return site.getContent(authorized);


    }
}
