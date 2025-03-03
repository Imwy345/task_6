package web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "web")
public class WebConfig implements WebMvcConfigurer {
    Logger logger = Logger.getLogger(WebConfig.class.getName());
    // Настройка Thymeleaf
    private final ApplicationContext applicationContext;

    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        logger.severe("SpringResourceTemplateResolver");
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        logger.severe("SpringResourceTemplateResolver return");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        logger.severe("SpringTemplateEngine");
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        logger.severe("SpringTemplateEngine return");
        return templateEngine;
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        logger.severe("ViewResolverRegistry");
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
        logger.severe("ViewResolver end");
    }
}
