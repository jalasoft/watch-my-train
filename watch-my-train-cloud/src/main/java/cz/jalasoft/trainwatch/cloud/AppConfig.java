package cz.jalasoft.trainwatch.cloud;

import cz.jalasoft.trainwatch.domain.model.train.TrainNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/25/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cz.jalasoft.trainwatch"})
public class AppConfig extends WebMvcConfigurerAdapter {

    @PostConstruct
    public void init() {

    }

    @Bean(name = "fakeTrains")
    public List<TrainNumber> fakeTrains() {
        return Arrays.asList(
                new TrainNumber("R683", "Hutnik"),
                new TrainNumber("Os1110"),
                new TrainNumber("R856", "Jaroslav Hasek")
        );
    }
}
