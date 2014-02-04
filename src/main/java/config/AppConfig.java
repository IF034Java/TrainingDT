package config;


import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import rest.DenialCategoryRest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.RuntimeDelegate;

@Configuration
public class AppConfig {

    @ApplicationPath(value = "/")
    public class JaxRsApiApplication extends Application { }

    @Bean
    public JaxRsApiApplication jaxRsApiApplication() {
        return new JaxRsApiApplication();
    }

    @Bean
    JacksonJsonProvider jsonProvider(){
        return (new JacksonJsonProvider());
    }

    @Bean
    AnnotationConfigApplicationContext annotationConfigApplicationContext(){
        return (new AnnotationConfigApplicationContext());
    }

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer() {
        JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(jaxRsApiApplication(), JAXRSServerFactoryBean.class);
        factory.setServiceBean(new DenialCategoryRest());
        factory.setAddress("/"+ factory.getAddress());
        factory.setProvider(jsonProvider());
        return factory.create();
    }
}
