package photos.brooklyn.learn.springproperties.repo;

import java.util.Map;

public interface WebRepo {
    /**
     * gets the generic data
     * @return
     */
    Map<String, ?> getData();
}
