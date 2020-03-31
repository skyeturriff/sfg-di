package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.controllers.PrimaryGreetingController;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * This implementation will be injected into the {@link PrimaryGreetingController}.
 * We use the Primary annotation to let Spring know that this class should be
 * injected when the dependant class does not specify a specific implementation
 * using the Qualifier annotation and multiple implementations exist.
 *
 * Note: The Qualifier annotation takes precedence over the Primary annotation.
 */
@Primary
@Service
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - From the PRIMARY Bean!";
    }
}
