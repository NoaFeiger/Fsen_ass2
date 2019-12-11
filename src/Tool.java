public abstract class Tool implements Site {

    protected Site site;

    public Tool(Site site){
        this.site = site;
    }

    public String getContent(){
        return site.getContent();
    }

}
