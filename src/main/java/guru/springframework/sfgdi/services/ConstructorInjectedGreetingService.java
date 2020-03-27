package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import org.springframework.stereotype.Service;
/**
 * This implementation will be injected into the {@link ConstructorInjectedController}
 * class using a Qualifier to distinguish it from the other implementations of
 * {@code GreetingService}.
 */
@Service
public class ConstructorInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {

        return "Hello World - Constructor injection!";
    }

}
