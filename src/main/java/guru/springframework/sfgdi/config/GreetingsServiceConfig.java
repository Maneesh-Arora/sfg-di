package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

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
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService()
    {
        return new PrimaryGreetingService();
    }
    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService()
    {
        return new SetterInjectedGreetingService();
    }

    @Bean
    @Profile("EN")
    I18nEnglishGreetingService i18nService()
    {
        return new I18nEnglishGreetingService();
    }

    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishService()
    {
        return new I18nSpanishGreetingService();
    }
}
