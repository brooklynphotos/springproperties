package photos.brooklyn.learn.springproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import photos.brooklyn.learn.springproperties.model.Person;
import photos.brooklyn.learn.springproperties.repo.DbRepo;
import photos.brooklyn.learn.springproperties.repo.WebRepo;
import photos.brooklyn.learn.springproperties.repo.WebRepoImpl;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * demonstrate the use of specific properties file
 */
@Configuration
@PropertySource("classpath:rest.properties")
public class RestProperties {
    @Inject
    private Environment env;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.timeout:23}")
    private int dbTimeout;

    @Bean
    public WebRepo webRepo(){
        return new WebRepoImpl(env.getProperty("web.url"));
    }

    @Bean
    public DbRepo dbRepo(){
        return () -> {
            System.out.println(String.format("Timeout: %d",dbTimeout));
            final Person p = new Person();
            p.setName(dbUrl);
            return Arrays.asList(p);
        };
    }
}
