package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import org.springframework.stereotype.Controller;

/**
 * This Controller is used to demonstrate that Spring will inject the
 * component annotated as Primary when multiple instances of the same
 * type exist, and no Qualifier is used.
 *
 * This Controller uses Constructor-based dependency injection. It
 * accepts a {@link GreetingService} through its Constructor and
 * uses it to initialize a private, final property.
 *
 * There is no need to use the Qualifier annotation on the Constructor,
 * as Spring will inject the {@link PrimaryGreetingService}, as it is
 * annotated as the Primary implementation od this type.
 *
 * See {@link ConstructorInjectedController} for an example using the
 * Qualifier annotation.
 */
@Controller
public class PrimaryGreetingController {

    private final GreetingService greetingService;

    public PrimaryGreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
