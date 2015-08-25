package cz.jalasoft.watchmytrain.cloud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/25/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cz.jalasoft.watchmytrain.cloud"})
public class AppConfig extends WebMvcConfigurerAdapter {

    @PostConstruct
    public void init() {
        System.out.println("OK");
    }

}
