package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.stereotype.Service;

/**
 * This implementation will be injected into the {@link SetterInjectedController}
 * class using a Qualifier to distinguish it from the other implementations of
 * {@code GreetingService}.
 */
@Service
public class SetterInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {

        return "Hello World - Setter injection!";
    }
}
