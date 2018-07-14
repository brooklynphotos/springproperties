package photos.brooklyn.learn.springproperties.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import photos.brooklyn.learn.springproperties.model.Person;

import java.util.List;

@Repository
public class DbRepoImpalaImpl implements HadoopRepo {
    @Value("${impala.url}")
    private String url;
    @Value("${impala.user}")
    private String user;
    @Value("${impala.password}")
    private String password;

    @Override
    public List<Person> findPeople() {
        System.out.println(String.format("using %s", url));
        System.out.println(String.format("user %s", user));
        System.out.println(String.format("password %s", password));
        return null;
    }
}
