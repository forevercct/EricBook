package uitox.eric.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uitox.eric.bookstore.controller.HomeController;
import uitox.eric.bookstore.controller.IndexController;

/**
 * Spring MVC configuration
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 * 
 */
@Configuration
public class WebMvcContextConfiguration {

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}

	@Bean
	public IndexController indexController() {
		return new IndexController();
	}

	// public HandlerMapping controllerBeanNameHandlerMapping() {
	// ControllerBeanNameHandlerMapping mapping = new
	// ControllerBeanNameHandlerMapping();
	// mapping.setUrlSuffix(".htm");
	// return mapping;
	// }
	//
	// public HandlerMapping simpleUrlHandlerMapping() {
	// SimpleUrlHandlerMapping urlMapping = new SimpleUrlHandlerMapping();
	// Properties mappings = new Properties();
	// mappings.put("/index.htm", "indexController");
	// urlMapping.setMappings(mappings);
	// return urlMapping;
	// }

}
