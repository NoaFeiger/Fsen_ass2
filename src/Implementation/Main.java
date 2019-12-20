package Implementation;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        siteQuestion4();

    }

    private static void siteQuestion4(){
        // question 4

        Map<Integer, Site> sites = new HashMap<>();

        sites.put(1, new ColorDesign(new LogoSiteElement(new TopMenu(new BasicSite()),"logo.png"),"blue"));
        sites.put(2, new FontDesign(new LinkSiteElement(new LeftMenu(new BasicSite()),"google.com"),"arial"));
        sites.put(3, new SizeDesign(new MusicSiteElement(new RightMenu(new BasicSite()), "sadness.mp3"), 25));

        // project code
        int projCode = 1;

        // is the student authorized
        boolean authorized = true;

        System.out.println(sites.get(projCode).getContent(authorized));
    }
}
