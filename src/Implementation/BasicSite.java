package Implementation;

public class BasicSite implements Site {

    @Override
    public String getContent(boolean authorized) {

        if (authorized) return "Welcome to the website! (fully authorized)\n";
        return "Welcome to the website! (some content may be blocked due to lack of authorization)\n";
    }
}
