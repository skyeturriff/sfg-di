package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import org.springframework.stereotype.Service;

/**
 * This implementation will be injected into the {@link PropertyInjectedController}
 * class using a Qualifier to distinguish it from the other implementations of
 * {@code GreetingService}.
 */
@Service
public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {

        return "Hello World - Property Injection!";
    }
}
