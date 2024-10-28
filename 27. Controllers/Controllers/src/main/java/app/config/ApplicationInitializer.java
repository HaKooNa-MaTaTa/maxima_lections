package app.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {

    //Веб приложение - это набор сервлетов и прочего содержимого
    //ServletContext - определяет набор методов, который будут использоваться для связи с
    //контейнером сервлетов (Tomcat)
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //Класс для настройки web приложения
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        //Передали настройку нашего приложения
        webApplicationContext.register(ApplicationConfig.class);
        //Связываем работу контейнера сервлетов с нашим приложением
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(webApplicationContext);
        servletContext.addListener(contextLoaderListener);

        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

    }
}
