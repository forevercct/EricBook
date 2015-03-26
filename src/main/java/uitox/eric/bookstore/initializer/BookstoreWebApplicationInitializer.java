package uitox.eric.bookstore.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//public class BookstoreWebApplicationInitializer implements
//		WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext servletContext)
//			throws ServletException {
//
//		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//		appContext
//				.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
//
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
//				"dispacther", new DispatcherServlet(appContext));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//		
//		System.out.println("Reading WebApplicationInitializer");
//	}
//}

public class BookstoreWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        registerDispatcherServlet(servletContext);
    }

    private void registerDispatcherServlet(final ServletContext servletContext) {
        WebApplicationContext dispatcherContext = createContext(uitox.eric.bookstore.config.WebMvcContextConfiguration.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.htm");
        
        System.out.println("Reading!!");
    }

    /**
     * Helper method to create {@link AnnotationConfigWebApplicationContext} instances. 
     * @param annotatedClasses
     * @return
     */
    private WebApplicationContext createContext(final Class<?>... annotatedClasses) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(annotatedClasses);
        return context;
    }
}
