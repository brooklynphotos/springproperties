package photos.brooklyn.learn.springproperties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import photos.brooklyn.learn.springproperties.config.EmailConfig;
import photos.brooklyn.learn.springproperties.config.KerberosConfig;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest // this doesn't load from the main/resources/application at all, only starting with /test/resources
public class SpringpropertiesApplicationTests {
    @Value("${impala.url}")
    private String impalaUrl;
    @Value("${impala.user}")
    private String impalaUser;
    @Inject
    private KerberosConfig kerberosConfig;
    @Inject
    private EmailConfig emailConfig;
    @Inject
    private Environment env;

    @Before
    public void setup(){
        System.out.println("Starting a test");
    }

	@Test
	public void contextLoads() {
        if(env.acceptsProfiles("dev")){ // tests yml file
            assertEquals("jdbc://impala.dev", impalaUrl);
            assertEquals("dev-tester", impalaUser);
        }else {
            assertEquals("jdbc://impala.test", impalaUrl);
            assertEquals("tester", impalaUser);
        }
        assertEquals("test-user", kerberosConfig.getPrincipal());
        assertEquals("mail.google.com", emailConfig.getServer().getUrl());
        assertEquals("The", emailConfig.getUser().getFirstName());
    }

}
