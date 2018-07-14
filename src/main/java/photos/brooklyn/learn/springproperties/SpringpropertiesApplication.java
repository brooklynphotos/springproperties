package photos.brooklyn.learn.springproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import photos.brooklyn.learn.springproperties.repo.DbRepo;
import photos.brooklyn.learn.springproperties.repo.HadoopRepo;
import photos.brooklyn.learn.springproperties.repo.WebRepo;

import javax.inject.Inject;
import java.util.Arrays;

@SpringBootApplication
public class SpringpropertiesApplication {
    @Inject
    private WebRepo webRepo;
    @Inject
    private DbRepo dbRepo;
    @Inject
    private HadoopRepo hadoopRepo;
    @Value("${maxMemory}")
    private int maxMemory;
    @Value("${maxThreads}")
    private int maxThreads;

	public static void main(String[] args) {
		SpringApplication.run(SpringpropertiesApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's start!");
            System.out.println(webRepo.getData());
            System.out.println(dbRepo.findPeople().size());
            System.out.println(hadoopRepo.findPeople());

            System.out.println(String.format("Max memory: %d",maxMemory));
            System.out.println(String.format("Max threads: %d",maxThreads));
        };
    }
}
