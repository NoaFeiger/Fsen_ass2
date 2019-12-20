package Implementation;

public abstract class Tool implements Site {

    protected Site site;

    public Tool(Site site){
        this.site = site;
    }

    public String getContent(boolean authorized){
        if (authorized) return site.getContent(authorized);
        return "";
    }

}
