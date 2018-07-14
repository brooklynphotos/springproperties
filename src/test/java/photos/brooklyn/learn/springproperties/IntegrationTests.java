package photos.brooklyn.learn.springproperties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
//@SpringBootTest("impala.url=jdbc://impala-integration") works
//@TestPropertySource("impala.url=jdbc://impala-integration") doesn't work, expecting a path
@TestPropertySource("classpath:integration.properties")
public class IntegrationTests {
    @Value("${impala.url}")
    private String impalaUrl;
    @Value("${impala.user}")
    private String impalaUser;

    @Before
    public void setup(){
        System.out.println("Starting an integration test");
    }

	@Test
	public void contextLoads() {
        assertEquals("jdbc://impala.integration",impalaUrl);
        assertEquals("tester",impalaUser);
	}

}
