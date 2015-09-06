package cz.jalasoft.trainwatch.cloud;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/25/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cz.jalasoft.trainwatch"})
public class AppConfig extends WebMvcConfigurerAdapter {

}
