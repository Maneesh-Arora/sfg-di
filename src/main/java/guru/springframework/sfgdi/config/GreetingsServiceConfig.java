package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.ConstructorGreetingServiceImpl;
import guru.springframework.sfgdi.services.PropertyInjectGreetingService;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingsServiceConfig {

    @Bean
    ConstructorGreetingServiceImpl constructorGreetingServiceImpl()
    {
        return new ConstructorGreetingServiceImpl();
    }

    @Bean
    PropertyInjectGreetingService propertyInjectGreetingService()
    {
        return new PropertyInjectGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService()
    {
        return new SetterInjectedGreetingService();
    }
}
