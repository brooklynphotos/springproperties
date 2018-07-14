package photos.brooklyn.learn.springproperties.repo;

import java.util.Map;

public class WebRepoImpl implements WebRepo {
    private final String url;

    public WebRepoImpl(final String url){
        this.url = url;
    }
    @Override
    public Map<String, ?> getData() {
        return null;
    }
}
