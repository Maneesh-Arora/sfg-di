package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;


public class PropertyInjectGreetingService implements GreetingService{
    public String sayGreeting() {
        return "Hello World - Property";
    }
}
