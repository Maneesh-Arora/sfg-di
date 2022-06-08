package guru.springframework.sfgdi.repositories;

import org.springframework.stereotype.Repository;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
    @Override
    public String getGreeting() {
        return "Hello - English Greeting Service";
    }
}
