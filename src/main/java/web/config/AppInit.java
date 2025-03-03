package web.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.logging.Logger;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    Logger logger = Logger.getLogger(AppInit.class.getName());

    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.severe("AppInit rootConfigClasses");
        return new Class<?>[]{
                HibernateConfig.class};
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.severe("AppInit servletConfigClasses");
        return new Class<?>[]{
                WebConfig.class
        };
    }


    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        logger.severe("AppInit servletMappings");
        return new String[]{"/"};
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        logger.severe("AppInit onStartup");
        super.onStartup(servletContext);
        registerHiddenFieldFilter(servletContext);
    }

    private void registerHiddenFieldFilter(ServletContext servletContext) {
        logger.severe("AppInit registerHiddenFieldFilter");
        servletContext.addFilter("hiddenHttpFieldFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
    }

}
