package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class GreetingsServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(SFGConfiguration sfgConfiguration)
    {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setJdbcurl(sfgConfiguration.getJdbcurl());
        fakeDataSource.setPassword(sfgConfiguration.getPassword());
        fakeDataSource.setUserName(sfgConfiguration.getUserName());
        return fakeDataSource;
    }
    @Bean
    EnglishGreetingRepository englishGreetingRepository()
    {
        return new EnglishGreetingRepositoryImpl();
    }
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
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository)
    {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishService()
    {
        return new I18nSpanishGreetingService();
    }
}
